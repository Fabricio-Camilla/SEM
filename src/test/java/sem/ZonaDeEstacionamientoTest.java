package sem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sem.modelo.ZonaEstacionamiento;
import sem.service.ZonaEstacionamientoService;
import sem.service.impl.ZonaEstacionamientoSerivceImpl;

@SpringBootTest
public class ZonaDeEstacionamientoTest {

    @Autowired
    private ZonaEstacionamientoService zonaService;

    private ZonaEstacionamiento zonaEstacionamiento;

    @Test
    public void seGeneraUnaNuevaZonaEstacionamiento() {

    }
}
