package com.car.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class CarBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarBackendApplication.class, args);
    }
}

@Component
class DatabaseStartupCheck implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseStartupCheck.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        checkDatabaseConnection();
        showTables();
    }

    private void checkDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.out.println("Database connected successfully.");
            }
        } catch (SQLException e) {
            logger.error("Failed to connect to the database", e);
        }
    }

    private void showTables() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SHOW TABLES")) {
             
            while (resultSet.next()) {
                String table = resultSet.getString(1);
                logger.info("Found table: {}", table);
            }
        } catch (Exception e) {
            logger.error("Error listing tables", e);
        }
    }
}
