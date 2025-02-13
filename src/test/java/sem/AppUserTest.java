package sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sem.modelo.Estacionamiento;
import sem.modelo.EstadoEstacionamiento;
import sem.service.AppUserService;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class AppUserTest {

	@Autowired
	private AppUserService user;

	private Estacionamiento estacionamiento;

	@BeforeEach
	void setUp() {
		estacionamiento = new Estacionamiento("AD010GU2");
	}

	@Test
	void contextLoads() {
		user.iniciarEstacionamiento(estacionamiento);

		assertEquals(estacionamiento.getEstado(), EstadoEstacionamiento.VIGENTE);
	}


	@Test
	void clear(){
		user.clearEstacionamiento();
	}
}
