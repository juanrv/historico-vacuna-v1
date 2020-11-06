package co.pacienteController.command;

import lombok.Data;

@Data
public class PacienteCommand {
    private String nombre;
    private String especie;
    private String raza;
    private String nombreDueno;
    private Long telefono;
}
