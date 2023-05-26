package com.backend.test;

import com.backend.dao.impl.OdontologoDaoH2;
import com.backend.service.OdontologoService;
import com.backend.entity.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OdontologoServiceH2Test {
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void deberiaGuardarUnOdontologo() {
        Odontologo odontologo = new Odontologo(54175, "Gloria", "Santana");
        Odontologo odontologoRegistrado = odontologoService.guardarOdontologo(odontologo);

        assertEquals(odontologoRegistrado.getId(), 4);
    }

    @Test
    public void deberiaListarTodosLosOdontologos() {
        List<Odontologo> todosLosOdontologos = odontologoService.listarOdontologos();

        assertEquals(todosLosOdontologos.get(0).getNombre(), "Juanito");
        assertEquals(todosLosOdontologos.get(1).getNombre(), "Soledad");
        assertEquals(todosLosOdontologos.get(2).getNombre(), "Martín");
        if (todosLosOdontologos.size() > 3) assertEquals(todosLosOdontologos.get(3).getNombre(), "Gloria");
    }
}