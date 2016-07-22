package by.it.novik.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Created by Kate Novik.
 */
public class ConverterJSONToXML extends AbstractConverter {

    public ConverterJSONToXML(Class beanClass) {
        super(beanClass);
    }

    public ConverterJSONToXML(Object bean) {
        super(bean);
    }

    @Override
    public void buildConverter(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        //Получение бина с json
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        if (reader != null){
        bean = gson.fromJson(reader,getBeanClass());
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error input-output" + e);
            }
        }

    }

    @Override
    public String getConverterResult() {
        StringWriter stringWriter = null;
        String xml = "";
        try {
            //Получение xml файла из бина
            JAXBContext jc = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);//Перенос строк
            stringWriter = new StringWriter();
            marshaller.marshal(bean,stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        if (stringWriter!= null){
            xml = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (IOException e) {
                System.out.println("Error input-output" + e);
            }
        }

        return xml;
    }
}
