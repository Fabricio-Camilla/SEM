package sem.service;

import sem.modelo.Estacionamiento;

public interface EstacionamientoService {

    void iniciarEstacionamiento(Estacionamiento estacionamiento);
    void clearEstacionamiento();

    String finalizarEstacionamiento(String patente);

    void actualizar(String patente);

    Estacionamiento estadoEstacionamiento(String patente);
}
