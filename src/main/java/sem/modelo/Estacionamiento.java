package sem.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@Entity
public class Estacionamiento {

    @Id
    private String patente;

    private LocalDateTime fechaInicio;

    @Enumerated(EnumType.STRING)
    private EstadoEstacionamiento estado;

    @Transient
    private ZonaEstacionamiento zonaEstacionamiento;

    public Estacionamiento(@NonNull String patente) {
        this.fechaInicio = LocalDateTime.now();
        this.patente = patente;
        this.estado = EstadoEstacionamiento.NOVIGENTE;
    }

    public void cambiarEstadoVigente() {
        this.estado =  EstadoEstacionamiento.VIGENTE;
    }
}
