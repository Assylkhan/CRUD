package com.example.pool;


import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("database");
    private static BoneCPConfig config;

    static {
        String driver = bundle.getString("driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("unable to find driver in classpath ", e);
        }
        config = new BoneCPConfig();
        config.setJdbcUrl(bundle.getString("url"));
        config.setUsername(bundle.getString("user"));
        config.setPassword(bundle.getString("password"));
        config.setMaxConnectionsPerPartition(Integer.valueOf(bundle.getString("maxConnections")));
    }

    public static BoneCP getCP() throws SQLException {
        return new BoneCP(config);
    }
}
