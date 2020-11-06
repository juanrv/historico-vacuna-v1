package co.vacunaController.model.exception;

public class BussinessException extends RuntimeException{
    public BussinessException(String mensaje){
        super(mensaje);
    }
}
