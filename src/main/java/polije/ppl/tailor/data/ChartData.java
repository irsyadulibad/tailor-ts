package polije.ppl.tailor.data;

public class ChartData {
    private String month;
    private int amount, transactions;

    public ChartData(String month, int amount, int transactions) {
        this.month = month;
        this.amount = amount;
        this.transactions = transactions;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTransactions() {
        return transactions;
    }

    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }
}
