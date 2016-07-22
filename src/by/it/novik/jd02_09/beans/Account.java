package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Account", propOrder = {
        "amount",
        "payment"
})
public class Account {
    @XmlElement(name="Amount",required=true)
    private int amount;
    @XmlElement(name="Payment")
    private ArrayList<Payment> payment;
    @XmlAttribute(name = "idAccount", required = true)
    protected int idAccount;
    @XmlAttribute(name = "state", required = true)
    protected String state;

    public Account() {
    }

    public Account(int amount, ArrayList<Payment> listPayments, int idAccount, String state) {
        this.amount = amount;
        this.payment = listPayments;
        this.idAccount = idAccount;
        this.state = state;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ArrayList<Payment> getListPayments() {
        return payment;
    }

    public void setListPayments(ArrayList<Payment> listPayments) {
        this.payment = listPayments;
    }

    public void addPayment(Payment payment) {
        this.payment.add(payment);
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (amount != account.amount) return false;
        if (idAccount != account.idAccount) return false;
        if (this.payment != null ? !this.payment.equals(account.payment) : account.payment != null)
            return false;
        return state != null ? state.equals(account.state) : account.state == null;

    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + idAccount;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", listPayments=" + payment +
                ", idAccount=" + idAccount +
                ", state='" + state + '\'' +
                '}' + '\n';
    }
}
