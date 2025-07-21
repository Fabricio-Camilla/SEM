package sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sem.modelo.Estacionamiento;
import sem.modelo.exception.EstacionamientoCerradoException;
import sem.service.AppUserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class AppUsuarioTest {

	@Autowired
	private AppUserService user;

	private Estacionamiento estacionamiento;

	@BeforeEach
	void setUp() {
		estacionamiento = new Estacionamiento("AD010GU2");
	}

	@Test
	void contextLoads() {
		estacionamiento.setFechaInicio(LocalDateTime.of(LocalDate.now(), LocalTime.of(21,0)));

		assertThrows(EstacionamientoCerradoException.class, () -> {
			user.iniciarEstacionamiento(estacionamiento); //al estacionamiento service iniciarlo
			//no tiene mas exception  de que esta vencido por que solo es para saber la cantidad
			//de horas que estuvo en el lugar.
			//puede escalar a eso
		});
	}


	@Test
	void clear(){
		user.clearEstacionamiento();
	}
}
