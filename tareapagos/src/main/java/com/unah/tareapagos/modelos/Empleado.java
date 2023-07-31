package com.unah.tareapagos.modelos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {
    @Id
    @Column(name = "dni", length = 20)
    private String dni;
    
    @Column(name = "nombre", length = 50)
    private String nombre;
    
    @Column(name = "apellido", length = 50)
    private String apellido;
    
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso; 

    @OneToMany(mappedBy = "empleado")
    private List<Pagoshistoricos> pagoshistoricos;
}
