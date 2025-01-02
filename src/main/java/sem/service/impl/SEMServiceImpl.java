package sem.service.impl;

import org.springframework.stereotype.Service;
import sem.modelo.Estacionamiento;
import sem.modelo.SEM;
import sem.service.SEMService;

@Service
public class SEMServiceImpl implements SEMService {

    private SEM sistema;

    @Override
    public void iniciarEstacionamiento(String patente) { //objeto del front con todos los datos para validar pasado a modelo.
        sistema.registrarEstacionamiento(patente);
    }

    @Override
    public Double finalizarEstacionamiento() {
        return 0.0;
    }
}
