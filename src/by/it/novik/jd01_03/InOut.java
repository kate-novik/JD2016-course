package by.it.novik.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class InOut {

    /**
     *Процедура чтения одной строки с консоли
     * @return Возвращает строку с консоли
     * @throws IOException
     */
    public static String consoleStringLine () throws IOException {
        BufferedReader line= new BufferedReader(new InputStreamReader(System.in));
        String out=line.readLine();
        //line.close();
        return out;
    }

    /**
     * Печать двумерного массива
     * @param arr входной многомерный массив
     * @param name имя массива
     */
//    public static void printArray(double [][] arr, String name){
//        for (int i=0; i<arr.length;i++){
//            for (int j=0; i<arr[i].length;i++){
//                System.out.printf(name+"[%1d,%1d]=%-6.1f",i,j,arr[i][j]);
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//    }

    /**
     * Печать одномерного массива
     * @param arr входной одномерный массив
     * @param name имя массива
     * @param cols количество столбцов в строке вывода
     */
    public static void printArray(double [] arr, String name, int cols){
        int col=0;
        for (int i=0; i<arr.length;i++){
            System.out.printf(name+"[% -3d]=%-6.1f ",i,arr[i]);
            col++;
            if (col%cols==0 || i==arr.length-1)
            System.out.println("");
        }

    }

    /**
     * Печать двумерного массива
     * @param m Массив
     */
    public static void printArray2D(double [][] m){
        for (int i=0; i<m.length;i++) { //перебираем строки массива
            for (int j = 0; j < m[i].length; j++) { //перебираем столбцы массива
                System.out.printf("%-6.1f ", m[i][j]); //печатаем один элемент
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Печать двумерного массива с заданным именем
     * @param m Массив
     * @param name Имя массива
     */
    public static void printArray2D(double [][] m, String name){
        for (int i=0; i<m.length;i++) { //перебираем строки массива
            for (int j = 0; j < m[i].length; j++) { //перебираем столбцы массива
                System.out.printf(name + "[%1d,%1d]=%-6.1f ", i,j,m[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }


}
