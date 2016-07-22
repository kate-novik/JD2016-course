package by.it.novik.jd01_05;

import static java.lang.Math.*;
/**
 * Created by Kate Novik.
 */
public class Task6 {

    /**
     * Инициализация массива
     */
    public static void initArray(){
        int size=30; //Размер одномерного массива
        double[] array=new double[size];
        int i=0;//первая позиция элемента в массиве
        for (double x=5.34; x<9;x+=0.1) {
            array[i] = pow((pow(x, 2) + 4.5), 1.0 / 3);
            if (i == size - 1) {
                break;  }
            i++;
        }
        System.out.println("Сформированный массив элементов");
        printArray(array);
        arrayWithElementsByCondition(array);
    }

    /**
     * Печать массива
     * @param array Массив
     */
    private static void printArray (double[] array){
        int k=1;
        for (int i=0;i<array.length;i++){
            System.out.format("array[%-2d]=%-8.2f",i,array[i]);
            if (k%5==0)
                System.out.println("");
            k++;
        }
        System.out.println("");
    }


    private static void arrayWithElementsByCondition (double[] array){
        int k=0; //Счетчик элементов в массиве, которые больше 3.5
        for (int i=0;i<array.length;i++){
            if (array[i]>3.5){
                k++;
            }
        }
        if (k!=0){
            double[] array_new=new double[k];
            for(int i=0,j=0;i<array.length;i++){
                if (array[i]>3.5){
                    array_new[j]=array[i];
                    j++;
                }
            }
            System.out.println("Массив элементов больше 3.5");
            printArray(array_new);
            System.out.print("Среднее геометрическое элементов массива равно ");
            System.out.println(getGeometricMean(array_new));
        }
        else System.out.println("Элементов больше 3.5 нет");
    }

    /**
     * Вычисление среднего геометрического элементов массива
     * @param array Массив
     * @return Среднее геометрическое
     */
    private static double getGeometricMean (double[] array){
        double mul=1;
        for (double i: array){
            mul*=i;
        }
        return pow(mul,1.0/array.length);
    }
}
