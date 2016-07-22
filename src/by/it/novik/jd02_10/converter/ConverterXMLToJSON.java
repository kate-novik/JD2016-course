package by.it.novik.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by Kate Novik.
 */
public class ConverterXMLToJSON extends AbstractConverter {

    public ConverterXMLToJSON(Class beanClass) {
        super(beanClass);
    }

    public ConverterXMLToJSON(Object bean) {
        super(bean);
    }

    @Override
    public void buildConverter(String filename) {
        try {
            //Получение бина из xml-файла
            JAXBContext jc = JAXBContext.newInstance(getBeanClass());
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(filename);
            System.out.println("XML-файл прочитан:");
            bean = u.unmarshal(reader);

        } catch (JAXBException e) {
            System.out.println("JAXB error" + e);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден" + e);
        }
    }

    @Override
    public String getConverterResult() {
        //Получение json
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(getBean());
    }
}
