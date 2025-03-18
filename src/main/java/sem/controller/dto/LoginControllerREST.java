package sem.controller.dto;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import sem.service.LoginService;

@RestController
public class LoginControllerREST {
    private final AuthenticationManager authManager;
    private final LoginService loginService;

    public LoginControllerREST(AuthenticationManager authManager, LoginService loginService) {
        this.authManager = authManager;
        this.loginService = loginService;
    }

    @PutMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsuarioDTO usuario) {
        loginService.register(usuario.userName(), usuario.password());
        return ResponseEntity.ok("Usuario registrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO user, HttpServletResponse response) {
        String token = loginService.login(user.userName(), user.password());

        response.setHeader("Authorization", "Bearer " + token);

        return ResponseEntity.ok("Inicio de sesion exitoso");
    }
}
