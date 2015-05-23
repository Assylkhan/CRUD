package com.example.dao.impl;

import com.example.dao.DaoException;
import com.example.dao.DaoManager;
import com.example.dao.ItemDao;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDaoManager implements DaoManager {

    private Connection connection = null;

    public MySqlDaoManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void beginTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void commit() throws DaoException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void rollback() throws DaoException {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void close() throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void closeQuietly() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    public ItemDao getItemDao() throws DaoException {
        if (connection == null) throw new DaoException("no connection");
        return new MySqlItemDao(connection);
    }


}
