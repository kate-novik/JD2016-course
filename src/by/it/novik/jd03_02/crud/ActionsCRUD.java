package by.it.novik.jd03_02.crud;

import java.sql.SQLException;

/**
 * Created by Kate Novik.
 */
public interface ActionsCRUD<T,ID> {

    /**
     * Создание записи объекта в БД
     * @param object Объект для записи
     * @return Записанный объект
     * @throws SQLException
     */
    T create (T object) throws SQLException;

    /**
     * Чтение записи (объекта) из БД
     * @param id Номер записи
     * @return Прочтенный объект
     * @throws SQLException
     */
    T read (ID id) throws SQLException;

    /**
     * Обновление записи объекта в БД
     * @param object Объект для обновления
     * @return Обновленный объект
     * @throws SQLException
     */
    T update (T object) throws SQLException;

    /**
     * Удаление записи (объекта) из БД
     * @param object Объект для удаления
     * @return true - объект удален
     * @throws SQLException
     */
    boolean delete (T object) throws SQLException;
}
