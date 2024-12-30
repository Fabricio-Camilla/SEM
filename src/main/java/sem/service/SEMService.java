package sem.service;

public interface SEMService {

    // usuario pone patente, se registra con hora actual el  inicio del estacionamiento
    public void iniciarEstacionamiento(String patente);

    //usuario finaliza el estacionamiento si es que no paso de las 20hs se finalizo automaticamente, softDelte?
    public Double finalizarEstacionamiento();
}
