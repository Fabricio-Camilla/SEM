package sem.controller.dto;

import sem.modelo.Estacionamiento;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public record ResponseEstacionamientoDTO(Long id, String patente, String horaInicio,String horaFin, int tarifaHora, int precioEstimado) {


    public static ResponseEstacionamientoDTO desdeModelo(Estacionamiento est) {
        int tarifaFija = 100;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaInicio = LocalTime.parse(est.getHoraInicio(), formatter);
        LocalTime ahora = LocalTime.now();

        long minutos = ChronoUnit.MINUTES.between(horaInicio, ahora);
        if (minutos < 0) {
            minutos += 24 * 60;
        }

        int horasEstimadas = (int) Math.ceil(minutos / 60.0);
        int precioEstimado = horasEstimadas * tarifaFija;
        return new ResponseEstacionamientoDTO(
                est.getIdEstacion(),
                est.getPatente(),
                est.getHoraInicio(),
                est.getHoraFin() != null ? est.getHoraFin() : "Sin Finalizar",
                tarifaFija,
                precioEstimado);
    }
}
