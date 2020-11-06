package co.pacienteController.fabrica;

import co.pacienteController.command.PacienteCommand;
import co.pacienteController.entity.PacienteEntity;
import co.pacienteController.model.Paciente;
import co.pacienteController.model.exception.BussinessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteFabrica {
    public Paciente entityToModel(PacienteEntity pacienteEntity) throws BussinessException {
        Paciente paciente = new Paciente.PacienteBuilder()
                .setIdPaciente(pacienteEntity.getIdPaciente())
                .setTelefono(pacienteEntity.getTelefono())
                .setRaza(pacienteEntity.getRaza())
                .setEspecie(pacienteEntity.getEspecie())
                .setNombre(pacienteEntity.getNombre())
                .setNombreDueno(pacienteEntity.getNombreDueno())
                .build();
        return paciente;
    }
    public PacienteEntity commandaToEntity(PacienteCommand pacienteCommand) throws BussinessException{
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setNombre(pacienteCommand.getNombre());
        pacienteEntity.setEspecie(pacienteCommand.getEspecie());
        pacienteEntity.setNombreDueno(pacienteCommand.getNombreDueno());
        pacienteEntity.setRaza(pacienteCommand.getRaza());
        pacienteEntity.setTelefono(pacienteCommand.getTelefono());
        return pacienteEntity;
    }
    public PacienteCommand entityToCommand(PacienteEntity pacienteEntity) throws BussinessException{
        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setEspecie(pacienteEntity.getEspecie());
        pacienteCommand.setNombre(pacienteEntity.getNombre());
        pacienteCommand.setNombreDueno(pacienteEntity.getNombreDueno());
        pacienteCommand.setRaza(pacienteEntity.getRaza());
        pacienteCommand.setTelefono(pacienteEntity.getTelefono());
        return pacienteCommand;
    }
    public PacienteEntity modelToEntity(Paciente paciente) throws BussinessException{
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setEspecie(paciente.getEspecie());
        pacienteEntity.setIdPaciente(paciente.getIdPaciente());
        pacienteEntity.setNombre(paciente.getNombre());
        pacienteEntity.setNombreDueno(paciente.getNombreDueno());
        pacienteEntity.setRaza(paciente.getRaza());
        return pacienteEntity;
    }
    public List<PacienteCommand> entityToCommand(List<PacienteEntity> listaPacienteEntity) throws BussinessException{
        List<PacienteCommand> listaPacienteCommand = new ArrayList<>();
        listaPacienteEntity.forEach(e-> {
            try {
                listaPacienteCommand.add(entityToCommand(e));
            } catch (BussinessException exception) {
                exception.printStackTrace();
            }
        });
        return listaPacienteCommand;
    }
}
