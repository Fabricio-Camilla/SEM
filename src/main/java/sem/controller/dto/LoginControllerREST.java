package sem.controller.dto;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import sem.modelo.Estacionamiento;
import sem.service.EstacionamientoService;
import sem.service.LoginService;

@RestController
public class LoginControllerREST {
    private final AuthenticationManager authManager;
    private final LoginService loginService;
    private final EstacionamientoService estacionamientoService;

    public LoginControllerREST(AuthenticationManager authManager, LoginService loginService, EstacionamientoService estacionamientoService) {
        this.authManager = authManager;
        this.loginService = loginService;
        this.estacionamientoService = estacionamientoService;
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

    @GetMapping("/estacionamiento/{patente}")
    public ResponseEntity<ResponseEstacionamientoDTO> estacionamiento(@PathVariable String patente) {
        Estacionamiento est = estacionamientoService.estadoEstacionamiento(patente);
        return ResponseEntity.ok(ResponseEstacionamientoDTO.desdeModelo(est));
    }
}
