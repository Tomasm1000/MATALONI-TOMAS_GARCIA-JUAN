package com.backend.test;

import com.backend.dao.impl.OdontologoDaoEnMemoria;
import com.backend.dao.service.OdontologoService;
import com.backend.entity.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OdontologoServiceEnMemoriaTest {
    private static final List<Odontologo> odontologoList = new ArrayList<>();
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoEnMemoria(odontologoList));

    @Test
    public void deberiaGuardarTresOdontologos() {
        odontologoService.guardarOdontologo(new Odontologo(1, 94673, "Juanito", "López"));
        odontologoService.guardarOdontologo(new Odontologo(2, 67842, "Soledad", "Ramírez"));
        odontologoService.guardarOdontologo(new Odontologo(3, 87795, "Martín", "Acosta"));

        assertEquals(3, odontologoList.size());
        assertEquals(odontologoList.get(0).getNombre(), "Juanito");
        assertEquals(odontologoList.get(1).getApellido(), "Ramírez");
        assertEquals(odontologoList.get(2).getNumeroMatricula(), 87795);
    }

    @Test
    public void deberiaListarTodosLosOdontologos() {
        odontologoService.guardarOdontologo(new Odontologo(1, 94673, "Juanito", "López"));
        odontologoService.guardarOdontologo(new Odontologo(2, 67842, "Soledad", "Ramírez"));
        odontologoService.guardarOdontologo(new Odontologo(3, 87795, "Martín", "Acosta"));

        List<Odontologo> todosLosOdontologos = odontologoService.listarOdontologos();

        assertEquals(odontologoList.size(), todosLosOdontologos.size());
    }
}