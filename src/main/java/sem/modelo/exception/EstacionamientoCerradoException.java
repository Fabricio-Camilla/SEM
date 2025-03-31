package sem.modelo.exception;

public class EstacionamientoCerradoException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Estacionamiento cerrado";
    }
}
