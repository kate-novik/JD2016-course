package by.it.novik.jd01_03;

/**
 * Created by Kate Novik.
 */
public class Util {
    /**
     * Преобразование строки ввода с клавиатуры в массив вещественных чисел
     * @param line строка ввода
     * @return массив double
     */
    public static double[] StringLineToIntArray (String line){
    line=line.trim(); //удаление пробелов в начале и в конце строки
    String[] elemString=line.split(" "); //преобразование строки в массив
    int count=elemString.length; //найдем длину массива
    double[] mas=new double[count]; //создали массив для чисел
    for(int i=0;i<count;i++){ //заполнили его
        mas[i]=Double.parseDouble(elemString[i]);
    }
    return mas;
   }

    /**
     * Сортировка массива
     * @param mas Массив
     * @param upDirection если true по возрастанию, false - по убыванию
     * @return Отсортированный массив
     */
    public static double[] sortArray (double[] mas, boolean upDirection){
    for (int i=0;i<mas.length-1;i++){
        for (int j=i+1;j<mas.length;j++){
            if ((upDirection && mas[i]>mas[j])||(!upDirection && mas[i]<mas[j])){
                double m=mas[i];
                mas[i]=mas[j];
                mas[j]=m;
            }
        }
    }
        return mas;
    }

    /**
     * Поиск максимального значения в массиве
     * @param mas Массив
     * @return Максимальный элемент в массиве
     */
    public static double maxArray (double[] mas) {
        if (mas.length == 0) {
            return Double.MAX_VALUE;
        } else {
            double max = mas[0];
            for (double m : mas) {
                if (max < m) {
                    max = m;
                }
            }
            return max;
        }
    }

    /**
     * Поиск минимального значения в массиве
     * @param mas Массив
     * @return Минимальный элемент в массиве
     */
    public static double minArray (double[] mas) {
        if (mas.length == 0) {
            return Double.MIN_VALUE;
        } else {
            double min = mas[0];
            for (double m : mas) {
                if (min > m) {
                    min = m;
                }
            }
            return min;
        }
    }

    /**
     * Умножение матрицы на вектор
     * @param x Двумерный массив
     * @param y Вектор
     * @return Вектор
     */
    public static double [] arrayMulVector (double [][] x, double[] y){
        double[] z=new double[x.length];
        for (int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                z[i]=z[i]+x[i][j]*y[j];
            }
        }
        return z;
    }

    /**
     * Умножение матрицы на матрицу
     * @param x Массив
     * @param y Массив
     * @return Массив
     */
    public static double [][] arrayMulArray (double [][] x, double[][] y){
        double[][] z=new double[x.length][y[0].length];
        for (int i=0;i<x.length;i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        return z;
    }

}
