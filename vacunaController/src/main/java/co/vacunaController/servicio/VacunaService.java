package co.vacunaController.servicio;

import co.vacunaController.command.VacunaCommand;
import co.vacunaController.entity.VacunaEntity;

import java.util.List;

public interface VacunaService {
    String registrarVacuna(VacunaCommand vacunaCommand);
    List<VacunaCommand> listarVacunas();
    VacunaEntity findById(Long id);
}
