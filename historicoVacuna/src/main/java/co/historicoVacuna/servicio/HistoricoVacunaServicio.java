package co.historicoVacuna.servicio;

import co.historicoVacuna.command.HistoricoVacunaCommand;
import co.historicoVacuna.entity.HistoricoVacunaEntity;

import java.util.Date;
import java.util.List;

public interface HistoricoVacunaServicio {
    String registrarHistorico(HistoricoVacunaCommand historicoVacunaCommand);
    List<HistoricoVacunaCommand> listarHistoricos();
    /*List<HistoricoVacunaCommand> buscarPorFecha(Date fecha);*/
    HistoricoVacunaEntity findById(Long id);
}
