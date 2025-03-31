package sem.service;

import sem.modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService {

    void register(String username, String password);

    Usuario recuperar(String userName);

    String login(String userName, String password);

    void deleteAll();

}
