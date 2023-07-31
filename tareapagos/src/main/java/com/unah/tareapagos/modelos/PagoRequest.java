package com.unah.tareapagos.modelos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PagoRequest {
    
    private String IdEmpleado;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;
}
