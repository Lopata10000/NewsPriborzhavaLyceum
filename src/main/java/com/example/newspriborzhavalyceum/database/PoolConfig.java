package com.example.newspriborzhavalyceum.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

/** The type Pool config. */
public class PoolConfig implements DataBaseConfig {
    /** The constant dataSource. */
    private static final HikariDataSource dataSource;

    static {
        HikariConfig poolConfiguration = new HikariConfig();
        poolConfiguration.setJdbcUrl(url);
        poolConfiguration.setUsername(user);
        poolConfiguration.setPassword(password);
        poolConfiguration.setMaximumPoolSize(10);
        poolConfiguration.setConnectionTimeout(5000); // 5 секунд - оптимальний таймаут для встановлення з'єднання
        poolConfiguration.setMaxLifetime(18000000); // 5 годин - оптимальний максимальний час життя з'єднання
        poolConfiguration.setPoolName("money-with-soul Pool");
        dataSource = new HikariDataSource(poolConfiguration);
    }

    /**
     * Get data source.
     *
     * @return the data source
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Close data source.
     *
     * @param dataSource the data source
     */
    public void closeDataSource(DataSource dataSource) {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource) dataSource).close();
        }
    }
}
