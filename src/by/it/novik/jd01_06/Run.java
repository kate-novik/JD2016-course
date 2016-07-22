package by.it.novik.jd01_06;

import java.util.concurrent.TimeUnit;

/**
 * Created by Катя.
 */
public class Run {
    public static void main(String[] args) {
        //Создаем объект TaskA
        TaskA taskA=new TaskA();
        /**
         * Замена в каждом слове текста буквы No 5-ю и 7-ю символом #. Для слов короче 5 корректировку не выполнять.
         */
        System.out.println("");
        taskA.replaceCharInPoem();
        /**
         * Определение количества раз повторения в тексте каждого слова, которое встречается в нем.
         */
        System.out.println("");
        taskA.repeatWords();
        /**
         * В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.
         */
        System.out.println("");
        taskA.countWordsWithVowel();

        //Создаем объект TaskB
        TaskB taskB=new TaskB();
        /**
         * Из текста удалить все слова длины 5, начинающиеся на согласную букву.
         */
        System.out.println("");
        taskB.deleteWords();
        /**
         * Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.
         * В предложениях убрать переносы строк.
         */
        System.out.println("");
        taskB.outputTextSortUpCountOfWords();
        /**
         * Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в случае равенства — по алфавиту.
         */
        System.out.println("");
        taskB.sortDescendingAmountCharactersInWord('а');

        //Создаем объект TaskB
        TaskC taskC=new TaskC();
        /**
         * Выполнить форматирование с выравниванием по обоим краям. Для этого добавить дополнительные пробелы между словами.
         */
        System.out.println("");
        taskC.alignLines();
        /**
         * Сложить из случайных слов стихотворения строку ровно (!) в в миллион символов путем конкатенации.
         * Слова через пробел. Последнее слово нужно подобрать по длине. Сделать со String и StringBuilder, вывести выйгрыш во времени.
         */
        System.out.println("");
        long timeWork1 = taskC.randomWordsFirst();
        System.out.println("");
        long timeWork2 = taskC.randomWordsSecond();
        long win = TimeUnit.MILLISECONDS.toMicros(timeWork1-timeWork2);
        System.out.println("Выйгрыш в скорости равен " + win + "мкс");

        /**
         * Все слова текста рассортировать в порядке убывания их длин, при этом все слова одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.
         * Одинаковые слова сгруппировать и выводить один раз с числом их повторов в тексте. Регистр неважен.
         */
        System.out.println("");
        taskC.sortDescendingLengthOfWords();
    }
}
