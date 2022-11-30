package polije.ppl.tailor.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.TransactionDetail;
import polije.ppl.tailor.util.DatabaseUtil;

public class TransactionDetailRepository implements Repository<TransactionDetail> {
    private static String tableName = TransactionDetail.tableName;

    public List<TransactionDetail> get() {
        String sql = "SELECT * FROM " + tableName;
        List<TransactionDetail> details = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                details.add(mapToEntity(results));
            }
        } catch (SQLException e) {}

        return details;
    }

    public List<TransactionDetail> get(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<TransactionDetail> details = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " AND ";
            sql += valueKey +" = ?";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                details.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return details;
    }

    public boolean add(TransactionDetail detail) {
        String sql = "INSERT INTO "+ tableName +" (`qty`, `price`, `cloth_name`, `transaction_id`, `package_id`) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, detail.getQty());
            stmt.setInt(2, detail.getPrice());
            stmt.setString(3, detail.getClothName());
            stmt.setInt(4, detail.getTransaction().getId());
            stmt.setInt(5, detail.getPackage().getId());

            System.out.println(stmt.toString());
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    public boolean update(TransactionDetail detail) {
        String sql = "UPDATE "+ tableName +" SET cloth_name = ?, qty = ?, price = ? WHERE detail_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, detail.getClothName());
            stmt.setInt(2, detail.getQty());
            stmt.setInt(3, detail.getPrice());
            stmt.setInt(4, detail.getId());

            stmt.executeUpdate();
            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) {}

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE detail_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) {}

        return false;
    }

    private TransactionDetail mapToEntity(ResultSet result) throws SQLException {
        int transId = result.getInt("transaction_id");
        int pkgId = result.getInt("package_id");

        Map<String, Object> transKey = new HashMap<>(){{ put("transaction_id", transId); }};
        Map<String, Object> pkgKey = new HashMap<>(){{ put("package_id", pkgId); }};

        TransactionDetail detail = new TransactionDetail(
            result.getInt("qty"),
            result.getInt("price"),
            new PackageRepository().get(pkgKey).get(0),
            new TransactionRepository().get(transKey).get(0),
            result.getString("cloth_name")
        );

        detail.setId(result.getInt("detail_id"));
        return detail;
    }
}
