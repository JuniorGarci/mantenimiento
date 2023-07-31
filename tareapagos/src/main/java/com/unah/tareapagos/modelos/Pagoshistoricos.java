package com.unah.tareapagos.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagoshistoricos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pagoshistoricos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpago;
    
    @Column(name = "fechapago")
    private LocalDate fechaPago;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Empleado empleado;
    
    @Column(name = "horastrabajadas")
    private int horasTrabajadas;
    
    @Column(name = "precioporhora")
    private BigDecimal precioPorHora;
    
    @Column(name = "totalsueldo")
    private BigDecimal totalSueldo;

   
}
