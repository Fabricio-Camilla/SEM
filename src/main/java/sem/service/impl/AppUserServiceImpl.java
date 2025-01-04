package sem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem.controller.dto.EstacionamientoDTO;
import sem.modelo.Estacionamiento;
import sem.modelo.SEM;
import sem.persistencia.EstacionamientoDAO;
import sem.service.AppUserService;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    private SEM sistema;
    private EstacionamientoDAO estacionamientoDAO;

    public AppUserServiceImpl(EstacionamientoDAO estacionamientoDAO) {
        this.estacionamientoDAO = estacionamientoDAO;
        this.sistema = new SEM();
    }

    public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
        sistema.validarEstacionamiento(estacionamiento);
        estacionamientoDAO.save(estacionamiento);
    }
}
