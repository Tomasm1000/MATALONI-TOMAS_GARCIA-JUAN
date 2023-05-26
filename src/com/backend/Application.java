package com.backend;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/parcialOdontologos;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

            LOGGER.info("🦷 Creamos todo tu SQL");
        } catch (Exception e) {
            LOGGER.error("💣💥 Tuvimos un problema general " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (Exception e) {
                LOGGER.error("🚫 No se pudo cerrar la conexión: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
