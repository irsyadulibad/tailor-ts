package polije.ppl.tailor.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        } catch (SQLException e) { e.printStackTrace(); }

        return details;
    }

    public TransactionDetail get(Integer id) {
        String sql = "SELECT * FROM "+ tableName +" WHERE detail_id = ?";
        TransactionDetail detail = new TransactionDetail();

        try(PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) { return mapToEntity(rs); }
        } catch(SQLException e) { }

        return detail;
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

    public List<TransactionDetail> search(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<TransactionDetail> details = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " OR ";
            sql += valueKey +" LIKE CONCAT( '%',?,'%')";

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

    public Integer add(TransactionDetail detail) {
        String sql = "INSERT INTO "+ tableName +" (`qty`, `price`, `cloth_name`, `transaction_id`, `package_id`) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, detail.getQty());
            stmt.setInt(2, detail.getPrice());
            stmt.setString(3, detail.getClothName());
            stmt.setInt(4, detail.getTransaction().getId());
            stmt.setInt(5, detail.getPackage().getId());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
        } catch(SQLException e) { e.printStackTrace(); }

        return 0;
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
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE detail_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    private TransactionDetail mapToEntity(ResultSet result) throws SQLException {
        int transId = result.getInt("transaction_id");
        int pkgId = result.getInt("package_id");

        TransactionDetail detail = new TransactionDetail(
            result.getInt("qty"),
            result.getInt("price"),
            new PackageRepository().get(pkgId),
            new TransactionRepository().get(transId),
            result.getString("cloth_name")
        );

        detail.setId(result.getInt("detail_id"));
        return detail;
    }
}
