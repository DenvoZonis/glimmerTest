package bank;

public class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;
    private final String password; // 敏感信息，需要严格保护

    /**
     * 没有做输入合法性校验!
     * @param accountNumber 账号
     * @param accountHolder 持卡人
     * @param initialBalance 初始存款
     * @param password 账户密码
     */
    public BankAccount(String accountNumber, String accountHolder, double initialBalance, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.password = password;
    }

    public void deposit(double amount) {
        //存款的时候应该也需要密码？转账的话另说
        balance += amount;
    }

    public boolean withdraw(double amount, String inputPassword) {
        //这两个验证方法并未完全实现,因为只要求修改可见性
        if (validatePassword(inputPassword)) {
            if (validateAmount(amount)) {
                balance -= amount;
                return true;
            } else  {
                //可提示余额不足
                return false;
            }
        } else  {
            //可提示密码错误
            return false;
        }
    }

    public boolean transfer(BankAccount recipient, double amount, String inputPassword) {
        if  (validatePassword(inputPassword)) {
            if (validateAmount(amount)) {
                //此处必须每一步都要记录,防止系统出现问题导致对账出问题
                recipient.deposit(amount);
                balance -= amount;
                return true;
            } else {
                //余额不足
                return false;
            }
        } else {
            //密码错误
            return false;
        }
    }

    public double getBalance() {
        return  balance;
    }

    public String getAccountInfo() {
        return String.format("账户:%s\n持卡人:%s\n余额:%.2f\n", accountNumber, accountHolder, balance);
    }
    // 只需修改可见性
    private boolean validatePassword(String inputPassword) {
        return true;
    }
    // 只需修改可见性
    private boolean validateAmount(double amount) {
        return true;
    }
}
