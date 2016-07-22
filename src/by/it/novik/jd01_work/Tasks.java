package by.it.novik.jd01_work;

/**
 * Created by Kate Novik.
 */
public class Tasks {
    /**
     * Вывод промежутка времени в секундах в виде недель, суток, часов, минут, секунд
     * @param s Время в секундах
     */
    public void outputTime(int s) {
        int sec, min, hour, day, week; //Время в секундах, минутах, часах, суток, неделях соответственно
        int m, h, d; //Для хранения промежуточного результата минут, часов, дней
        sec = s % 60;
        m = (s - sec) / 60;
        min = m % 60;
        h = (m - min) / 60;
        hour = h % 24;
        d = (h - hour) / 24;
        day = d % 7;
        week = (d - day) / 7;
        System.out.println("Время в секундах s=" + s + " -это недель " + week + ", суток " + day + ", часов " + hour + ", минут " + min + ", секунд " + sec);
    }

    /**
     * Вывод является ли последняя цифра числа семеркой
     *
     * @param number Число
     */
    public void lastDigitOfNumber(int number) {
        if (number % 10 == 7) { //Находим остаток от деления числа на 10
            System.out.println("Последняя цифра числа number=" + number + " - это 7.");
        } else {
            System.out.println("Последняя цифра числа number=" + number + " - это не 7.");
        }
    }


    /**
     * Определение возможности полностью закрыть прямоугольное отверстие размерами a и b круглой картонкой радиусом r.
     *
     * @param a Сторона a прямоугольника
     * @param b Сторона b прямоугольника
     * @param r Радиус круглого отверстия
     */
    public void fullCoverRectangle(double a, double b, double r) {
        //Чтобы закрыть прямоугольник, круг должен описывать его
        double r2 = Math.pow(r, 2);
        double a2 = Math.pow(a, 2);
        double b2 = Math.pow(b, 2);
        if (r2 >= (a2 + b2)) { //Используем теорему Пифагора
            System.out.println("Можно полностью закрыть прямоугольное отверстие размерами a=" + a + " и b=" + b + " круглой картонкой радиусом r=" + r);
        } else
            System.out.println("Нельзя полностью закрыть прямоугольное отверстие размерами a=" + a + " и b=" + b + " круглой картонкой радиусом r=" + r);

    }

    /**
     * Вывод числа сумма денег с добавлением к нему слово «рублей» в правильном падеже.
     *
     * @param many Сумма денег типа int
     */
    public void addRub(int many) {
        //Правильный падеж вывода слова рубль будем определять по последней цифре суммы денег many
        System.out.print("Сумма денег many= " + many + " ");
        if (many % 10 == 1) {
            System.out.println("рубль");
        } else if (many % 10 >= 2 && many % 10 <= 4) {
            System.out.println("рубля");
        } else System.out.println("рублей");
    }

    /**
     * Вывод в виде трех чисел даты следующего дня.
     *
     * @param day   Номер дня
     * @param month Номер месяца
     * @param year  Год
     */
    public void outputNextDate(int day, int month, int year) {
        //Объявляем переменные, хранящие дату следующего дня и присваиваем им начальные значения текущего дня
        int day_next = day;
        int month_next = month;
        int year_next = year;
        if (day == 30 && (month == 2 || month == 4 || month == 6 || month == 9 || month == 11)) {
            day_next = 1;
            month_next++;
        } else if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
            day_next = 1;
            month_next++;
        } else if (day == 31 && month == 12) {
            day_next = 1;
            month_next = 1;
            year_next++;
        } else if (month == 2 && day == 28) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {//Проверка на високосный год
                day_next++;
            } else {
                day_next = 1;
                month_next++;
            }
        } else day_next++;
        System.out.println("Текущий день day=" + day + ", month=" + month + ", year=" + year + ".");
        System.out.println("Следующий день day=" + day_next + ", month=" + month_next + ", year=" + year_next + ".");
    }

    /**
     * Поиск факториала числа
     * @param number Заданное число
     */
    public void searchFactorial(int number){
        int i=1; //Счетчик
        long factorial=1; //Начальное значение факториала числа number
        do {
            factorial=factorial*i;
            i++;
        }
        while (i<=number);
        System.out.println("Факториал числа "+number+" factorial="+factorial);
    }

    /**
     * Поиск наибольшего значения из последовательности случайных чисел. Ввод чисел прекращается, если очередное число 0.
     */
    public void searchMaxNumber () {
        int max=0;//Начальное значение максимума
        int x=(int)(Math.random()*20);
        while (x!=0){
          if (max<x){
              max=x;
          }
            System.out.print(" "+x);
            x=(int)(Math.random()*20);
        }
        System.out.println("");
        System.out.println("Наибольшее число max="+max);
    }

    /**
     * Определение является ли целое число простым
     * @param number Целое число
     */
    public void simpleNumber (int number){
        int k=0;//Счетчик количества делений числа без остатка
    for (int i=1;i<=number;i++){
        if(number%i==0){
            k++;
        }
    }
    if (k==2) {
    System.out.println("Число number="+number+" является простым");
    }
     else System.out.println("Число number="+number+" не является простым");
    }

    /**
     * Определение является ли целое число простым (с использованием break)
     * @param number Целое число
     */
    public void simpleNumberWithBreak (int number){
        int k=0;//Счетчик количества делений числа без остатка
        for (int i=1;i<=number;i++){
            if(number%i==0){
                k++;
            }
            if (k>2){
                System.out.println("Число number="+number+" не является простым");
                break;}
        }

        if (k==2) {
            System.out.println("Число number="+number+" является простым");
        }
    }

    /**
     * Поиск номера ученика с максимальной оценкой
     * @param amount Количество учеников
     */
    public void positionOfMaxMark (int amount){
        //Создание массива оценок учеников
        int[] marks=new int [amount];
        //Заполняем его случайными числами
        for (int i=0; i<amount;i++){
            marks[i]=(int)(Math.random()*10+1);
        }
        //Вывод оценок учеников
        for (int i=0; i<amount;i++){
            System.out.println("Ученик №"+i+" = "+marks[i]);
        }
        //Поиск № ученика с максимальной оценкой
        int maxMark=marks[0];//Максимальная оценка
        int maxIndex=0;//массив номеров учеников с максимальной оценкой
        for (int i=0;i<amount;i++){
            if (maxMark<marks[i])
            {maxIndex=i;}
        }
        System.out.println("Максимальная оценка у ученика № "+maxIndex);
    }

    /**
     * Инициализация массива случайными числами
     * @param size Размер массива
     * @return Массив
     */
    public int[] initArray (int size){
        int[] array=new int [size];
        //Заполняем его случайными числами
        for (int i=0; i<size;i++){
            array[i]=(int)(Math.random()*20+1);
        }
        //Печать исходного массива
        System.out.print("Массив array={ ");
        for (int i=0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("}");
        return array;
    }

    /**
     * Переворачивание массива
     * @param array Массив
     */
    public void backMassive (int[] array){
        //Переворачиваем массив
        for (int i=0; i<array.length/2;i++){
            int temp=array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }
        //Печать перевернутого массива
        System.out.print("Перевернутый массив array={ ");
        for (int i=0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("}");
    }

    /**
     * Создание двумерного квадратного массива и заполнение его бабочкой
     * @param size Размер массива
     */
    public void initArrayToButterfly (int size) {
        int[][] array = new int[size][size];//Создадим двемерный квадратный массив размера size x size
        //Заполнение верхней половины массива
        for (int i = 0; i <= size / 2; i++) {
            for (int j = i; j < size - i; j++) {
                array[i][j] = 1;
            }
        }
        //Заполнение нижней половины массива
        int k=0;//Счетчик уменьшений заполнения массива единицами
        for (int i = size-1; i >= size/2; i--) {
            for (int j = k; j < size - k; j++) {
                array[i][j] = 1;

            }
            k++;
        }
        //Вывод массива
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println("");
        }
    }




    


}

