package by.it.novik.jd01_09.utils;

import by.it.novik.jd01_09.entity.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class MapValues {
    // Создание одного объекта в классе Singleton MapValues
    private static Map<String,Variable> instance = new HashMap<>();

    private MapValues() {}

    /**
     * Получение единственного экземпляра класса MapValues
     * @return Экземпляр класса MapValues
     */
    public static Map<String,Variable> getInstance () {
        return MapValues.instance;
    }
}
