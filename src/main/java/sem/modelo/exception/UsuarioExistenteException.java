package sem.modelo.exception;

public class UsuarioExistenteException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Usuario existente";
    }
}
