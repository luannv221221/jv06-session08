package com.ra.model.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService <T,ID> {
    List<T> findAll();
    boolean saveOrUpdate(T t);
    T findById(ID id);
    void delete(ID id);
}
