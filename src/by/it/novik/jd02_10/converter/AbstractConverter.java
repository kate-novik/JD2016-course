package by.it.novik.jd02_10.converter;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kate Novik.
 */
public abstract class AbstractConverter <T> {
    //Ссылка на объект-бин
    protected T bean;
    //Класс объекта-бина
    private Class beanClass;

    public AbstractConverter(Class beanClass) {
        bean=null;
        this.beanClass=beanClass;
    }

    public AbstractConverter(T bean) {
        this.bean = bean;
        this.beanClass = bean.getClass();
    }

    public T getBean() {
        return bean;
    }

    public Class getBeanClass () {return beanClass;}

    /**
     * Построение объекта-бина
     * @param filename Имя файла, содержащего объект
     */
    abstract public void buildConverter (String filename);

    /**
     * Получение строки преобразования
     * @return Строка
     */
    abstract public String getConverterResult();

    /**
     * Запись в файл результата построения
     * @param text Результат билдера
     * @param filename Имя файла
     */
    public void writeInFile (String text, String filename) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(filename));
            printWriter.print(text);
        } catch (IOException e) {
            System.out.println("Error input-output" + e);
        }
        finally {
            if (printWriter!=null){
                printWriter.close();
            }
        }
    }
}
