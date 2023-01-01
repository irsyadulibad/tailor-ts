package polije.ppl.tailor.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import polije.ppl.tailor.data.TransactionStatus;
import polije.ppl.tailor.entity.Transaction;
import polije.ppl.tailor.repository.TransactionRepository;

public class ReportService {
    private Date start, end;
    private TransactionStatus status;
    private TransactionRepository repo;
    private Calendar cal;
    private List<Object> values;
    private StringBuilder qb;

    public ReportService(Date start, Date end, TransactionStatus status) {
        this.start = start;
        this.end = end;
        this.status = status;

        repo = new TransactionRepository();
        cal = Calendar.getInstance();
        values = new ArrayList<>();

        qb = new StringBuilder();
        qb.append("SELECT * FROM transactions WHERE");
    }

    public List<Transaction> getData() {
        String query = composeQuery();
        return repo.customQuery(query, values);
    }

    private String composeQuery() {
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
