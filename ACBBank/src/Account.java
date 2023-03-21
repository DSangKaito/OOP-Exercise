import java.text.DecimalFormat;

public class Account {
    private Long accountId;
    private String accountName;
    private Double accountMoney;
    public static final Double rate = 0.035;

    public Account(){};

    public Account(Long accountId, String accountName, Double accountMoney) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountMoney = accountMoney;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public Account(Long accountId, String accountName) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountMoney = 50.0;
    }

    DecimalFormat formatter = new DecimalFormat("###,###,###,###,###");

    public String toString() {
        return "Số tài khoản: " + this.accountId + "\n" +
                "Tên tài khoản: " + this.accountName + "\n" +
                "Tiền trong tài khoản: " + formatter.format(this.accountMoney) + ",000 VNĐ";
    }

    public String depositMoney(Double money){
        if (money < 0) return "Số tiền gửi vào phải trên 0.";
        this.accountMoney = this.accountMoney + money;
        return "Nạp tiền thành công!!!";
    }

    public String withdrawMoney(Double money){
        if (money > this.accountMoney) return "Số tiền rút không hợp lệ!!!";
        if (money < 0) return "Số tiền rút không hợp lệ!!!";
        this.accountMoney = this.accountMoney - money;
        return "Rút tiền thành công";
    }

    public String tranferMoney(Double money, Account accountReceive) {
        if (money > this.accountMoney) return "Số tiền chuyển không hợp lệ!!!";
        if (money < 0) return "Số tiền chuyển không hợp lệ!!!";
        this.accountMoney = this.accountMoney - money;
        accountReceive.setAccountMoney(accountReceive.getAccountMoney() + money);
        return "Chuyển tiền thành công!!!";
    }
}
