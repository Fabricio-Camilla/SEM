package sem.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EstacionamientoTest {

    private Estacionamiento estacionamiento;


    @BeforeEach
    public void setUp() {
        estacionamiento = new Estacionamiento("ad011ad");
    }

    @Test
    public void seRegistraInicioDeEstacionamiento(){
        estacionamiento.iniciarEstacionamiento();

        assertEquals(estacionamiento.getDia(), LocalDate.now());
    }

    @Test
    public void seRegistraCantidadDeHorasFinalesDelEstacionamiento(){
        estacionamiento.setHoraInicio("10:00");
        estacionamiento.setHoraFin("04:00");
        estacionamiento.finalizarEstacionamiento();

        assertEquals(11, estacionamiento.cantidadDeHorasEstacionado());
    }

       @Test
    public void unEstacionamientoSeTieneUnaZonaParaEstacionar(){
        assertNotNull(estacionamiento.getZonaEstacionamiento());
    }
}
