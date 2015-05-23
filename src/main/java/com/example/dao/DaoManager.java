package com.example.dao;

import com.example.dao.impl.MySqlItemDao;

public interface DaoManager {
    public void beginTransaction() throws DaoException;
    public void commit() throws DaoException;
    public void rollback() throws DaoException;

    /**
     *
     * @throws DaoException
     */
    public void close() throws DaoException;

    /**
     * closes connection suppressing or swallowing thrown exception
     */
    public void closeQuietly();

    public ItemDao getItemDao() throws DaoException;
}
