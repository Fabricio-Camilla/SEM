package sem.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final AuthenticationManager authManager;
    private final UserDAO userDAO;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(UserDAO userDAO, JwtUtil jwtUtil, AuthenticationManager authManager, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(String userName, String password) {
        userDAO.findByUserName(userName)
                .ifPresent(u -> { throw new UsuarioExistenteException(); });
        Usuario user = new Usuario(userName, passwordEncoder.encode(password));

        userDAO.save(user);

    }

    @Override
    public Usuario recuperar(String userName) {
        return userDAO.findByUserName(userName).orElseThrow(UsuarioNoEncontradoException::new);
    }

    @Override
    public String login(String userName, String password) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

        Usuario usuario = userDAO.findByUserName(userName).orElseThrow(UsuarioNoEncontradoException::new);

        return jwtUtil.generateToken(usuario.getUserName(), usuario.getUserPassword());
    }

    @Override
    public void deleteAll() { //sacar del service
        userDAO.deleteAll();
    }


}
