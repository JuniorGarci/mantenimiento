package com.unah.tareapagos.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unah.tareapagos.modelos.Empleado;
import com.unah.tareapagos.modelos.Pagoshistoricos;
import com.unah.tareapagos.repositories.EmpleadosRepository;
import com.unah.tareapagos.repositories.HistoricospagosRepository;
import com.unah.tareapagos.services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private HistoricospagosRepository historicospagosRepository;

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
     return empleadosRepository.save(empleado);
    }

    @Override
    public boolean eliminarEmpleado(String dni) {
        if (empleadosRepository.existsById(dni)) {
            empleadosRepository.deleteById(dni);
            return true;
        }
        return false;
    }

    @Override
    public Empleado buscarEmpleado(String dni) {
        return empleadosRepository.findById(dni).orElse(null);
    }

    @Override
    public List<Empleado> obtenerTodosEmpleados() {
        return empleadosRepository.findAll();
    }

    @Override
    public List<Pagoshistoricos> obtenerPagosEmpleadoEnFecha(String idEmpleado, LocalDate fechaInicio,
            LocalDate fechaFin) {
                return historicospagosRepository.findByDniAndFechapagoBetween(idEmpleado, fechaInicio, fechaFin);
            }
    
}
