package sem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sem.modelo.Usuario;
import sem.modelo.exception.UsuarioExistenteException;
import sem.service.impl.JwtUtil;
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
       // loginServiceImpl.register("username", "password");
    }

    @Test
    public void testLogin() {
        loginServiceImpl.register("username", "password");
        loginServiceImpl.register("username2", "password");
    }

    @Test
    public void unUsuarioPuedeRegistrarse() {
        Usuario user2 = loginServiceImpl.recuperar("username");

        assertEquals(user.getUserName(), user2.getUserName());
    }

    @Test
    public void unUsuarioNoPuedeRegistrarseConElMismoUserName() {

        assertThrows(UsuarioExistenteException.class, () -> {
            loginServiceImpl.register("username", "password");
        });
    }

    @Test
    public void unUsuarioYaRegistradoPuedeIniciarSesion() {

        var jwt = new JwtUtil();
        var token = jwt.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImlhdCI6MTc0MjI1MTU4MCwiZXhwIjoxNzQyMjU1MTgwfQ.LlR5XzD7WX0qInj6asbJKENnDbO7xaEXh8DF5dRjU9s", "username");

        System.out.println("Usuario extraído del token: " + token);

    }

    @AfterEach
    public void clear() {
        //loginServiceImpl.deleteAll();
    }
}
