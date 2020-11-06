package co.historicoVacuna.model;

import co.historicoVacuna.model.exception.BussinessException;
import co.historicoVacuna.util.Mensajes;
import co.historicoVacuna.util.Validador;

import java.util.Date;

public class HistoricoVacuna {
    private Long idHistorico;
    private Long idPaciente;
    private Long idVacuna;
    private Date fechaAplicación;

    private HistoricoVacuna (){
        super();
    }

    public static class HistoricoVacunaBuilder{
        private Long idHistorico;
        private Long idPaciente;
        private Long idVacuna;
        private Date fechaAplicación;

        public HistoricoVacunaBuilder setIdHistorico(Long idHistorico) {
            this.idHistorico = idHistorico;
            return this;
        }

        public HistoricoVacunaBuilder setIdPaciente(Long paciente) {
            this.idPaciente = paciente;
            return this;
        }

        public HistoricoVacunaBuilder setIdVacuna(Long vacuna) {
            this.idVacuna = vacuna;
            return this;
        }

        public HistoricoVacunaBuilder setFechaAplicación(Date fechaAplicación) {
            this.fechaAplicación = fechaAplicación;
            return this;
        }
        public HistoricoVacuna build() throws BussinessException {
            HistoricoVacuna historicoVacuna = new HistoricoVacuna();
            Validador.numeroNulo(idHistorico, Mensajes.ID_NULO_HISTORICO);
            Validador.numeroCero(idHistorico, Mensajes.ID_CERO_HISTORICO);
            historicoVacuna.idHistorico = idHistorico;
            Validador.numeroNulo(idPaciente, Mensajes.PACIENTE_NO_NULO);
            Validador.numeroCero(idPaciente, Mensajes.PACIENTE_NO_NULO);
            historicoVacuna.idPaciente = idPaciente;
            Validador.numeroNulo(idVacuna, Mensajes.VACUNA_NO_NULA);
            Validador.numeroCero(idVacuna, Mensajes.VACUNA_NO_NULA);
            historicoVacuna.idVacuna = idVacuna;
            Validador.fechaNula(fechaAplicación, Mensajes.FECHA_APLICACION_NULA);
            historicoVacuna.fechaAplicación = fechaAplicación;
            return historicoVacuna;
        }
    }

    public Long getIdHistorico() {
        return idHistorico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public Long getIdVacuna() {
        return idVacuna;
    }

    public Date getFechaAplicación() {
        return fechaAplicación;
    }
}
