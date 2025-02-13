package sem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem.modelo.ZonaEstacionamiento;
import sem.persistencia.ZonaEstacionamientoMONGODAO;
import sem.persistencia.dto.ZonaEstacionamientoMongo;
import sem.service.ZonaEstacionamientoService;

@Service
@Transactional
public class ZonaEstacionamientoSerivceImpl implements ZonaEstacionamientoService {

    private ZonaEstacionamientoMONGODAO zonaEstacionamientoMONGODAO;

    public void generarZonaEstacionamiento( ZonaEstacionamiento zonaEstacionamiento) {
        ZonaEstacionamientoMongo zonaMongo = ZonaEstacionamientoMongo.desdeModelo(zonaEstacionamiento);
        zonaEstacionamientoMONGODAO.save(zonaMongo);
    }
}
