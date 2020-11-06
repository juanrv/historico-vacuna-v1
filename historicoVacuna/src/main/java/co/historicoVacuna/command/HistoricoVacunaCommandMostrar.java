package co.historicoVacuna.command;

import lombok.Data;

import java.util.Date;
@Data
public class HistoricoVacunaCommandMostrar {
    private Long idPaciente;
    private Long idVacuna;
    private Date fechaAplicación;
    private String nombreMascota;
    private String nombreDueno;
    private String nombreVacuna;
}
