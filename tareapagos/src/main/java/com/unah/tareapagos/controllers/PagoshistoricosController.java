package com.unah.tareapagos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unah.tareapagos.modelos.PagoEmpleadoRequest;
import com.unah.tareapagos.modelos.Pagoshistoricos;
import com.unah.tareapagos.services.impl.PagoshistoricosServiceImpl;

@RestController
@RequestMapping("/pagos")
public class PagoshistoricosController {
    

    @Autowired
    private PagoshistoricosServiceImpl pagoshistoricosServiceImpl;


     @PostMapping
    public ResponseEntity<Pagoshistoricos> crearPagoEmpleado(@RequestBody PagoEmpleadoRequest pagoEmpleadoRequest) {
        Pagoshistoricos nuevoPago = pagoshistoricosServiceImpl.crearPagoEmpleado(pagoEmpleadoRequest);
        if (nuevoPago != null) {
            return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
