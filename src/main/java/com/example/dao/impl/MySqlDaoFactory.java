package com.example.dao.impl;

import com.example.dao.DaoException;
import com.example.dao.DaoFactory;
import com.example.pool.ConnectionPool;
import com.jolbox.bonecp.BoneCP;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySqlDaoFactory extends DaoFactory {

    private static final Logger log = Logger.getLogger(MySqlDaoFactory.class);
    private static final ResourceBundle resource = ResourceBundle.getBundle("database");
    private BoneCP cp;

    /**
     * constructor in which is initialized ConnectionPool with 10 connections size
     */
    public MySqlDaoFactory() {
        try {
            cp = ConnectionPool.getCP();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void releaseConnections() {
        cp.close();
    }

    /**
     * @return H2DaoManager with initialized Connection
     */
    public MySqlDaoManager getDaoManager() {
        Connection connection = null;
        try {
            connection = cp.getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return new MySqlDaoManager(connection);
    }

    public void setConnectionPool(BoneCP cp) {
        this.cp = cp;
    }
}
