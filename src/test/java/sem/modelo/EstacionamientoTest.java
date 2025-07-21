package sem.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class EstacionamientoTest {

    private Estacionamiento estacionamiento;

    private Coordenada coord;

    @BeforeEach
    public void setUp() {
        estacionamiento = new Estacionamiento("ad011ad");
        coord = new Coordenada(-34.76832081442188, -58.37286337631086);
    }

    @Test
    public void seRegistraInicioDeEstacionamiento(){
        estacionamiento.iniciarEstacionamiento(coord);

        assertEquals(estacionamiento.getFechaInicio(), LocalDateTime.now());
    }

    @Test
    public void seRegistraCantidadDeHorasFinalesDelEstacionamiento(){
        estacionamiento.setFechaInicio(LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));

        estacionamiento.finalizarEstacionamiento();

        estacionamiento.setFechaFin(LocalDateTime.of(LocalDate.now(), LocalTime.of(4, 0)));

        assertEquals(estacionamiento.cantidadDeHorasEstacionado(),  LocalTime.of(18,0));
    }

    @Test
    public void unEstacionamientoRegistradoTieneSuUbicacion(){
        estacionamiento.iniciarEstacionamiento(coord);

        assertEquals(estacionamiento.getUbicacionActual().getLatitud(), coord.getLatitud());
        assertEquals(estacionamiento.getUbicacionActual().getLongitud(), coord.getLongitud());
    }

    @Test
    public void unEstacionamientoSeTieneUnaZonaParaEstacionar(){
        assertNotNull(estacionamiento.getZonaEstacionamiento());
    }
}
