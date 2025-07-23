package sem.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import sem.modelo.Estacionamiento;
import sem.modelo.ZonaEstacionamiento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record EstacionamientoDTO (String patente){

    public Estacionamiento aModelo() {
        if (patente != null) {
            Estacionamiento est = new Estacionamiento(this.patente);
            est.setHoraInicio(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
            return est;
        }
        return null;
    }
}