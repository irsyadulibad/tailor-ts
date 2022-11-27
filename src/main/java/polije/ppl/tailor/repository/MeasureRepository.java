package polije.ppl.tailor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.Measure;
import polije.ppl.tailor.util.DatabaseUtil;

public class MeasureRepository {
    private static Connection conn = DatabaseUtil.getConnection();
    private static String tableName = Measure.tableName;

    public static List<Measure> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Measure> measures = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                measures.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return measures;
    }

    public static List<Measure> get(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Measure> measures = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " AND ";
            sql += valueKey +" = ?";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                measures.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return measures;
    }

    public static boolean add(Measure meas) {
        String sql = "INSERT INTO "+ tableName +" (`cloth_type`, `items`, `customer_id`) VALUES (?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, meas.getClothType());
            stmt.setString(2, meas.getItems().toString());
            stmt.setInt(3, meas.getCustomer().getId());
            stmt.executeUpdate();

            return true;
        } catch(SQLException e) {}

        return false;
    }

    public static boolean update(Measure meas, Measure data) {
        String sql = "UPDATE "+ tableName +" SET cloth_type = ?, items = ? WHERE measure_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, data.getClothType());
            stmt.setString(2, data.getItems().toString());
            stmt.setInt(3, meas.getId());

            stmt.executeUpdate();
            return true;
        } catch(SQLException e) {}

        return false;
    }

    public static boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE measure_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;
        } catch(SQLException e) {}

        return false;
    }

    private static Measure mapToEntity(ResultSet result) throws SQLException {
        int custId = result.getInt("customer_id");
        Map<String, Object> keyword = new HashMap<>(){{ put("customer_id", custId); }};

        return new Measure(
            result.getInt("measure_id"),
            CustomerRepository.get(keyword).get(0),
            result.getString("cloth_type"),
            result.getString("items")
        );
    }
}
