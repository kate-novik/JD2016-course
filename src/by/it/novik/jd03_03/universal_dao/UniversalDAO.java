package by.it.novik.jd03_03.universal_dao;


import by.it.novik.jd03_03.connection.ConnectorDB;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Kate Novik.
 */
public class UniversalDAO<TypeOfBean> {
    //Тип бина
    private TypeOfBean bean;
    //Название таблицы
    private String tableName;
    //Поля бина
    private Field[] fields;

    public UniversalDAO(TypeOfBean bean, String tableName) {
        this.bean = bean;
        this.tableName = tableName;
        this.fields = bean.getClass().getDeclaredFields();
    }

    /**
     * Получение объекта TypeOfBean через рефлексию
     * @return Объект TypeOfBean
     */
    private TypeOfBean getBeanInstance () {
        try {
            return (TypeOfBean) bean.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Custom command for operations Create, Update, Delete
     * @param sql Запрос sql на create, update, delete
     * @param returnId true - возвращать id последней записи
     * @return Результат операции create/update/delete
     * @throws SQLException
     */
    private static int executeUpdate(String sql, boolean returnId) {
        int resultQuery = 0;
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            resultQuery = statement.executeUpdate(sql);
            //Проверка sql на запрос id
            if (returnId) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    resultQuery = resultSet.getInt(1);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return resultQuery;
    }

    /**
     * Вставка объекта в таблицу
     * @param bean Объект для вставки
     * @return true - объект записан в таблицу БД
     */
    public boolean create (TypeOfBean bean) {
        //Переменные для вставки в sql запрос
        String queryNames = "";
        String queryValues = "";
        String delimiter = "";
        try {
            //Составляем sql запрос из полей bean
            for (int i = 1; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                queryNames = queryNames.concat(delimiter + f.getName());
                queryValues = queryValues.concat(delimiter + "'" + f.get(bean) + "'");
                delimiter = ", "; //добавим запятую перед каждым последующим полем
            }
        } catch (IllegalAccessException e) {
            System.out.println("Error access to fields" + e);
        }
        //Формируем запрос
        String queryUpdate = "insert INTO " + tableName + " (" + queryNames + ") values(" + queryValues + ")";
        int id = executeUpdate(queryUpdate, true);
        if (id > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(bean, id);
        } catch (IllegalAccessException e) {
            System.out.println("Error access to fields" + e);
        }
        return (id > 0);
    }

    /**
     * Чтение объектов из таблицы по переданному id
     * @param id ID объекта
     * @return Полученный объект TypeOfBean из таблицы
     */
    public TypeOfBean read (int id) {
        List<TypeOfBean> beans = null;
            //Вызываем метод получения всех объектов по условию (id)
            beans = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (beans != null && beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }

    /**
     * Обновление данных в объекте таблице в соответствии с переданным id объекта
     * @param bean Объект для обновления
     * @return true - объект обновлен
     */
    public boolean update(TypeOfBean bean) {
        String query = "UPDATE `" + tableName + "` SET ";
        String delimiter = "";
        try {
            //Формируем поля для обновления в объекте таблицы
            for (int i = 1; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                //добавляем `FieldName` = 'Value', в цикле
                query = query.concat(delimiter + "`" + f.getName() + "` = '" + f.get(bean) + "'");
                delimiter = ", ";
        }
            //Вставляем в запрос условие для обновления (переданный id объекта)
            fields[0].setAccessible(true);
            query = query.concat(" WHERE `" + fields[0].getName() + "` = '" + fields[0].get(bean) + "'");
        } catch (IllegalAccessException e) {
            System.out.println("Error access to fields" + e);
        }
        //System.out.println(sql);
        return (executeUpdate(query, false) > 0);
    }

    /**
     * Удаление записи из таблицы
     * @param bean Объект для удаления
     * @return true - объект удален
     */
    public boolean delete(TypeOfBean bean) {
        String queryUpdate = null;
        try {
            queryUpdate = "DELETE FROM `" + tableName + "` WHERE `" + tableName + "`.`ID` = '" + fields[0].get(bean) + "'";
        } catch (IllegalAccessException e) {
            System.out.println("Error access to fields" + e);
        }
        return (executeUpdate(queryUpdate, false) > 0);
    }

    /**
     * Получение всех объектов из таблицы по условию
     * @param WHERE Условие выборки
     * @return list объектов типа
     * @throws SQLException TypeOfBean
     */
    public List<TypeOfBean> getAll(String WHERE) {
        //Создадим List для прочитанных бинов
        List<TypeOfBean> beans = new ArrayList<>();
        //Запрос на выборку по условию
        String query = "SELECT * FROM " + tableName + " " + WHERE + " ;";
        try (
                Connection connection = ConnectorDB.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                //Создаем бин для вставки полученной строки из результата запроса
                TypeOfBean newBean = getBeanInstance();
                for (int i = 1; i < fields.length + 1; i++) {
                    //перебирая поля бина по очереди извлекаем значения в соответствии с их типом
                    Field f = fields[i - 1];
                    f.setAccessible(true);
                    String strType = f.getType().toString();
                    try {
                        if (f.getType() == Boolean.class || strType.equals("boolean"))
                            f.set(newBean, resultSet.getBoolean(i));
                        if (f.getType() == Byte.class || strType.equals("byte"))
                            f.set(newBean, resultSet.getByte(i));
                        if (f.getType() == Integer.class || strType.equals("int"))
                            f.set(newBean, resultSet.getInt(i));
                        if (f.getType() == Double.class || strType.equals("double"))
                            f.set(newBean, resultSet.getDouble(i));
                        if (f.getType() == Float.class || strType.equals("float"))
                            f.set(newBean, resultSet.getFloat(i));
                        if (f.getType() == Long.class || strType.equals("long"))
                            f.set(newBean, resultSet.getLong(i));
                        if (f.getType() == Short.class || strType.equals("short"))
                            f.set(newBean, resultSet.getShort(i));
                        if (f.getType() == String.class)
                            f.set(newBean, resultSet.getString(i));
                        if (f.getType() == Date.class)
                            f.set(newBean, resultSet.getDate(i));
                    } catch (IllegalAccessException e) {
                        System.out.println("Error access to fields" + e);
                    }
                }
                beans.add(newBean);
            }
        } catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return beans;
    }



}
