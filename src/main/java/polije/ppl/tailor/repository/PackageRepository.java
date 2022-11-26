package polije.ppl.tailor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.Package;
import polije.ppl.tailor.util.DatabaseUtil;

public class PackageRepository {
    private static Connection conn = DatabaseUtil.getConnection();
    private static String tableName = Package.tableName;

    public static List<Package> get() {
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

    public static List<Package> get(Map<String, Object> values) {
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
        }catch(SQLException e) {}

        return packages;
    }

    public static boolean add(Package pkg) {
        String sql = "INSERT INTO "+ tableName +" (`name`, `price`) VALUES (?, ?)";

        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, pkg.getName());
            statement.setInt(2, pkg.getPrice());

            statement.executeUpdate();
            return true;
        } catch(SQLException e) {}

        return false;
    }

    public static boolean update(Package pkg, Package data) {
        String sql = "UPDATE "+ tableName +" SET name = ?, price = ? WHERE package_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, data.getName());
            stmt.setInt(2, data.getPrice());
            stmt.setInt(3, pkg.getId());

            stmt.executeUpdate();
            return true;
        } catch(SQLException e) {}

        return false;
    }

    public static boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE package_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;
        } catch(SQLException e) {}

        return false;
    }

    private static Package mapToEntity(ResultSet result) throws SQLException {
        return new Package(
            result.getInt("package_id"),
            result.getInt("price"),
            result.getString("name")
        );
    }
}
