package co.historicoVacuna.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "historico")
public class HistoricoVacunaEntity {
    @Id
    @GeneratedValue
    @Column(name = "idHistorico")
    private Long idHistorico;
    @Column(name = "paciente")
    private Long idPaciente;
    @Column(name = "vacuna")
    private Long idVacuna;
    @Column(name = "fechaAplicacion")
    private Date fechaAplicación;

}
