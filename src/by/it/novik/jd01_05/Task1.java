package by.it.novik.jd01_05;

import static java.lang.Math.*;
/**
 * Created by Kate Novik
 */
public class Task1 {
    /**
     * Запись на языке арифметического выражения с разбивкой выражения на части
     * @param a Параметр выражения
     * @param x Параметр выражения
     * @return Результат выражения
     */
    public static double option1 (double a, double x){
        double b=cos(pow((pow(x,2)+PI/6),5));
        double c=sqrt(x*pow(a,3));
        double d=log(abs((a-1.12*x)/4));
        double z; //результат выражения
        z=b-c-d;

    return z;
    }

    /**
     * Запись на языке арифметического выражения полным выражением
     * @param a Параметр выражения
     * @param x Параметр выражения
     * @return Результат выражения
     */
    public static double option2 (double a, double x){
        double z; //результат выражения
        z=cos(pow((pow(x,2)+PI/6),5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4)); //результат выражения

        return z;
    }

}
