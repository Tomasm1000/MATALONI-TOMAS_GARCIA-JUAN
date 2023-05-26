package com.backend.dao.impl;

import com.backend.dao.H2Connection;
import com.backend.dao.IDao;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                odontologo.setId(resultSet.getInt(1));
            }

            connection.commit();
            LOGGER.info("👨‍⚕️ Se guardó al odontólogo " + odontologo);
        } catch (Exception e) {
            LOGGER.error("💣💥 Tuvimos un problema general " + e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("💣💥 Tuvimos un problema con el registro" + e.getMessage());
                    e.printStackTrace();
                } catch (SQLException ex) {
                    LOGGER.error("💣💥 Tuvimos un problema con el SQL " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (Exception e) {
                LOGGER.error("🚫 No se pudo cerrar la conexión: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologoList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = H2Connection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                odontologoList.add(new Odontologo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4)));
            }

            LOGGER.info("🦷 Listando todos los odontólogos: " + odontologoList);
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
        return odontologoList;
    }
}
