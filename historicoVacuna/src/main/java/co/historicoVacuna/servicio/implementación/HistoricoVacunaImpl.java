package co.historicoVacuna.servicio.implementación;

import co.historicoVacuna.command.HistoricoVacunaCommand;
import co.historicoVacuna.dto.PacienteDTO;
import co.historicoVacuna.entity.HistoricoVacunaEntity;
import co.historicoVacuna.fabrica.HistoricoVacunaFabrica;
import co.historicoVacuna.repository.HistoricoVacunaRepository;
import co.historicoVacuna.restclient.PacienteRestClient;
import co.historicoVacuna.servicio.HistoricoVacunaServicio;
import co.historicoVacuna.util.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoricoVacunaImpl implements HistoricoVacunaServicio {

    @Autowired
    HistoricoVacunaFabrica historicoVacunaFabrica;
    @Autowired
    HistoricoVacunaRepository historicoVacunaRepository;

    @Override
    public String registrarHistorico(HistoricoVacunaCommand historicoVacunaCommand) {
        historicoVacunaRepository.save(historicoVacunaFabrica.commandToEntity(historicoVacunaCommand));
        return Mensajes.REGISTRO_HISTORICO_EXISTOSO;
    }

    @Override
    public List<HistoricoVacunaCommand> listarHistoricos() {
        return historicoVacunaFabrica.entityToCommand(historicoVacunaRepository.findAll());
    }

    /*@Override
    public List<HistoricoVacunaCommand> buscarPorFecha(Date fecha) {
        return historicoVacunaFabrica.entityToCommand(historicoVacunaRepository.findByFechaAplicación());
    }*/

    @Override
    public HistoricoVacunaEntity findById(Long id) {
        return historicoVacunaRepository.findById(id).orElse(null);
    }
}
