package sem.modelo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
@EqualsAndHashCode
public class ZonaEstacionamiento {

    private List<Coordenada> coordenadas; //hardcode? unicas coordenadas CABA

    public ZonaEstacionamiento() {
        var coords = new ArrayList<Coordenada>();
        coords.add(new Coordenada(-34.76831458243301, -58.37504068252864));
        coords.add(new Coordenada(-34.77008444764644, -58.373697883924336));
        coords.add(new Coordenada(-34.76788457425394, -58.36925982072623));
        coords.add(new Coordenada(-34.76647612591933, -58.371869553610594));
        this.coordenadas = coords;
    }
}
