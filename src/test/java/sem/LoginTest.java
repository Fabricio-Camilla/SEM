package sem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sem.modelo.Usuario;
import sem.modelo.exception.UsuarioExistenteException;
import sem.service.impl.LoginServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class LoginTest {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    private Usuario user;

    @BeforeEach
    public void setUp() {
        user = new Usuario("username", "password");
        loginServiceImpl.register(user);
    }

    @Test
    public void unUsuarioPuedeRegistrarse() {
        Usuario user2 = loginServiceImpl.recuperar(user.getUserName());

        assertEquals(user.getUserName(), user2.getUserName());
    }

    @Test
    public void unUsuarioNoPuedeRegistrarseConElMismoUserName() {
        Usuario user2 = new Usuario("username", "password");

        assertThrows(UsuarioExistenteException.class, () -> {
            loginServiceImpl.register(user2);
        });
    }

    @AfterEach
    public void clear() {
        loginServiceImpl.deleteAll();
    }
}
