package sem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem.modelo.Estacionamiento;
import sem.modelo.SEM;
import sem.persistencia.EstacionamientoDAO;
import sem.persistencia.ZonaEstacionamientoMONGODAO;
import sem.persistencia.dto.ZonaEstacionamientoMongo;
import sem.service.AppUserService;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    private SEM sistema;
    private EstacionamientoDAO estacionamientoDAO;
    private ZonaEstacionamientoMONGODAO zonaEstacionamientoMongo;

    public AppUserServiceImpl(EstacionamientoDAO estacionamientoDAO, ZonaEstacionamientoMONGODAO zonaEstacionamientoMongo) {
        this.estacionamientoDAO = estacionamientoDAO;
        this.sistema = new SEM();
        this.zonaEstacionamientoMongo = zonaEstacionamientoMongo;
    }

    public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
        sistema.validarEstacionamiento(estacionamiento);


        estacionamientoDAO.save(estacionamiento);
    }
    public void clearEstacionamiento() {
        estacionamientoDAO.deleteAll();
    }
}
