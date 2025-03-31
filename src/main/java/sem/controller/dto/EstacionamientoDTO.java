package sem.controller.dto;

import sem.modelo.ZonaEstacionamiento;

import java.time.LocalDate;

public record EstacionamientoDTO (String patente, LocalDate fechaInicio, ZonaEstacionamiento zona){

}