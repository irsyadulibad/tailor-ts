package polije.ppl.tailor.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.util.DatabaseUtil;

public class AccountRepository implements Repository<Account> {
    private static String tableName = Account.tableName;

    public List<Account> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Account> accounts = new ArrayList<>();

        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet results = statement.executeQuery();

            while(results.next()) {
                accounts.add(mapToEntity(results));
            }
        } catch (SQLException e) {}

        return accounts;
    }

    public Account get(Integer id) {
        String sql = "SELECT * FROM "+ tableName +" WHERE account_id = ?";
        Account account = new Account();

        try(PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) { return mapToEntity(rs); }
        } catch(SQLException e) {}

        return account;
    }

    public List<Account> get(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Account> accounts = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " AND ";
            sql += valueKey +" = ?";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                accounts.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return accounts;
    }

    public List<Account> search(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Account> accounts = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " OR ";
            sql += valueKey +" LIKE CONCAT( '%',?,'%')";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                accounts.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return accounts;
    }

    public Integer add(Account acc) {
        String sql = "INSERT INTO "+ tableName +" (`fullname`, `password`, `email`, `username`, `role`) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, acc.getFullname());
            stmt.setString(2, acc.getPassword());
            stmt.setString(3, acc.getEmail());
            stmt.setString(4, acc.getUsername());
            stmt.setString(5, acc.getRole().toString());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) return rs.getInt(1);
        } catch(SQLException e) { e.printStackTrace(); }

        return 0;
    }

    public boolean update(Account acc) {
        Account account = this.get(acc.getId());
        boolean isChangePass = !account.getPassword().equals(acc.getPassword());
        String sql = "UPDATE "+ tableName +" SET fullname = ?, email = ?, username = ? ";

        if(isChangePass) sql += ", password = ? ";
        sql += "WHERE account_id = " + acc.getId();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, acc.getFullname());
            stmt.setString(2, acc.getEmail());
            stmt.setString(3, acc.getUsername());

            if(isChangePass) stmt.setString(4, acc.getPassword());
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE account_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) { e.printStackTrace(); }

        return false;
    }

    private Account mapToEntity(ResultSet result) throws SQLException {
        Account account = new Account(
            result.getString("fullname"),
            result.getString("email"),
            result.getString("username"),
            result.getString("password"),
            AccountRole.valueOf(result.getString("role"))
        );

        account.setId(result.getInt("account_id"));
        return account;
    }
}
