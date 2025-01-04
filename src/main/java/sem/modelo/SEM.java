package sem.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sem.controller.dto.EstacionamientoDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter @Setter @NoArgsConstructor
public class SEM {

    private LocalTime horaInicio =  LocalTime.of(8, 0);
    private LocalTime horaFin =  LocalTime.of(20, 0);


    public void validarEstacionamiento(Estacionamiento estacionamiento) {
        if(!estacionamiento.getFechaInicio().toLocalTime().isAfter(this.getHoraInicio())){
            throw new RuntimeException();
        }

    }
}
