package polije.ppl.tailor.entity;

import java.util.Date;

import polije.ppl.tailor.data.TransactionStatus;

public class Transaction implements Entity {
    public final static String tableName = "transactions";

    private Integer id, total;
    private String note;
    private Date dueDate, date;
    private TransactionStatus status;
    private Account account;
    private Customer customer;

    public Transaction() {}

    public Transaction(Integer total, Account account, Customer customer, Date date, Date dueDate, String note, TransactionStatus status) {
        this.total = total;
        this.account = account;
        this.customer = customer;
        this.date = date;
        this.dueDate = dueDate;
        this.note = note;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
