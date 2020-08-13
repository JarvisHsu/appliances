package cn.hellojarvis.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/13 23:49
 */
public class PayAccount {
    private Integer userId;
    private String payPwd;
    private Double balance;

    @Override
    public String toString() {
        return "PayAccount{" +
                "userId=" + userId +
                ", payPwd='" + payPwd + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
