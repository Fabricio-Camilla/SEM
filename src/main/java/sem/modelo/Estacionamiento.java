package sem.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Estacionamiento {

    private Long id;
    private String patente;
    private LocalDate fechaInicio;

    public Estacionamiento(String patente, LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.patente = patente;
    }

}
