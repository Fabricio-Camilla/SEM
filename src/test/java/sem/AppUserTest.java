package sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sem.modelo.Estacionamiento;
import sem.service.AppUserService;

import java.time.LocalDateTime;

@SpringBootTest
class AppUserTest {

	@Autowired
	private AppUserService user;

	private Estacionamiento estacionamiento;

	@BeforeEach
	void setUp() {
		estacionamiento = new Estacionamiento("AD010GU2", LocalDateTime.now());
	}

	@Test
	void contextLoads() {
		user.iniciarEstacionamiento(estacionamiento);
	}

}
