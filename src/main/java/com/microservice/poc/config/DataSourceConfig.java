package com.microservice.poc.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfig {
/*
    @Value("${portal.datasource.driverClassName}")
    private String datasourceDriverClassName;
    @Value("${portal.datasource.url}")
    private String datasourceUrl;
    @Value("${portal.datasource.username}")
    private String datasourceUsername;
    @Value("${portal.datasource.password}")
    private String datasourcePassword;
    @Value("${portal.datasource.max.connection.pool.size}")
    private int maxPoolSize;

    @Bean(name = "h2DS")
    public DataSource datasource() throws IOException {
        final HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(this.datasourceDriverClassName);
        ds.setJdbcUrl(this.datasourceUrl);
        ds.setUsername(this.datasourceUsername);
        ds.setPassword(this.datasourcePassword);
        ds.setMaximumPoolSize(this.maxPoolSize);

        return ds;
    }

    */
}