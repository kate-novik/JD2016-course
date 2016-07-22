package by.it.novik.jd01_02;

import by.it.novik.jd01_02.Tasks.TaskA;
import by.it.novik.jd01_02.Tasks.TaskB;
import by.it.novik.jd01_02.Tasks.TaskC;
import by.it.novik.jd01_02.Utils.Util;

import java.io.IOException;
/**
 * Created by Kate Novik.
 */
public class Runner {

    public static void main(String[] args) throws IOException {

        /**
         * Создание объекта класса TaskA1
         */
        TaskA taskA=new TaskA();

        //System.out.println("Введите строку чисел, разделенную пробелами");
        //String line = Util.getOneLine();
        String line = "11 22 343 123 67 456 333 22 853";
        int array[] = Util.lineToIntArray(line);
        System.out.println("Строка чисел "+line);
        //Вывод самого длинного числа и его длины
        System.out.println(taskA.getMaxLen(array));
        //Вывод самого короткого числа и его длины
        System.out.println(taskA.getMinLen(array));
        //Вывод чисел массива, длина которых меньше среднего арифметического массива
        taskA.elementsLessMean(array);
        //Вывод чисел массива, длина которых больше среднего арифметического массива
        taskA.elementsMoreMean(array);
        //Найти число, состоящее из разных цифр и вывести первое из них
        taskA.searchUniqueDigits(array);

        /**
         * Создание объекта класса TaskB
         */
        TaskB taskB=new TaskB();

        //Определить принадлежность значения k интервалу [n,m]
        //System.out.println("Введите число k");
        //String line1 = Util.getOneLine();
        //int k=Integer.parseInt(line1);
        //System.out.println("Введите через пробел значения интервала [n,m]");
        //String line2 = Util.getOneLine();
        //int interval[] = Util.lineToIntArray(line2);
        int[] interval = new int[]{2, 7};
        int k = 8; //Переменная для проверки попадания в интервал
        taskB.toInterval(k, interval);

        //Вывод чисел от 1 до к в виде матрицы NxN слева направо и сверху вниз
        //System.out.println("Введите размер матрицы N и максимальное значение элемента матрицы k");
        //String line2 = Util.getOneLine();
        //int num[] = Util.lineToIntArray(line2);
        //int N=num[0];
        //int K=num[1];
        int N=5; //Количество строк и столбцов в матрице
        int K=15; //Максимальное значение заполнения матрицы
        taskB.printMas(N,K);

        //Найти корни квадратного уравнения ax2+bx+c=0, параметры которого передаются с консоли
        //System.out.println("Введите через пробел параметры квадратного уравнения a, b, c");
        //String line3 = Util.getOneLine();
        //int param[] = Util.lineToIntArray(line3);
        //int a=param[0];
        //int b=param[0];
        //int c=param[0];
        //Параметры квадратного уравнения
        int a=1;
        int b=8;
        int c=1;
        taskB.squareEquation(a,b,c);

        //Ввести число от 1 до 12. Вывести название соответствующего месяца с проверкой на корректность ввода
        int numMonth; //Переменная номера месяца
        do {
            System.out.println("Введите число от 1 до 12");
            String line4 = Util.getOneLine();
            numMonth = Integer.parseInt(line4);
        }
        while (!taskB.printMonth(numMonth));

        /**
         * Создание объекта класса TaskC
         */
        TaskC taskC = new TaskC();
        /*TaskC taskC = new TaskC(new int[][]{
                {-3, -2, 6, 9, 9, 8},
                {-3, -2, 6, 9, 9, 8},
                {-3, -2, 6, 10, 9, 8},
                {-3, -2, 6, 9, 9, 8},
                {-3, 10, 6, 9, 9, 8},
                {-3, 10, 6, 9, 9, 8}
        }, 6);*/

        taskC.task1();
        taskC.task2();
        taskC.task3();
        taskC.task4();
        taskC.task5();
        taskC.task6();
        taskC.task7();

    }


}
