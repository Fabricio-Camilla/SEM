package sem.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class SEM {

    private List<Estacionamiento> estacionamientos; //bdd

    public void registrarEstacionamiento(String patente) {

        var estacionamiento = new Estacionamiento(patente, LocalDate.now());
        this.estacionamientos.add(estacionamiento);

    }

}
