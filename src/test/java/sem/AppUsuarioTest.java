package sem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sem.modelo.Estacionamiento;
import sem.modelo.exception.EstacionamientoCerradoException;
import sem.modelo.exception.HoraDeInicioInvalida;
import sem.service.EstacionamientoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AppUsuarioTest {

	@Autowired
	private EstacionamientoService estacionamientoService;

	private Estacionamiento estacionamiento;

	@BeforeEach
	void setUp() {
		estacionamiento = new Estacionamiento("AD010GU22");
		estacionamientoService.iniciarEstacionamiento(estacionamiento);
	}


	@Test
	void finalizarEstacionamientoConHoraDeInicioInvalida() {
		estacionamiento.setHoraInicio("20:00");

		estacionamientoService.iniciarEstacionamiento(estacionamiento);

		assertThrows(HoraDeInicioInvalida.class, () -> {
			estacionamientoService.finalizarEstacionamiento(estacionamiento.getPatente());
		});
	}

	@Test
	void finalizarEstacionamientoValido() {
		estacionamiento.setHoraInicio("21:00");

		estacionamientoService.iniciarEstacionamiento(estacionamiento);

		estacionamiento.setHoraFin("22:00");

		assertEquals("01:00", estacionamiento.cantidadDeHorasEstacionado());

	}


	@AfterEach
	void clear(){
		estacionamientoService.clearEstacionamiento();
	}
}
