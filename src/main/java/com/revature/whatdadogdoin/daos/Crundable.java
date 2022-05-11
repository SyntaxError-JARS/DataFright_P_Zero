package com.revature.whatdadogdoin.daos;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Crundable<T> {

    // create
    T create(T newObject);

    // read
    T[] findAll() throws IOException;
    T findById(String id);

    // update
    boolean update(T updatedObj);

    // delete
    boolean delete(String id);

}
