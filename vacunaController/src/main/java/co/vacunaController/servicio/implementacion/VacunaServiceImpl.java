package co.vacunaController.servicio.implementacion;

import co.vacunaController.command.VacunaCommand;
import co.vacunaController.entity.VacunaEntity;
import co.vacunaController.fabrica.VacunaFabrica;
import co.vacunaController.model.exception.VacunaVencidaException;
import co.vacunaController.repository.VacunaRepository;
import co.vacunaController.servicio.VacunaService;
import co.vacunaController.util.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VacunaServiceImpl implements VacunaService {

    @Autowired
    private VacunaRepository  vacunaRepository;
    @Autowired
    private VacunaFabrica vacunaFabrica;
    @Override
    public String registrarVacuna(VacunaCommand vacunaCommand) {
        validarFechaCaducidad(vacunaCommand.getFechaCaducidad());
        VacunaEntity vacunaEntity = new VacunaEntity();
        vacunaEntity.setNombre(vacunaCommand.getNombre());
        vacunaEntity.setFechaCaducidad(vacunaCommand.getFechaCaducidad());
        vacunaRepository.save(vacunaEntity);
        return Mensajes.REGISTRO_VACUNA_EXISTOSO;
    }

    @Override
    public List<VacunaCommand> listarVacunas() {
        return vacunaFabrica.entityToCommand(vacunaRepository.findAll());
    }

    @Override
    public VacunaEntity findById(Long id) {
        return vacunaRepository.findById(id).orElse(null);
    }

    private void validarFechaCaducidad(Date fechaCaducidad) throws VacunaVencidaException {
        Calendar fechaActual = Calendar.getInstance();
        if(fechaCaducidad.equals(fechaActual.getTime())){
            throw new VacunaVencidaException(Mensajes.FECHA_CADUCIDAD_EXCEDIDA);
        }
    }
}