package sem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem.controller.dto.EstacionamientoDTO;
import sem.modelo.Estacionamiento;
import sem.modelo.SEM;
import sem.persistencia.EstacionamientoDAO;
import sem.persistencia.EstacionamientoMONGODAO;
import sem.service.AppUserService;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    private SEM sistema;
    private EstacionamientoDAO estacionamientoDAO;
    private EstacionamientoMONGODAO estacionamientoMONGODAO;

    public AppUserServiceImpl(EstacionamientoDAO estacionamientoDAO, EstacionamientoMONGODAO estacionamientoMONGODAO ) {
        this.estacionamientoDAO = estacionamientoDAO;
        this.estacionamientoMONGODAO = estacionamientoMONGODAO;
        this.sistema = new SEM();
    }

    public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
        sistema.validarEstacionamiento(estacionamiento);
        estacionamientoMONGODAO.validarZonaEstacionamiento(estacionamiento.getZonaEstacionamiento());
        estacionamiento.cambiarEstadoVigente();

        estacionamientoDAO.save(estacionamiento);
    }
    public void clearEstacionamiento() {
        estacionamientoDAO.deleteAll();
    }
}
