package by.it.novik.jd01_05;

import static java.lang.Math.*;
/**
 * Created by Kate Novik
 */
public class Task3 {

    /**
     * Табулирование функции
     * @param x Параметр
     * @param a_min Минимальное значение параметра a
     * @param a_max Максимальное значение параметра a
     * @param step Шаг изменения параметра a
     */
    public static void printTableOfFunction(double x, double a_min, double a_max, double step){
        System.out.println("|-----------|-------------------------|");
        System.out.println("| parameter |  function               |");
        System.out.println("|-----------|-------------------------|");
        double y;
        for (double a=a_min;a<=a_max;a+=step){
            y=exp(a*x)-3.45*a;
            System.out.format("%-2s%- 10.2f%-2s%-24s%-20s","|",a,"|",y,"|");
            System.out.println("");
        }
        System.out.println("|-----------|-------------------------|");
    }



}
