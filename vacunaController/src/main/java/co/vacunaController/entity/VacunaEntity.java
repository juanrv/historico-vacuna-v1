package co.vacunaController.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "vacuna")
public class VacunaEntity {
    @Id
    @GeneratedValue
    @Column(name = "idVacuna")
    private Long idVacuna;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaCaducidad")
    private Date fechaCaducidad;
}