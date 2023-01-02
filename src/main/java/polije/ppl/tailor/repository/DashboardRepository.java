package polije.ppl.tailor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import polije.ppl.tailor.entity.Account;

import polije.ppl.tailor.data.ChartData;
import polije.ppl.tailor.util.DatabaseUtil;

public class DashboardRepository {
    private static Connection conn = DatabaseUtil.getConnection();
    private static Calendar cal = Calendar.getInstance();

    public int getIncomePerMonth(Date date) {
        cal.setTime(date);

        int total = 0;
        String sql = "SELECT SUM(total) AS total FROM transactions WHERE MONTH(date) = ? AND YEAR(date) = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cal.get(Calendar.MONTH) + 1);
            stmt.setInt(2, cal.get(Calendar.YEAR));

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) total = rs.getInt("total");
        }catch(SQLException e) { e.printStackTrace(); }

        return total;
    }

    public int getTransactionPerMonth(Date date, Account account) {
        cal.setTime(date);

        int total = 0;
        String sql = "SELECT COUNT(*) AS total FROM transactions WHERE MONTH(date) = ? AND YEAR(date) = ? AND account_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cal.get(Calendar.MONTH) + 1);
            stmt.setInt(2, cal.get(Calendar.YEAR));
            stmt.setInt(3, account.getId());

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) total = rs.getInt("total");
        }catch(SQLException e) { e.printStackTrace(); }

        return total;
    }

    public List<ChartData> getChartStats() {
        List<ChartData> data = new ArrayList<>();
        String sql = "SELECT DATE_FORMAT(date, '%M') AS month, SUM(total) AS total, COUNT(*) AS trans FROM transactions GROUP BY YEAR(date), MONTH(date) ORDER BY date LIMIT 5";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                data.add(new ChartData(
                    rs.getString("month"),
                    rs.getInt("total"),
                    rs.getInt("trans")
                ));
            }
        }catch(SQLException e) { e.printStackTrace(); }

        return data;
    }

    public int getCustomerTotal() {
        int total = 0;
        String sql = "SELECT COUNT(*) AS total FROM customers";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) total = rs.getInt("total");
        }catch(SQLException e) { e.printStackTrace(); }

        return total;
    }
}
