package by.it.novik.jd02_09.html;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Kate Novik.
 */
public class XSLRunner {
    public static void main(String[] args) {
        //Создаем пути для источника преобразований и результата
        String sourceXSL = "src/by/it/novik/jd02_09/html/payments.xsl";
        String sourceXML = "src/by/it/novik/jd02_09/html/payments.xml";
        String result = "src/by/it/novik/jd02_09/html/payments.html";
        //Создаем фабрику трансформеров
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        //Создаем объект трансформер
        try {
            //Устанавливаем XSL-преобразование
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(sourceXSL));
            //Устанавливаем исходный XML-файл и конечный HTML-файл
            transformer.transform(new StreamSource(sourceXML),new StreamResult(result));
            System.out.println("Transform file " + sourceXML + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + sourceXML + " : " + e);
        }

    }
}
