package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologoList;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologoList) {
        this.odontologoList = odontologoList;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologoList.add(odontologo);
        LOGGER.info("👨‍⚕️ Se guardó al odontólogo " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("🦷 Listando todos los odontólogos: " + odontologoList);
        return odontologoList;
    }
}
