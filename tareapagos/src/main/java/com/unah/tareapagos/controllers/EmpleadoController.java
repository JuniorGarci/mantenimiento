package com.unah.tareapagos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unah.tareapagos.modelos.Empleado;
import com.unah.tareapagos.modelos.PagoRequest;
import com.unah.tareapagos.modelos.Pagoshistoricos;
import com.unah.tareapagos.services.impl.EmpleadoServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    

    @Autowired
    private EmpleadoServiceImpl empleadoServiceImpl;


     @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoServiceImpl.crearEmpleado(empleado);
        if (nuevoEmpleado != null) {
            return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable String dni) {
        boolean eliminado = empleadoServiceImpl.eliminarEmpleado(dni);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Empleado> buscarEmpleado(@PathVariable String dni) {
        Empleado empleado = empleadoServiceImpl.buscarEmpleado(dni);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerTodosEmpleados() {
        List<Empleado> empleados = empleadoServiceImpl.obtenerTodosEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @PostMapping("/pagos")
    public ResponseEntity<List<Pagoshistoricos>> obtenerPagosEmpleadoEnFecha(@RequestBody PagoRequest pagoRequest) {
        List<Pagoshistoricos> pagos = empleadoServiceImpl.obtenerPagosEmpleadoEnFecha(pagoRequest.getIdEmpleado(), pagoRequest.getFechaInicio(), pagoRequest.getFechaFin());
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

}
