package sem.modelo.exception;

public class HoraDeInicioInvalida extends RuntimeException {

    @Override
    public String getMessage() {
        return "La hora de inicio ingresada no es valida";
    }
}