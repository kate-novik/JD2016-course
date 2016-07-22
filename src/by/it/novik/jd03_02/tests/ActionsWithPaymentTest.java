package by.it.novik.jd03_02.tests;

import by.it.novik.jd03_02.beans.Payment;
import by.it.novik.jd03_02.crud.ActionsCRUD;
import by.it.novik.jd03_02.crud.ActionsWithPayment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kate Novik.
 */
public class ActionsWithPaymentTest {

    private static ActionsCRUD<Payment,Integer> actionsCRUD;
    private static Payment payment;
    private static List<Payment> listPayments;
    @BeforeClass
    public static void init () {
        actionsCRUD = new ActionsWithPayment();
        payment = new Payment(0, 1, "Перевод средств",2, Date.valueOf("2016-07-13"), 50);
        listPayments = new ArrayList<>();
    }
    @AfterClass
    public static void deleteUsers() throws SQLException {
        System.out.println(listPayments.size());
        for (Payment payment1 : listPayments) {
            actionsCRUD.delete(payment1);
        }
    }

    @Test
    public void create() throws Exception {
        Payment paymentResult = new Payment (payment);
        paymentResult = actionsCRUD.create(paymentResult);
        listPayments.add(paymentResult);
        assertNotNull(paymentResult);
    }

    @Test
    public void read() throws Exception {
        Payment paymentResult = new Payment (payment);
        paymentResult = actionsCRUD.create(paymentResult);
        paymentResult = actionsCRUD.read(paymentResult.getIdPayment());
        listPayments.add(paymentResult);
        assertNotNull(paymentResult);
    }

    @Test
    public void update() throws Exception {
        Payment paymentResult = new Payment (payment);
        paymentResult = actionsCRUD.create(paymentResult);
        paymentResult = actionsCRUD.update(paymentResult);
        listPayments.add(paymentResult);
        assertNotNull(paymentResult);
    }

    @Test
    public void delete() throws Exception {
        Payment paymentResult = new Payment (payment);
        paymentResult = actionsCRUD.create(paymentResult);
        boolean flag = actionsCRUD.delete(paymentResult);
        assertTrue(flag);
    }


}