package by.it.novik.jd02_10.converter;

/**
 * Created by Kate Novik.
 */
public class ConverterFactory {
    private enum DirectType{
        XML_TO_JSON, JSON_TO_XML
    }

    /**
     * Фабричный метод создания билдеров
     * @param type Тип билдера
     * @param beanClass Тип класса объекта для преобразований
     * @return Созданный билдер
     */
    public AbstractConverter createConverterBuilder (String type, Class beanClass) {
        DirectType directType = DirectType.valueOf(type.toUpperCase());
        switch (directType){
            case XML_TO_JSON :
            {
                return new ConverterXMLToJSON(beanClass);
            }
            case JSON_TO_XML :
            {
                return new ConverterJSONToXML(beanClass);
            }
            default: throw new EnumConstantNotPresentException(directType.getDeclaringClass(),directType.name());
        }
    }
}
