package sem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem.modelo.Estacionamiento;
import sem.modelo.SEM;
import sem.persistencia.EstacionamientoDAO;
import sem.persistencia.ZonaEstacionamientoMONGODAO;
import sem.service.EstacionamientoService;

@Service
@Transactional
public class EstacionamientoImpl implements EstacionamientoService {

    private EstacionamientoDAO estacionamientoDAO;

    public EstacionamientoImpl(EstacionamientoDAO estacionamientoDAO) {
        this.estacionamientoDAO = estacionamientoDAO;
    }

    public void iniciarEstacionamiento(Estacionamiento estacionamiento) {

        estacionamientoDAO.save(estacionamiento);
    }
    public void clearEstacionamiento() {
        estacionamientoDAO.deleteAll();
    }

    @Override
    public String finalizarEstacionamiento(String patente) {
        Estacionamiento estacionamiento = estacionamientoDAO.recuperarByPatente(patente);
        var horas = estacionamiento.finalizarEstacionamiento();
        estacionamientoDAO.save(estacionamiento);
        return horas;
    }

    @Override
    public void actualizar(String patente) {

    }

    @Override
    public Estacionamiento estadoEstacionamiento(String patente) {
       return estacionamientoDAO.recuperarByPatente(patente);
    }
}
