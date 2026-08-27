package framework.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DataAccessObject <T> {
    
    public abstract void insert(T t) throws SQLException;
    public abstract void update(T t) throws SQLException;
    public abstract void delete(T t) throws SQLException;
    
    public abstract T getUnique(Object... values) throws SQLException;
    public abstract ArrayList<T> getAll() throws SQLException;

}