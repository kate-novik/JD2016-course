package by.it.novik.jd01_05;

import static java.lang.Math.*;
/**
 * Created by Kate Novik
 */
public class Task2 {

    /**
     * Вычисление функции
     * @param a Параметр функции
     * @param b Параметр функции
     * @return Значение функции
     */
    public static double calculateFunction (double a, double b){
        double y;
        y=tan(pow(a+b,2))-pow(a+1.5,1.0/3)+a*pow(b,5)-b/(log(pow(a,2)));
        return y;
    }
}
