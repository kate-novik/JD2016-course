package by.it.novik.jd01_05;

/**
 * Created by Kate Novik
 */
public class Task4 {

    /**
     *Вычисление суммы
     * @param x_min Минимальное значение x
     * @param x_max Максимальное значение x
     * @param step Шаг изменения x
     */
    public static void calculateSum (double x_min, double x_max, double step) {
        double sum=0;
        for (double x=x_min;x<=x_max;x+=step){
            for (int i=6; i<=11;i++){
                sum+=Math.pow(x+2,1.3*i);
            }
            System.out.println("Для x="+x+" сумма sum="+sum);
            sum=0;
        }
    }
}
