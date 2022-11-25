package polije.ppl.tailor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.util.DatabaseUtil;

public class AccountRepository {
    private static Connection conn = DatabaseUtil.getConnection();
    private static String tableName = Account.tableName;

    public static List<Account> get() {
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

    public static boolean add(Account acc) {
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

    public static boolean update(Account acc, Account data) {
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

    public static boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE account_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;
        } catch(SQLException e) {}

        return false;
    }

    private static Account mapToEntity(ResultSet result) throws SQLException {
        return new Account(
            result.getInt("id"),
            result.getString("fullname"),
            result.getString("email"),
            result.getString("username"),
            result.getString("password")
        );
    }
}
