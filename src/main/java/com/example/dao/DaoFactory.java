package com.example.dao;

import com.example.dao.impl.MySqlDaoFactory;

public abstract class DaoFactory {

    /**
     *
     * @param dbType
     * @return implementation of the interface according to passed database type
     */
    public static DaoFactory getDaoFactory(DatabaseType dbType){
        switch (dbType){
            case  MYSQL: return new MySqlDaoFactory();
            default: return null;
        }
    }

    /**
     * release all connections in connection pool
     */
    public abstract void releaseConnections();

    /**
     *
     * @return concrete implementation of DaoManager
     */
    public abstract DaoManager getDaoManager();
}
