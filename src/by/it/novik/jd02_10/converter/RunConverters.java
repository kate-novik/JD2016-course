package by.it.novik.jd02_10.converter;

import by.it.novik.jd02_09.beans.Users;

/**
 * Created by Kate Novik.
 */
public class RunConverters {
    public static void main(String[] args) {
        //Указываем пути источников и файлов для результата преобразований
        String src = System.getProperty("user.dir") + "/src/by/it/novik/";
        String fileXML = src + "jd02_09/beans/payments-test.xml";
        String fileJSON = src + "jd02_10/files/payments.json";
        String fileXMLResult = src + "jd02_10/files/payments.xml";
        //Создаем пустой объект-бин
        Users user = new Users();
        //Вызываем директора для преобразования xml_to_json для класса Users
        directorOfBuilders("xml_to_json",user,fileXML,fileJSON);
        //Вызываем директора для преобразования json_to_xml для класса Users
        directorOfBuilders("json_to_xml",user,fileJSON,fileXMLResult);
    }

    public static <T> void directorOfBuilders (String typeOfBuild, T user, String fileSource, String fileResult) {
        //Создаем фабрику билдеров
        ConverterFactory converterFactory = new ConverterFactory();
        //Создаем билдера в зависимости от типа преобразований typeOfBuild
        AbstractConverter <T> abstractConverter = converterFactory.createConverterBuilder(typeOfBuild,user.getClass());
        //Запускаем построитель объекта-бина типа T
        abstractConverter.buildConverter(fileSource);
        //Получаем преобразование бина в необходимый тип преобразований в виде строки
        String build = abstractConverter.getConverterResult();
        //Записываем преобразование в файл необходимого типа
        abstractConverter.writeInFile(build,fileResult);
        //Выводиим результат на консоль
        System.out.println(typeOfBuild);
        System.out.println(build);
    }

}
