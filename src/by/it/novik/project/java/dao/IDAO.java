package by.it.novik.project.java.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public interface IDAO<T,ID> {

    /**
     * Создание записи объекта в БД
     * @param object Объект для записи
     * @return true - объект создан
     * @throws SQLException
     */
    boolean create(T object);

    /**
     * Чтение записи (объекта) из БД
     * @param id Номер записи
     * @return Прочтенный объект
     */
    T read(ID id);

    /**
     * Обновление записи объекта в БД
     * @param object Объект для обновления
     * @return true - объект обновлен
     */
    boolean update(T object);

    /**
     * Удаление записи (объекта) из БД
     * @param object Объект для удаления
     * @return true - объект удален
     */
    boolean delete(T object);

    /**
     * Чтение всех элементов по условию where
     * @param where Условие для чтения элементов
     * @return Список прочтенных элементов
     */
    List<T> getAll(String where);
}
