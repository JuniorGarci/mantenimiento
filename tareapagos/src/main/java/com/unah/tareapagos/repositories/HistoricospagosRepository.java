package com.unah.tareapagos.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unah.tareapagos.modelos.Pagoshistoricos;

public interface HistoricospagosRepository extends JpaRepository< Pagoshistoricos,Long> {
     List<Pagoshistoricos> findByDniAndFechapagoBetween(String dni, LocalDate fechaInicio, LocalDate fechaFin);
}
