package sem.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
@Entity
public class Estacionamiento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstacion;

    @Column(nullable = false, unique = true)
    private String patente;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoEstacionamiento estado;

    @Transient
    private ZonaEstacionamiento zonaEstacionamiento;

    private Coordenada ubicacionActual;

    /*
     *solamenmte inciar y saber la cantidad de timepo que se estuvo estacionado
    */
    public Estacionamiento(@NonNull String patente) {
        this.patente = patente;
        this.zonaEstacionamiento = new ZonaEstacionamiento();
    }

    public void cambiarEstadoVigente() {
        this.estado =  EstadoEstacionamiento.VIGENTE;
    }

    public void iniciarEstacionamiento(Coordenada coordActual) {
        this.setFechaInicio(LocalDateTime.now());
        this.setUbicacionActual(coordActual);
    }

    public void finalizarEstacionamiento() {
        this.setFechaFin(LocalDateTime.now());
    }

    public LocalTime cantidadDeHorasEstacionado() {
        var horaInicio = this.getFechaInicio();
        var horaFin = this.getFechaFin();

        if (horaFin.isBefore(horaInicio)) {
            horaFin = horaFin.plusHours(24);
        }
        Duration diferencia = Duration.between(horaInicio, horaFin);

        long horas = diferencia.toHours();
        long minutos = diferencia.toMinutes() % 60;

        return LocalTime.of((int) horas, (int) minutos);
    }
}
