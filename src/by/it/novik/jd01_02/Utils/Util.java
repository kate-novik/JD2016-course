package by.it.novik.jd01_02.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class Util {

    /**
     * Чтение одной строки с консоли
     * @return Строка ввода
     * @throws IOException
     */
    public static String getOneLine() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String rLine = bufferedReader.readLine();
       // bufferedReader.close();
        return rLine;
    }

    /**
     * Преобразование одной строки в массив чисел
     * @param line Строка
     * @return Массив целых чисел
     */
    public static int[] lineToIntArray(String line) {
        String[] strArray = line.split(" ");
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }
}
