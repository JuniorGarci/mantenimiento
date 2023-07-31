package com.unah.tareapagos.services;

import java.time.LocalDate;
import java.util.List;

import com.unah.tareapagos.modelos.Empleado;
import com.unah.tareapagos.modelos.Pagoshistoricos;

public interface EmpleadoService {
    public Empleado crearEmpleado(Empleado empleado);
    public boolean eliminarEmpleado(String dni);

    public Empleado buscarEmpleado(String dni);

    public List<Empleado> obtenerTodosEmpleados();

    public List<Pagoshistoricos> obtenerPagosEmpleadoEnFecha(String idEmpleado, LocalDate fechaInicio, LocalDate fechaFin);

}
