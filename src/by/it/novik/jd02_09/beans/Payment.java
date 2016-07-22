package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Payment", propOrder = {
        "source",
        "description",
        "destination",
        "date",
        "amountP"
})
public class Payment {
    @XmlElement(name = "Source", required = true)
    protected int source;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Destination", required = true)
    protected int destination;
    @XmlElement(name = "Date", required = true)
    protected Date date;
    @XmlElement(name = "Amount_p", required = true)
    protected int amountP;
    @XmlAttribute(name = "idPayment", required = true)
    protected int idPayment;

    public Payment() {
    }

    public Payment(int source, String description, int destination, Date date, int amountP, int idPayment) {
        this.source = source;
        this.description = description;
        this.destination = destination;
        this.date = date;
        this.amountP = amountP;
        this.idPayment = idPayment;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmountP() {
        return amountP;
    }

    public void setAmountP(int amountP) {
        this.amountP = amountP;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (source != payment.source) return false;
        if (destination != payment.destination) return false;
        if (amountP != payment.amountP) return false;
        if (idPayment != payment.idPayment) return false;
        if (description != null ? !description.equals(payment.description) : payment.description != null) return false;
        return date != null ? date.equals(payment.date) : payment.date == null;

    }

    @Override
    public int hashCode() {
        int result = source;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + destination;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + amountP;
        result = 31 * result + idPayment;
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "source=" + source +
                ", description='" + description + '\'' +
                ", destination=" + destination +
                ", date=" + date +
                ", amountP=" + amountP +
                ", idPayment=" + idPayment +
                '}' + '\n';
    }
}
