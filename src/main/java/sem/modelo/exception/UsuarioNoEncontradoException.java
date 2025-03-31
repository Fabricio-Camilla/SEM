package sem.modelo.exception;

public class UsuarioNoEncontradoException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Usuario no encontrado";
    }
}
