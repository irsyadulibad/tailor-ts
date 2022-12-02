package polije.ppl.tailor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.Verification;
import polije.ppl.tailor.util.DatabaseUtil;

public class VerificationRepository {
    private static String tableName = Verification.tableName;
    private static Connection conn = DatabaseUtil.getConnection();

    public List<Verification> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Verification> verifications = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                verifications.add(mapToEntity(results));
            }
        } catch (SQLException e) {}

        return verifications;
    }

    public List<Verification> get(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Verification> verifications = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " AND ";
            sql += valueKey +" = ?";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                verifications.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return verifications;
    }

    public Integer add(Verification verify) {
        String sql = "INSERT INTO verifications (`account_id`, `code`) VALUES (?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, verify.getAccount().getId());
            stmt.setString(2, verify.getCode());
            stmt.executeUpdate();

            return 1;
        } catch(SQLException e) { e.printStackTrace(); }

        return 0;
    }

    public boolean update(Verification verify) {
        String sql = "UPDATE "+ tableName +" SET code = ? WHERE account_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, verify.getCode());
            stmt.setInt(2, verify.getAccount().getId());
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    public boolean delete(Verification verify) {
        String sql = "DELETE FROM "+ tableName +" WHERE account_id = ? AND code = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, verify.getAccount().getId());
            stmt.setString(2, verify.getCode());
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    private Verification mapToEntity(ResultSet rs) throws SQLException {
        return new Verification(
            new AccountRepository().get(rs.getInt("account_id")),
            rs.getString("code")
        );
    }

}
