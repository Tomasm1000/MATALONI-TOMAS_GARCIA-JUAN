package com.backend;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES(ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)");
            LOGGER.info("📈 Tabla creada");

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/testParcial", "sa", "sa");
    }
}
