package co.pacienteController.controller;

import co.pacienteController.command.PacienteCommand;
import co.pacienteController.fabrica.PacienteFabrica;
import co.pacienteController.servicio.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteFabrica pacienteFabrica;

    @GetMapping("/listar")
    public List<PacienteCommand> findAll(){
        return pacienteService.listaPacientes();
    }

    @GetMapping("/buscar/{id}")
    public PacienteCommand findById(@PathVariable Long id){
        return pacienteFabrica.entityToCommand(pacienteService.findById(id));
    }
    @PostMapping("/registrar")
    public String registrar(@RequestBody PacienteCommand pacienteCommand){
        return pacienteService.registrarPaciente(pacienteCommand);
    }
}
