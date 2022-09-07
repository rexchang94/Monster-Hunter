package com.capcom.mh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReadDbPropertiesProcessor implements EnvironmentPostProcessor {
    private static final String PROPERTY_SOURCE_NAME = "criteriaConfigProperties";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        Map<String, Object> propertySource = new HashMap<>();

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;

        DataSource ds = DataSourceBuilder.create()
                .username(environment.getProperty("spring.datasource.username"))
                .password(environment.getProperty("spring.datasource.password"))
                .url(environment.getProperty("spring.datasource.url"))
                .driverClassName(environment.getProperty("spring.datasource.driver-class-name")).build();
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("SELECT property_key, property_value from criteria_configs");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                propertySource.put(rs.getString("PROPERTY_KEY"), rs.getString("PROPERTY_VALUE"));
            }
            System.out.println("criteriaConfigProperties = " + propertySource);

            environment.getPropertySources().addFirst(new MapPropertySource(PROPERTY_SOURCE_NAME, propertySource));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
