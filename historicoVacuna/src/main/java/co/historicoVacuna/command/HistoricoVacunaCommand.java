package co.historicoVacuna.command;

import lombok.Data;

import java.util.Date;

@Data
public class HistoricoVacunaCommand {
    private Long idPaciente;
    private Long idVacuna;
    private Date fechaAplicación;
}
