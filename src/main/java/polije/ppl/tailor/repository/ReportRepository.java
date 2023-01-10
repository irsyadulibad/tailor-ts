/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polije.ppl.tailor.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import polije.ppl.tailor.data.MostItemData;
import polije.ppl.tailor.util.DatabaseUtil;

/**
 *
 * @author ibad
 */
public class ReportRepository {
    private static Connection conn = DatabaseUtil.getConnection();

    public MostItemData getMostItems(String query, List<Object> values) {
        StringBuilder qb = new StringBuilder();
        MostItemData data = new MostItemData();

        qb.append("SELECT COUNT(*) AS total, GROUP_CONCAT(`packages`.`name`) AS `names` ");
        qb.append("FROM `transaction_details` ");
        qb.append("JOIN `packages` ON `transaction_details`.`package_id` = `packages`.`package_id` ");
        qb.append("WHERE `transaction_details`.`transaction_id` IN (");

        try(PreparedStatement stmt = conn.prepareStatement(query)) {
            DatabaseUtil.prepareStmt(stmt, values);

            qb.append(stmt.toString().replace("com.mysql.cj.jdbc.ClientPreparedStatement: ", ""));
            qb.append(") GROUP BY `transaction_details`.`transaction_id` ");
            qb.append("ORDER BY `total` DESC LIMIT 1");

            PreparedStatement statement = conn.prepareStatement(qb.toString());
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                data.setNames(rs.getString("names"));
                data.setQty(rs.getInt("total"));

                return data;
            }
        } catch(SQLException e) { e.printStackTrace(); }

        return data;
    }

    public ResultSet getResult(String query, List<Object> values) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        DatabaseUtil.prepareStmt(stmt, values);
        return stmt.executeQuery();
    }
}
