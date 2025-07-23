package sem.controller.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem.service.EstacionamientoService;

@RestController
public class EstacionamientoControllerREST {

    private EstacionamientoService estacionamientoService;

    public EstacionamientoControllerREST(EstacionamientoService estacionamientoService) {
        this.estacionamientoService = estacionamientoService;
    }

    @PutMapping("/iniciarEstacionamiento")
    public ResponseEntity<String> iniciarEstacionamiento(@RequestBody EstacionamientoDTO estacionamientoDTO) {
        this.estacionamientoService.iniciarEstacionamiento(estacionamientoDTO.aModelo());
        return ResponseEntity.status(HttpStatus.CREATED).body("Estacionamiento iniciado con exito");
    }

    @PostMapping("/finalizarEstacionamiento/{patente}")
    public String finalizarEstacionamiento(@PathVariable String patente) {
        return this.estacionamientoService.finalizarEstacionamiento(patente);
    }
}
