package by.it.novik.project.java.beans;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Payment", propOrder = {
        "fk_Account_Source",
        "description",
        "fk_Account_Destination",
        "payDate",
        "amountPayment"
})
public class Payment {
    @XmlAttribute(name = "idPayment", required = true)
    private int idPayment;
    @XmlElement(name = "fk_Account_Source", required = true)
    private int fk_Account_Source;
    @XmlElement(name = "description", required = true)
    private String description;
    @XmlElement(name = "fk_Account_Destination", required = true)
    private int fk_Account_Destination;
    @XmlElement(name = "payDate", required = true)
    private Date payDate;
    @XmlElement(name = "amountPayment", required = true)
    private double amountPayment;


    public Payment() {
    }

    public Payment(int idPayment, int fk_Account_Source, String description, int fk_Account_Destination, Date payDate,
                   double amountPayment) {
        this.idPayment = idPayment;
        this.fk_Account_Source = fk_Account_Source;
        this.description = description;
        this.fk_Account_Destination = fk_Account_Destination;
        this.payDate = payDate;
        this.amountPayment = amountPayment;
    }

    public Payment(Payment payment) {
        this.idPayment = payment.getIdPayment();
        this.fk_Account_Source = payment.getFk_Account_Source();
        this.description = payment.getDescription();
        this.fk_Account_Destination = payment.getFk_Account_Destination();
        this.payDate = payment.getPayDate();
        this.amountPayment = payment.getAmountPayment();
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getFk_Account_Source() {
        return fk_Account_Source;
    }

    public void setFk_Account_Source(int fk_Account_Source) {
        this.fk_Account_Source = fk_Account_Source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFk_Account_Destination() {
        return fk_Account_Destination;
    }

    public void setFk_Account_Destination(int fk_Account_Destination) {
        this.fk_Account_Destination = fk_Account_Destination;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public double getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(double amountPayment) {
        this.amountPayment = amountPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (idPayment != payment.idPayment) return false;
        if (fk_Account_Source != payment.fk_Account_Source) return false;
        if (fk_Account_Destination != payment.fk_Account_Destination) return false;
        if (Double.compare(payment.amountPayment, amountPayment) != 0) return false;
        if (description != null ? !description.equals(payment.description) : payment.description != null) return false;
        return payDate != null ? payDate.equals(payment.payDate) : payment.payDate == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idPayment;
        result = 31 * result + fk_Account_Source;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + fk_Account_Destination;
        result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
        temp = Double.doubleToLongBits(amountPayment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "idPayment=" + idPayment +
                ", fk_Account_Source=" + fk_Account_Source +
                ", description='" + description + '\'' +
                ", fk_Account_Destination=" + fk_Account_Destination +
                ", payDate=" + payDate +
                ", amountPayment=" + amountPayment +
                '}' + '\n';
    }
}
