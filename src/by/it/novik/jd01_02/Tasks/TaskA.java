package by.it.novik.jd01_02.Tasks;

/**
 * Created by Kate Novik.
 */

public class TaskA {

    /**
     *  Метод поиска самого длинного числа и вывод его длины
     * @param array Массив целых чисел
     * @return Строка
     */
    public String getMaxLen (int array[]){
        //Задаем число с максимальной длиной
        Integer max=0;
        //Задаем минимальную длину
        Integer lenMax=1;
        for (Integer i : array){
            Integer len = i.toString().length();
            if (lenMax<=len) {
                lenMax = len;
                max=i;
            }
        }
        return "Самое длинное число Max= " + max.toString() + " length=" + lenMax.toString();
    }

    /**
     * Метод поиска самого короткого числа и вывод его длины
     * @param array Массив целых чисел
     * @return Строка
     */
    public String getMinLen (int array[]){

        //Задаем число с максимальной длиной
        Integer min=Integer.MAX_VALUE;
        //Задаем максимальную длину
        Integer lenMin=min.toString().length();
        for (Integer i : array){
            Integer len = i.toString().length();
            if (lenMin>=len) {
                lenMin = len;
                min=i;
            }
        }
        return "Самое короткое число Min= " + min.toString() + " length=" + lenMin.toString();
    }

    /**
     * Метод вычисления среднего арифметического элементов массива
     * @param array Массив целых чисел
     * @return Среднее арифметическое типа  double
     */
    private double mean (int array[]){
        double res=0;
        //Цикл вычисления суммы чисел
        for (int i: array)
        { res+=i; }
        res/=array.length;
        return res;
    }

    /**
     * Вывод чисел массива, длина которых меньше среднего арифметического массива
     * @param array Массив типа int
     */
    public void elementsLessMean(int array[]){
        double mean1 =mean(array);
        System.out.println("Вывод чисел меньше mean= " + mean1);
        for (int i : array) {
            if (i < mean1) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

    /**
     * Вывод чисел массива, длина которых больше среднего арифметического массива
     * @param array Массив типа int
     */
    public void elementsMoreMean(int array[]){
        double mean2 = mean(array);
        System.out.println("Вывод чисел больше mean= " + mean2);
        for (int i : array) {
            if (i > mean2) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

    /**
     * Метод проверки числа на одинаковость цифр
     * @param value Число типа Integer
     * @return true-нет одинаковых цифр, false - есть одинаковые цифры
     */
    private boolean uniqueDigits (Integer value){
    char ch[]=Integer.toString(value).toCharArray();
      //Цикл для сравнения первой цифры числа с остальными цифрами
            for (int j = 1; j < ch.length; j++) {
                if (ch[0] == ch[j]) {
                    return false; //есть одинаковые цифры
                }
            }

        return true; //нет одинаковых цифр
    }

    /**
     * Вывод первого числа в массиве, состоящего из разных цифр
     * @param array Массив типа int
     */
    public void searchUniqueDigits (int array[]){
        for (Integer i : array) {
            if (i.toString().length() >= 2) {
                if (uniqueDigits(i)) {
                    System.out.println("Число из разных цифр " + i);
                    break;
                }
            }
        }
    }
}
