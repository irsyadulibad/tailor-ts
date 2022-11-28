package polije.ppl.tailor.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public boolean add(Account acc) {
        String sql = "INSERT INTO "+ tableName +" (`fullname`, `password`, `email`, `username`) VALUES (?, ?, ?, ?)";

        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, acc.getFullname());
            statement.setString(2, acc.getPassword());
            statement.setString(3, acc.getEmail());
            statement.setString(4, acc.getUsername());

            statement.executeUpdate();
            return true;
        } catch(SQLException e) {}

        return false;
    }

    public boolean update(Account acc, Account data) {
        String sql = "UPDATE "+ tableName +" SET fullname = ?, email = ?, username = ? ";

        if(data.getPassword() != null) sql += ", password = ? ";
        sql += "WHERE account_id = " + acc.getId();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, data.getFullname());
            stmt.setString(2, data.getEmail());
            stmt.setString(3, data.getUsername());

            if(data.getPassword() != null) stmt.setString(4, data.getPassword());
            stmt.executeUpdate();

            return true;
        } catch(SQLException e) {}

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE account_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private Account mapToEntity(ResultSet result) throws SQLException {
        Account account = new Account(
            result.getString("fullname"),
            result.getString("email"),
            result.getString("username"),
            result.getString("password")
        );

        account.setId(result.getInt("account_id"));
        return account;
    }
}
