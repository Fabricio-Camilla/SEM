package sem.modelo;

import lombok.*;
import java.util.List;

@ToString
@Setter
@Getter
@EqualsAndHashCode
public class ZonaEstacionamiento {

    private List<Coordenada> coordenadas; //hardcode? unicas coordenadas CABA

    public ZonaEstacionamiento(List<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
