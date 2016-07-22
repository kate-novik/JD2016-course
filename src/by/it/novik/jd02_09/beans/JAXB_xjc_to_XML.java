package by.it.novik.jd02_09.beans;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kate Novik.
 */
public class JAXB_xjc_to_XML {
    public static void main(String[ ] args) {
        //Создаем путь к файлу XML - результату маршаллинга
        String resultXML = "src/by/it/novik/jd02_09/beans/payments-test.xml";
        try {

            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jc.createMarshaller();
            Users users = new Users() { //анонимный класс
                {
                    //Добавляем первого User
                    Roll roll = new Roll (1,"Clients");
                    ArrayList<Roll> listRolls = new ArrayList<>();
                    listRolls.add(roll);
                    Payment payment = new Payment(256773, "Плата за аренду", 5968675, new Date(2016-05-17), 200, 12);
                    ArrayList<Payment> listPayments = new ArrayList<>();
                    listPayments.add(payment);
                    Account account = new Account (268,listPayments,23456,"Working");
                    ArrayList<Account> listAccounts = new ArrayList<>();
                    listAccounts.add(account);
                    User userFirst = new User (1,"Иван","Иванович","Иванов","MC241234, 21.02.2015","+375447512345","г.Минск, ул. Глебки, 5-15",
                            "ivanov@mail.ru","iv_ivan","zaq1@WSX",listRolls,listAccounts);
                    this.addUser(userFirst);
                    //Добавляем второго User
                    Roll roll2 = new Roll (45,"Admin");
                    ArrayList<Roll> listRolls2 = new ArrayList<>();
                    listRolls2.add(roll2);
                    User userSecond = new User (2,"Олег","Иванович","Сидоров","MC241234, 08.02.2016","г.Минск, ул. Московская, 12-7",
                            "+375298763423","sidorov@mail.ru","sid_oleg","kjhgf4566",listRolls2,null);
                    this.addUser(userSecond);

                }

            };
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);//Перенос строк
            marshaller.marshal(users,new FileOutputStream(resultXML));
            System.out.println("Файл XML создан");
            marshaller.marshal(users,System.out);

        } catch (JAXBException e) {
            System.out.println("Error JAXB" + e);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + resultXML + e);
        }
    }
}
