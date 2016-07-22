package by.it.novik.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Kate Novik.
 */
public class Task7 {

    /**
     * Инициализация массива A
     * @return массив A
     */
    public static int[] initArrayA (){
        int size=31;
        int[] arrayA=new int[size];
        for(int i=0;i<size;i++){
            arrayA[i]=(int)round(random()*348+103);
        }
        printArrayA(arrayA);
    return arrayA;
    }

    /**
     * Печать массива
     * @param array Массив A
     */
    private static void printArrayA (int[] array){
        int coll=1;
        System.out.println("Массив A");
        System.out.print('\u2554');
        for (int m=0;m<33;m++)
        System.out.print('\u2550');
        System.out.println('\u2557');
        //System.out.println("");
        for (int i=0;i<array.length;i++){
            System.out.print('\u2551');
            System.out.format("A[%2d]=%3d",i,array[i]);
            if (coll%5==0 || coll==array.length)//Вывод массива в 5 столбцов
            {System.out.print('\u2551');
                System.out.println("");
            }
            coll++;
        }
        System.out.println("");
    }

    /**
     * Печать массива B
     * @param array Массив B
     */
    private static void printArrayB (int[] array){
        int row=round(array.length/5); //Минимальное количество строк вывода массива при максимум 5 столбцов
        System.out.println("Массив B");
        for (int i=0;i<row;i++){
        for (int j=i;j<5*row;j+=row) {
            if (j > array.length - 1) break;
            System.out.format("B[%-2d]=%-8d", j, array[j]);
        }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Инициализация массива B
     * @param arrayA Массив A
     */
    public static void initArrayB (int[] arrayA){
        int count=0;
        for(int i=0;i<arrayA.length;i++){
            if(0.1*arrayA[i]>i){
            count++;
        }}
        int[] arrayB=new int[count];
        for(int i=0,j=0;i<arrayA.length;i++){
            if(0.1*arrayA[i]>i){
            arrayB[j]=arrayA[i];
            j++;}
        }
        sortUpArray(arrayB);//Сортировка массива по возрастанию
        printArrayB(arrayB);
    }

    /**
     * Сортировка массива по возрастанию
     * @param array Массив
     */
    private static void sortUpArray (int[] array) {
        for(int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }





}
