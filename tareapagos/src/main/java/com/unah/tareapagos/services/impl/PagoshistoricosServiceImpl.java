package com.unah.tareapagos.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.unah.tareapagos.modelos.Empleado;
import com.unah.tareapagos.modelos.PagoEmpleadoRequest;
import com.unah.tareapagos.modelos.Pagoshistoricos;
import com.unah.tareapagos.repositories.EmpleadosRepository;
import com.unah.tareapagos.repositories.HistoricospagosRepository;
import com.unah.tareapagos.services.PagoshistoricosService;

public class PagoshistoricosServiceImpl implements PagoshistoricosService {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private HistoricospagosRepository historicospagosRepository;

    @Override
    public Pagoshistoricos crearPagoEmpleado(PagoEmpleadoRequest pagoEmpleadoRequest) {
   
         Empleado empleado = empleadosRepository.findById(pagoEmpleadoRequest.getIdEmpleado()).orElse(null);
        if (empleado != null && pagoEmpleadoRequest.getHorasTrabajadas() > 0 && pagoEmpleadoRequest.getPrecioPorHora().compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal totalSueldo = pagoEmpleadoRequest.getPrecioPorHora().multiply(BigDecimal.valueOf(pagoEmpleadoRequest.getHorasTrabajadas()));
            Pagoshistoricos nuevoPago = new Pagoshistoricos(null, LocalDate.now(), empleado, pagoEmpleadoRequest.getHorasTrabajadas(), pagoEmpleadoRequest.getPrecioPorHora(), totalSueldo);
            return historicospagosRepository.save(nuevoPago);
        }
        return null;
    } 
    
}
