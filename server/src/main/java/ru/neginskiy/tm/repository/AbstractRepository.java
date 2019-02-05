package ru.neginskiy.tm.repository;

import ru.neginskiy.tm.api.IRepository;
import ru.neginskiy.tm.entity.AbstractEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class AbstractRepository<T extends AbstractEntity> implements IRepository<T> {

    Connection connection;

    public abstract void merge(T entity);

    public abstract T getById(String id);

    public abstract List<T> getAll();

    public abstract T delete(String id);

    abstract T fetch(ResultSet resultSet) throws SQLException;

    abstract List<T> fetchAll(ResultSet resultSet) throws SQLException;

/*    List<T> fetchAll(ResultSet resultSet) throws SQLException {
        final List<T> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(fetch(resultSet));
        }
        return resultList;
    }*/
}
