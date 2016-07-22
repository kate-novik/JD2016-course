package by.it.novik.project.java.beans;


import javax.xml.bind.annotation.*;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Account", propOrder = {
        "balans",
        "fk_Users"
})
public class Account {
    @XmlAttribute(name = "idAccount", required = true)
    private int idAccount;
    @XmlAttribute(name = "state", required = true)
    private String state;
    @XmlElement(name="balans",required=true)
    private double balans;
    @XmlElement(name="fk_Users",required=true)
    private int fk_Users;

    public Account() {
    }

    public Account(int idAccount, double balans, String state, int fk_Users) {
        this.balans = balans;
        this.fk_Users = fk_Users;
        this.idAccount = idAccount;
        this.state = state;
    }

    public Account(Account account) {
        this.balans = account.getBalans();
        this.fk_Users = account.getFk_Users();
        this.idAccount = account.getIdAccount();
        this.state = account.getState();
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

    public double getBalans() {
        return balans;
    }

    public void setBalans(double balans) {
        this.balans = balans;
    }

    public int getFk_Users() {
        return fk_Users;
    }

    public void setFk_Users(int fk_Users) {
        this.fk_Users = fk_Users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (idAccount != account.idAccount) return false;
        if (Double.compare(account.balans, balans) != 0) return false;
        if (fk_Users != account.fk_Users) return false;
        return state != null ? state.equals(account.state) : account.state == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idAccount;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        temp = Double.doubleToLongBits(balans);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + fk_Users;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", state='" + state + '\'' +
                ", balans=" + balans +
                ", fk_Users=" + fk_Users +
                '}' + '\n';
    }
}
