package co.historicoVacuna.controller;


import co.historicoVacuna.command.HistoricoVacunaCommandMostrar;
import co.historicoVacuna.command.HistoricoVacunaCommand;
import co.historicoVacuna.dto.PacienteDTO;
import co.historicoVacuna.dto.VacunaDTO;
import co.historicoVacuna.entity.HistoricoVacunaEntity;
import co.historicoVacuna.fabrica.HistoricoVacunaFabrica;
import co.historicoVacuna.model.exception.PacienteException;
import co.historicoVacuna.model.exception.VacunaException;
import co.historicoVacuna.restclient.PacienteRestClient;
import co.historicoVacuna.restclient.VacunaRestClient;
import co.historicoVacuna.servicio.HistoricoVacunaServicio;
import co.historicoVacuna.util.Mensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoVacunaController {
    @Autowired
    private HistoricoVacunaServicio historicoVacunaServicio;
    @Autowired
    private HistoricoVacunaFabrica historicoVacunaFabrica;
    @Autowired
    private PacienteRestClient pacienteRestClient;
    @Autowired
    private VacunaRestClient vacunaRestClient;

    PacienteDTO pacienteDTO;
    VacunaDTO vacunaDTO;

    @GetMapping("/buscar/{id}")
    public HistoricoVacunaCommandMostrar findById(Long id){
        return entityToCommand(historicoVacunaServicio.findById(id));
    }
    @GetMapping("/listar")
    public List<HistoricoVacunaCommand> listarHistoricos(){
        return historicoVacunaServicio.listarHistoricos();
    }
    /*@GetMapping("/bucar-fecha")
    public List<HistoricoVacunaCommand> buscarPooFecha(Date fecha){
        return historicoVacunaServicio.buscarPorFecha(fecha);
    }*/
    @PostMapping("/registrar")
    public String registrarHistorico(@RequestBody HistoricoVacunaCommand historicoVacunaCommand){
        verificarPaciente(historicoVacunaCommand.getIdPaciente());
        verificarVacuna(historicoVacunaCommand.getIdVacuna());
        return historicoVacunaServicio.registrarHistorico(historicoVacunaCommand);
    }
    private void verificarPaciente(Long id) throws PacienteException{
        if(pacienteRestClient.findById(id) == null){
            throw new PacienteException(Mensajes.PACIENTE_NO_EXISTE);
        }
    }
    private void verificarVacuna(Long id) throws VacunaException{
        if(vacunaRestClient.findById(id) == null){
            throw new VacunaException(Mensajes.VACUNA_NO_EXISTE);
        }
    }

    private HistoricoVacunaCommandMostrar entityToCommand (HistoricoVacunaEntity historicoVacunaEntity){
        pacienteDTO = pacienteRestClient.findById(historicoVacunaEntity.getIdPaciente());
        vacunaDTO = vacunaRestClient.findById(historicoVacunaEntity.getIdVacuna());
        HistoricoVacunaCommandMostrar hIstoricoVacunaCommandMostrar = new HistoricoVacunaCommandMostrar();
        hIstoricoVacunaCommandMostrar.setFechaAplicación(historicoVacunaEntity.getFechaAplicación());
        hIstoricoVacunaCommandMostrar.setIdPaciente(historicoVacunaEntity.getIdPaciente());
        hIstoricoVacunaCommandMostrar.setIdVacuna(historicoVacunaEntity.getIdVacuna());
        hIstoricoVacunaCommandMostrar.setNombreDueno(pacienteDTO.getNombreDueno());
        hIstoricoVacunaCommandMostrar.setNombreMascota(pacienteDTO.getNombre());
        hIstoricoVacunaCommandMostrar.setNombreVacuna(vacunaDTO.getNombre());
        return hIstoricoVacunaCommandMostrar;
    }
}
