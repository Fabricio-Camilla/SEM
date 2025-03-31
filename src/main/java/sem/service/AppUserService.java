package sem.service;

import sem.modelo.Estacionamiento;

public interface AppUserService {

    void iniciarEstacionamiento(Estacionamiento estacionamiento);
    void clearEstacionamiento();
}
