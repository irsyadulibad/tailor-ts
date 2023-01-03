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

import polije.ppl.tailor.util.DatabaseUtil;

/**
 *
 * @author ibad
 */
public class ReportRepository {
    private static Connection conn = DatabaseUtil.getConnection();

    public ResultSet getResult(String query, List<Object> values) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        DatabaseUtil.prepareStmt(stmt, values);
        return stmt.executeQuery();
    }
}
