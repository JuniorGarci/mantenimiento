package com.unah.tareapagos.modelos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoEmpleadoRequest {
    
    private String IdEmpleado;
    private int horasTrabajadas;
    private BigDecimal PrecioPorHora;

}
