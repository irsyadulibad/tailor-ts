package polije.ppl.tailor.service;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import polije.ppl.tailor.data.MostItemData;
import polije.ppl.tailor.data.TransactionStatus;
import polije.ppl.tailor.entity.Transaction;
import polije.ppl.tailor.repository.ReportRepository;
import polije.ppl.tailor.repository.TransactionRepository;

public class ReportService {
    private Date start, end;
    private TransactionStatus status;
    private TransactionRepository repo;
    private ReportRepository report;
    private Calendar cal;
    private List<Object> values;
    private StringBuilder qb;

    public ReportService(Date start, Date end, TransactionStatus status) {
        this.start = start;
        this.end = end;
        this.status = status;

        repo = new TransactionRepository();
        report = new ReportRepository();
        cal = Calendar.getInstance();
        values = new ArrayList<>();

        qb = new StringBuilder();
        qb.append("SELECT * FROM transactions");
    }

    public List<Transaction> getData() {
        String query = composeQuery(false);
        return repo.customQuery(query, values);
    }

    public MostItemData getMostItems() {
        String query = composeQuery(false)
            .replace("SELECT *", "SELECT transaction_id");
        return report.getMostItems(query, values);
    }

    public void generate() {
        String query = composeQuery(true);

        try(ResultSet rs = report.getResult(query, values)) {
            InputStream jasperFile = getClass().getResourceAsStream("/stubs/reports/transactionReport.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jasperFile);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<>(), rsDataSource);

            JasperViewer.viewReport(jp, false);
        } catch(Exception e) { e.printStackTrace(); }
    }

    private String composeQuery(boolean isJoined) {
        if(isJoined) qb.append(" JOIN customers ON transactions.customer_id = customers.customer_id");

        qb.append(" WHERE");

        if((start != null) && (end != null)) {
            qb.append(" date BETWEEN ? AND ?");

            values.add(start);
            values.add(end);
        } else {
            qb.append(" MONTH(date) = ? AND YEAR(date) = ?");

            if((start != null) && (end == null)) cal.setTime(start);

            values.add(cal.get(Calendar.MONTH) + 1);
            values.add(cal.get(Calendar.YEAR));
        }

        if(status != null) {
            qb.append(" AND status = ?");
            values.add(status);
        }

        return qb.toString();
    }
}
