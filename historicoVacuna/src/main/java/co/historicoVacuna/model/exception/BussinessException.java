package co.historicoVacuna.model.exception;

public class BussinessException extends RuntimeException{
    public BussinessException(String mensaje){
        super(mensaje);
    }
}