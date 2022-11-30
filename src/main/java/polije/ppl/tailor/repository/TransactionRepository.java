package polije.ppl.tailor.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.data.TransactionStatus;
import polije.ppl.tailor.entity.Transaction;
import polije.ppl.tailor.util.DatabaseUtil;

public class TransactionRepository implements Repository<Transaction> {
    private static String tableName = Transaction.tableName;

    public List<Transaction> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Transaction> transactions = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                transactions.add(mapToEntity(results));
            }
        } catch (SQLException e) {}

        return transactions;
    }

    public List<Transaction> get(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Transaction> transactions = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " AND ";
            sql += valueKey +" = ?";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                transactions.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return transactions;
    }

    public boolean add(Transaction trans) {
        String sql = "INSERT INTO "+ tableName +" (`status`, `date`, `total`, `note`, `account_id`, `customer_id`) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trans.getStatus().toString());
            stmt.setDate(2, Date.valueOf(trans.getDate()));
            stmt.setInt(3, trans.getTotal());
            stmt.setString(4, trans.getNote());
            stmt.setInt(5, trans.getAccount().getId());
            stmt.setInt(6, trans.getCustomer().getId());
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) {}

        return false;
    }

    public boolean update(Transaction trans) {
        String sql = "UPDATE "+ tableName +" SET status = ?, total = ?, note = ? WHERE transaction_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trans.getStatus().toString());
            stmt.setInt(2, trans.getTotal());
            stmt.setString(3, trans.getNote());
            stmt.setInt(4, trans.getId());

            stmt.executeUpdate();
            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) {}

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE transaction_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return stmt.getUpdateCount() > 0;
        } catch(SQLException e) {}

        return false;
    }

    private Transaction mapToEntity(ResultSet result) throws SQLException {
        int custId = result.getInt("customer_id");
        int accId = result.getInt("account_id");

        Map<String, Object> custKey = new HashMap<>(){{ put("customer_id", custId); }};
        Map<String, Object> accKey = new HashMap<>(){{ put("account_id", accId); }};

        Transaction transaction = new Transaction(
            result.getInt("total"),
            new AccountRepository().get(accKey).get(0),
            new CustomerRepository().get(custKey).get(0),
            result.getDate("date").toLocalDate(),
            result.getString("note"),
            TransactionStatus.valueOf(result.getString("status"))
        );

        transaction.setId(result.getInt("transaction_id"));
        return transaction;
    }
}
