package polije.ppl.tailor.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.util.DatabaseUtil;

public class CustomerRepository implements Repository<Customer> {
    private static String tableName = Customer.tableName;

    public List<Customer> get() {
        String sql = "SELECT * FROM " + tableName;
        List<Customer> customers = new ArrayList<>();

        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet results = statement.executeQuery();

            while(results.next()) {
                customers.add(mapToEntity(results));
            }
        } catch (SQLException e) {}

        return customers;
    }

    public List<Customer> get(Map<String, Object> values) {
        int iterate = 0;
        String sql = "SELECT * FROM "+ tableName +" WHERE ";
        List<Customer> customers = new ArrayList<>();

        for(String valueKey: values.keySet()) {
            if(iterate > 0) sql += " AND ";
            sql += valueKey +" = ?";

            iterate++;
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            DatabaseUtil.prepareStmt(stmt, values);;
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                customers.add(mapToEntity(rs));
            }
        }catch(SQLException e) {}

        return customers;
    }

    public boolean add(Customer cust) {
        String sql = "INSERT INTO "+ tableName +" (`fullname`, `age`, `phone`, `address`) VALUES (?, ?, ?, ?)";

        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cust.getFullname());
            statement.setInt(2, cust.getAge());
            statement.setString(3, cust.getPhone());
            statement.setString(4, cust.getAddress());

            statement.executeUpdate();
            return true;
        } catch(SQLException e) {}

        return false;
    }

    public boolean update(Customer cust, Customer data) {
        String sql = "UPDATE "+ tableName +" SET fullname = ?, age = ?, phone = ?, address = ? WHERE customer_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, data.getFullname());
            stmt.setInt(2, data.getAge());
            stmt.setString(3, data.getPhone());
            stmt.setString(4, data.getAddress());
            stmt.setInt(5, cust.getId());

            stmt.executeUpdate();
            return true;
        } catch(SQLException e) {}

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM "+ tableName +" WHERE customer_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;
        } catch(SQLException e) {}

        return false;
    }

    private Customer mapToEntity(ResultSet result) throws SQLException {
        Customer customer = new Customer(
            result.getInt("age"),
            result.getString("fullname"),
            result.getString("phone"),
            result.getString("address")
        );

        customer.setId(result.getInt("customer_id"));
        return customer;
    }
}
