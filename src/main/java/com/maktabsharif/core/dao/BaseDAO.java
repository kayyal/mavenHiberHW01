package com.maktabsharif.core.dao;

import java.io.Serializable;

public interface BaseDAO<E extends Serializable> {

    void create(E e);

    E update(E e);

    E read(Serializable id);

    void delete(Serializable id);


}
