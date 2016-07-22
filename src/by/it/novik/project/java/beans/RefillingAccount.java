package by.it.novik.project.java.beans;

/**
 * Created by Kate Novik.
 */
//Класс DTO
public class RefillingAccount {
    //Номер счета
    private int idAccount;
    //Сумма пополнения
    private double addAmount;

    public RefillingAccount() {
    }

    public RefillingAccount(int idAccount, double addAmount) {
        this.idAccount = idAccount;
        this.addAmount = addAmount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public double getAddAmount() {
        return addAmount;
    }

    public void setAddAmount(double addAmount) {
        this.addAmount = addAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefillingAccount that = (RefillingAccount) o;

        if (idAccount != that.idAccount) return false;
        return Double.compare(that.addAmount, addAmount) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idAccount;
        temp = Double.doubleToLongBits(addAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RefillingAccount{" +
                "idAccount=" + idAccount +
                ", addAmount=" + addAmount +
                '}';
    }
}
