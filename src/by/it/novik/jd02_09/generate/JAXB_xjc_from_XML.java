package by.it.novik.jd02_09.generate;
//тут нужно указать путь к сгенерированным классам


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXB_xjc_from_XML {
        public static void main(String[ ] args) {
            String sourceXML = "src/by/it/novik/jd02_09/generate/payments-xsd.xml";
            try {

                JAXBContext jc = JAXBContext.newInstance(Users.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader(sourceXML);
                System.out.println("XML-файл прочитан:");
                Users users = (Users) u.unmarshal(reader);
                System.out.println(users);

            } catch (JAXBException e) {
                System.out.println("Error JAXB" + e);
            } catch (FileNotFoundException e) {
                System.out.println("File not found" + sourceXML + e);
            }
        }
    }