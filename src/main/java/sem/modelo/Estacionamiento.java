package sem.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@Entity
public class Estacionamiento {

    @Id
    private String patente;

    private LocalDateTime fechaInicio;

    public Estacionamiento(String patente, LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.patente = patente;
    }
}
