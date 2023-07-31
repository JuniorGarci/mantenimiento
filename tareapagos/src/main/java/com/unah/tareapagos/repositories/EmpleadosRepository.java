package com.unah.tareapagos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unah.tareapagos.modelos.Empleado;

public interface EmpleadosRepository extends JpaRepository<Empleado, String> {
    
}
