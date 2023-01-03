package polije.ppl.tailor.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.Measure;
import polije.ppl.tailor.util.DatabaseUtil;

public class MeasureRepository implements Repository<Measure> {
    private static String tableName = Measure.tableName;

    public List<Measure> get() {
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

    public Measure get(Integer id) {
        String sql = "SELECT * FROM "+ tableName +" WHERE measure_id = ?";
        Measure measure = new Measure();

        try(PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) { return mapToEntity(rs); }
        } catch(SQLException e) {}

        return measure;
    }

    public List<Measure> get(Map<String, Object> values) {
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

    public List<Measure> search(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Measure> measures = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " OR ";
            sql += valueKey +" LIKE CONCAT( '%',?,'%')";

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

    public Integer add(Measure meas) {
        String sql = "INSERT INTO "+ tableName +" (`cloth_type`, `items`, `customer_id`) VALUES (?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, meas.getClothType());
            stmt.setString(2, meas.getItems().toString());
            stmt.setInt(3, meas.getCustomer().getId());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
        } catch(SQLException e) { e.printStackTrace(); }

        return 0;
    }

    public boolean update(Measure meas) {
        String sql = "UPDATE "+ tableName +" SET customer_id = ?, cloth_type = ?, items = ? WHERE measure_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, meas.getCustomer().getId());
            stmt.setString(2, meas.getClothType());
            stmt.setString(3, meas.getItems().toString());
            stmt.setInt(4, meas.getId());

            stmt.executeUpdate();
            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE measure_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    private Measure mapToEntity(ResultSet result) throws SQLException {
        int custId = result.getInt("customer_id");

        Measure measure = new Measure(
            new CustomerRepository().get(custId),
            result.getString("cloth_type"),
            result.getString("items")
        );

        measure.setId(result.getInt("measure_id"));
        return measure;
    }
}
