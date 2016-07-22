package by.it.novik.jd01_02.Tasks;

/**
 * Created by Kate Novik.
 */
public class TaskB {
    /**
     * Определение принадлежности значения k к интервалу
     * @param k Искомое значение
     * @param interval Интервал значений
     */
    public void toInterval (int k, int[] interval){
        //Цикл на вхождение значения k в интервал, заданный во входном   массиве
        int n=0; //Переменная вхождения числа к в интервал
            for (int i = interval[0]; i <= interval[1]; i++) {
                if (k == i) {
                    k++;
                }
            }
        if (k!=0){
        System.out.println("Значение k=" + k + " входит в интервал [" + interval[0] + "," + interval[1] + "]");}
        else {System.out.println("Значение k=" + k + " не входит в интервал [" + interval[0] + "," + interval[1] + "]");}

    }

    /**
     * Вывод чисел от 1 до к в виде матрицы NxN слева направо и сверху вниз
     * @param n Размер матрицы
     * @param k Максимальное значение элемента матрицы
     */
    public void printMas (int n, int k){
        //Задаем начальное значение элемента в массиве
        int m=1;
        int mas [][]=new int [n][n];
        System.out.println("Вывод чисел от 1 до "+k+" в виде матрицы "+n+"x"+n+" слева направо и сверху вниз");
        for (int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (m<=k && m<=n*n) {
                mas[i][j]=m++;} //Присваиваем элементу матрицы значение m, после чего увеливаем его на 1
                else {mas[i][j]=0;}
                System.out.format("%-4d", mas[i][j]);   // Вывод на печать элементов массива в виде матрицы
            }
            System.out.println("");
        }
    }

    /**
     * Поиск корней квадратного уравнения ax2+bx+c=0
     * @param a Параметр a уравнения
     * @param b Параметр b уравнения
     * @param c Параметр c уравнения
     */
    public void squareEquation (int a, int b, int c){
        //Находим дискриминанту квадратного уравнения D=b2-4ac
        double D=Math.pow(b,2)-4*a*b;
        //Корни квадратного уравнения
        double x1;
        double x2;
        //Если дискриминанта D>0, то корни равны x1=(–b+√D)/2a, x2=(–b−√D)/2a
        System.out.println("Корни уравнения ax2+bx+c=0 при a="+a+", b="+b+", c="+c);
        if (D>0){
            x1=(-b+Math.sqrt(D))/2*a;
            x2=(-b-Math.sqrt(D))/2*a;
            System.out.println("Корни уравнения x1=" + x1 + ", x2=" + x2);
        }
        //Если дискриминанта D=0, то корни равны x1=x2=–b/2a;
        else if(D==0){
            x1=-b/2*a;
            System.out.println("Корень уравнения x=" + x1);
        }
        else {System.out.println("Корней нет");}
    }

    /**
     * Вывод названия месяца по переданному числу
     * @param numMonth Номер месяца
     * @return true - месяц найден, false - месяц не найден
     */
    public boolean printMonth (int numMonth){
        if (numMonth<1 || numMonth>12){
            return false;
        }
        switch (numMonth){
            case 1: {System.out.println("Месяц n="+numMonth+" Январь");break;}
            case 2: {System.out.println("Месяц n="+numMonth+" Февраль");break;}
            case 3: {System.out.println("Месяц n="+numMonth+" Март");break;}
            case 4: {System.out.println("Месяц n="+numMonth+" Апрель");break;}
            case 5: {System.out.println("Месяц n="+numMonth+" Май");break;}
            case 6: {System.out.println("Месяц n="+numMonth+" Июнь");break;}
            case 7: {System.out.println("Месяц n="+numMonth+" Июль");break;}
            case 8: {System.out.println("Месяц n="+numMonth+" Август");break;}
            case 9: {System.out.println("Месяц n="+numMonth+" Сентябрь");break;}
            case 10: {System.out.println("Месяц n="+numMonth+" Октябрь");break;}
            case 11: {System.out.println("Месяц n="+numMonth+" Ноябрь");break;}
            case 12: {System.out.println("Месяц n="+numMonth+" Декабрь");break;}
        }
        return true;
    }

}
