package by.it.novik.project.java;

/**
 * Created by Kate Novik.
 */
public class Validation {
    private static final String PATTERN_PASSWORD = "^[1-9a-zA-Zа-яА-ЯёЁ]{3,15}$";
    private static final String PATTERN_LOGIN = "^[1-9a-zA-Z]{3,10}$";
    private static final String PATTERN_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String PATTERN_NAME = "^[a-zA-Zа-яА-ЯёЁ]{3,15}$";
    private static final String PATTERN_PHONE = "^\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}$";
    private static final String PATTERN_ADDRESS = "^[1-9a-zA-Zа-яА-ЯёЁ\\s,]{10,40}$";
    private static final String PATTERN_PASSPORT = "^[1-9a-zA-Z\\-0\\s,]{21}$";
    private static final String PATTERN_AMOUNT = "^\\d{1,4}$";
    private static final String PATTERN_ACCOUNT = "^\\d{1,11}$";
    private static final String PATTERN_DESCRIPTION = "^[a-zA-Zа-яА-ЯёЁ\\d\\s]{1,60}$";

    /**
     * Валидация данных в зависимости от типа параметра и переданной строки
     * @param data Строка ввода
     * @param type Тип параметра
     * @return true - данные валидны
     */
    static boolean validDataFromForm (String data, String type) {
        if (data != null && type != null) {
            if (type.equalsIgnoreCase("password") && data.matches(PATTERN_PASSWORD)) {
                return true;
            }
            if (type.equalsIgnoreCase("login") && data.matches(PATTERN_LOGIN)) {
                return true;
            }
            if (type.equalsIgnoreCase("email") && data.matches(PATTERN_EMAIL)) {
                return true;
            }
            if (type.equalsIgnoreCase("phone") && data.matches(PATTERN_PHONE)) {
                return true;
            }
            if (type.equalsIgnoreCase("address") && data.matches(PATTERN_ADDRESS)) {
                return true;
            }
            if (type.equalsIgnoreCase("passport") && data.matches(PATTERN_PASSPORT)) {
                return true;
            }
            if ((type.equalsIgnoreCase("first_name") || type.equalsIgnoreCase("middle_name") ||
                    type.equalsIgnoreCase("last_name")) && data.matches(PATTERN_NAME)) {
                return true;
            }
            if (type.equalsIgnoreCase("amount") && data.matches(PATTERN_AMOUNT)) {
                return true;
            }
            if (type.equalsIgnoreCase("account") && data.matches(PATTERN_ACCOUNT)) {
                return true;
            }
            if (type.equalsIgnoreCase("description") && data.matches(PATTERN_DESCRIPTION)) {
                return true;
            }

        }
        return false;
    }
}
