package com.unah.tareapagos.services;

import com.unah.tareapagos.modelos.PagoEmpleadoRequest;
import com.unah.tareapagos.modelos.Pagoshistoricos;

public interface PagoshistoricosService {
    public Pagoshistoricos crearPagoEmpleado(PagoEmpleadoRequest pagoEmpleadoRequest);
}
