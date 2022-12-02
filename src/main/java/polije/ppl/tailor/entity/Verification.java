package polije.ppl.tailor.entity;

public class Verification implements Entity {
    public final static String tableName = "verifications";

    private Account account;
    private String code;

    public Verification() {
    }

    public Verification(Account account, String code) {
        this.account = account;
        this.code = code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
