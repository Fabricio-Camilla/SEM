package sem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem.modelo.Usuario;
import sem.modelo.exception.UsuarioExistenteException;
import sem.modelo.exception.UsuarioNoEncontradoException;
import sem.persistencia.UserDAO;
import sem.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    private UserDAO userDAO;

    public LoginServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(Usuario user) {
        userDAO.findByUserName(user.getUserName())
                .ifPresent(u -> { throw new UsuarioExistenteException(); });

        userDAO.save(user);
    }

    @Override
    public Usuario recuperar(String userName) {
        return userDAO.findByUserName(userName).orElseThrow(UsuarioNoEncontradoException::new);
    }

    @Override
    public void deleteAll() { //sacar del service
        userDAO.deleteAll();
    }
}
