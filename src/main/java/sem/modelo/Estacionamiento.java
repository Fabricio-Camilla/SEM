package sem.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import sem.modelo.exception.HoraDeInicioInvalida;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Getter @Setter @NoArgsConstructor
@Entity
public class Estacionamiento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstacion;

    @Column(nullable = false, unique = true)
    private String patente;

    private LocalDate dia;

    @JsonFormat(pattern = "HH:mm")
    private String  horaInicio;

    @JsonFormat(pattern = "HH:mm")
    private String horaFin;

    @Enumerated(EnumType.STRING)
    private EstadoEstacionamiento estado;

    @Transient
    private ZonaEstacionamiento zonaEstacionamiento;
    @Transient
    private Coordenada ubicacionActual;

    /*
     *solamenmte inciar y saber la cantidad de timepo que se estuvo estacionado
    */
    public Estacionamiento(@NonNull String patente) {
        this.patente = patente;
        this.zonaEstacionamiento = new ZonaEstacionamiento();
        this.dia = LocalDate.now();
    }

    public void cambiarEstadoVigente() {
        this.estado =  EstadoEstacionamiento.VIGENTE;
    }

    public void iniciarEstacionamiento() {
        this.setHoraInicio(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        //this.setUbicacionActual(coordActual);
    }

    public String finalizarEstacionamiento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); //todo:el cambio de hora un metodo
        LocalTime horaFin = LocalTime.now();
        LocalTime horaInicio = LocalTime.parse(this.horaInicio, formatter);

        if(horaInicio.isAfter(horaFin)) {
            throw new HoraDeInicioInvalida();
        }else{
            this.setHoraFin(horaFin.format(formatter));
            return this.cantidadDeHorasEstacionado();
        }
    }

    public String cantidadDeHorasEstacionado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaInicio = LocalTime.parse(this.horaInicio, formatter);
        LocalTime horaFin = LocalTime.parse(this.horaFin, formatter);

        long minutos = ChronoUnit.MINUTES.between(horaInicio, horaFin);

        if (minutos < 0) {
            minutos += 24 * 60;
        }
        int horas = (int) (minutos / 60);
        int minutosRestantes = (int) (minutos % 60);

        // Retorna un string en formato HH:mm, con ceros delante si es necesario
        return String.format("%02d:%02d", horas, minutosRestantes);
    }
}
