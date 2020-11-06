package co.historicoVacuna.fabrica;

import co.historicoVacuna.command.HistoricoVacunaCommand;
import co.historicoVacuna.entity.HistoricoVacunaEntity;
import co.historicoVacuna.model.HistoricoVacuna;
import co.historicoVacuna.model.exception.BussinessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoricoVacunaFabrica {
    public HistoricoVacuna entityToModel(HistoricoVacunaEntity historicoVacunaEntity) throws BussinessException {
        HistoricoVacuna historicoVacuna = new HistoricoVacuna.HistoricoVacunaBuilder()
                .setIdHistorico(historicoVacunaEntity.getIdHistorico())
                .setFechaAplicación(historicoVacunaEntity.getFechaAplicación())
                .setIdPaciente(historicoVacunaEntity.getIdPaciente())
                .setIdVacuna(historicoVacunaEntity.getIdVacuna())
                .build();
        return historicoVacuna;
    }
    public HistoricoVacunaCommand entityToCommand(HistoricoVacunaEntity historicoVacunaEntity) throws BussinessException{
        HistoricoVacunaCommand historicoVacunaCommand = new HistoricoVacunaCommand();
        historicoVacunaCommand.setFechaAplicación(historicoVacunaEntity.getFechaAplicación());
        historicoVacunaCommand.setIdPaciente(historicoVacunaEntity.getIdPaciente());
        historicoVacunaCommand.setIdVacuna(historicoVacunaEntity.getIdVacuna());
        return historicoVacunaCommand;
    }

    public HistoricoVacunaEntity modelToEntity (HistoricoVacuna historicoVacuna) throws BussinessException{
        HistoricoVacunaEntity historicoVacunaEntity = new HistoricoVacunaEntity();
        historicoVacunaEntity.setFechaAplicación(historicoVacuna.getFechaAplicación());
        historicoVacunaEntity.setIdHistorico(historicoVacuna.getIdHistorico());
        historicoVacunaEntity.setIdPaciente(historicoVacuna.getIdPaciente());
        historicoVacunaEntity.setIdVacuna(historicoVacuna.getIdVacuna());
        return historicoVacunaEntity;
    }
    public List<HistoricoVacunaCommand> entityToCommand(List<HistoricoVacunaEntity> listaHistoricoVacunaEntity) throws BussinessException{
        List<HistoricoVacunaCommand> listaHistoricoVacunaCommand = new ArrayList<>();
        listaHistoricoVacunaEntity.forEach(e-> {
            try {
                listaHistoricoVacunaCommand.add(entityToCommand(e));
            } catch (BussinessException exception) {
                exception.printStackTrace();
            }
        });
        return listaHistoricoVacunaCommand;
    }
    public HistoricoVacunaEntity commandToEntity(HistoricoVacunaCommand historicoVacunaCommand) throws BussinessException{
        HistoricoVacunaEntity historicoVacunaEntity = new HistoricoVacunaEntity();
        historicoVacunaEntity.setFechaAplicación(historicoVacunaCommand.getFechaAplicación());
        historicoVacunaEntity.setIdPaciente(historicoVacunaCommand.getIdPaciente());
        historicoVacunaEntity.setIdVacuna(historicoVacunaCommand.getIdVacuna());
        return historicoVacunaEntity;

    }
}
