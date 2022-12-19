package polije.ppl.tailor.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.Package;
import polije.ppl.tailor.util.DatabaseUtil;

public class PackageRepository implements Repository<Package> {
    private static String tableName = Package.tableName;

    public List<Package> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Package> packages = new ArrayList<>();

        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet results = statement.executeQuery();

            while(results.next()) {
                packages.add(mapToEntity(results));
            }
        } catch (SQLException e) {}

        return packages;
    }

    public Package get(Integer id) {
        String sql = "SELECT * FROM "+ tableName +" WHERE package_id = ?";
        Package pkg = new Package();

        try(PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) { return mapToEntity(rs); }
        } catch(SQLException e) { e.printStackTrace(); }

        return pkg;
    }

    public List<Package> get(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Package> packages = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " AND ";
            sql += valueKey +" = ?";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                packages.add(mapToEntity(rs));
            }
        }catch(SQLException e) { e.printStackTrace(); }

        return packages;
    }

    public List<Package> search(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Package> packages = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " OR ";
            sql += valueKey +" LIKE CONCAT( '%',?,'%')";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                packages.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return packages;
    }

    public Integer add(Package pkg) {
        String sql = "INSERT INTO "+ tableName +" (`name`, `price`) VALUES (?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pkg.getName());
            stmt.setInt(2, pkg.getPrice());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
        } catch(SQLException e) { e.printStackTrace(); }

        return 0;
    }

    public boolean update(Package pkg) {
        String sql = "UPDATE "+ tableName +" SET name = ?, price = ? WHERE package_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pkg.getName());
            stmt.setInt(2, pkg.getPrice());
            stmt.setInt(3, pkg.getId());

            stmt.executeUpdate();
            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE package_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    private Package mapToEntity(ResultSet result) throws SQLException {
        Package pkg = new Package(
            result.getInt("price"),
            result.getString("name")
        );

        pkg.setId(result.getInt("package_id"));
        return pkg;
    }
}
