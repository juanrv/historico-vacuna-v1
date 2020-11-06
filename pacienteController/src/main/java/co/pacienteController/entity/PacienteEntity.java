package co.pacienteController.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "paciente")
public class PacienteEntity {
    @Id
    @GeneratedValue
    @Column(name = "idPaciente")
    private Long idPaciente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "especie")
    private String especie;
    @Column(name = "raza")
    private String raza;
    @Column(name = "nombreDueno")
    private String nombreDueno;
    @Column(name = "telefono")
    private Long telefono;
}
