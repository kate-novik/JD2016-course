package by.it.novik.jd02_09.generate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Kate Novik.
 */
public class JAXB_xjc_to_XML {
    public static void main(String[ ] args) {
        //Создаем путь к файлу XML - результату маршаллинга
        String resultXML = "src/by/it/novik/jd02_09/generate/payments-marshaller.xml";
        try {

            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jc.createMarshaller();
            Users users = new Users () { //анонимный класс
                {
//                    //Добавляем первого User
//                    User.Roll roll = new User.Roll (1,"Clients");
//                    User.Account account = new User.Account (268,23456,"Working");
//                    Account.Payment payment = new Account.Payment (256773,"Плата за аренду",5968675,"2016-05-17",200,12);
//                    User userFirst = new User ("Иван","Иванович","Иванов","MC241234, 21.02.2015","г.Минск, ул. Глебки, 5-15",
//                            "+375447512345","ivanov@mail.ru","iv_ivan","zaq1@WSX",roll,account,1);
//                    this.addUser(userFirst);
//                    //Добавляем второго User
//                    User.Roll roll = new User.Roll (45,"Admin");
//                    User userSecond = new User ("Иван","Иванович","Иванов","MC241234, 21.02.2015","г.Минск, ул. Глебки, 5-15",
//                            "+375447512345","ivanov@mail.ru","iv_ivan","zaq1@WSX",1);
//                    this.addUser(userSecond);

                }

            };
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
