package sem.persistencia.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import sem.modelo.Coordenada;
import sem.modelo.ZonaEstacionamiento;

import java.util.ArrayList;
import java.util.List;

@Document("ZonaEstacionamiento")
public class ZonaEstacionamientoMongo {


    @Id
    private Long id;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPolygon areaDeLaUbicacion;

    public static ZonaEstacionamientoMongo desdeModelo(ZonaEstacionamiento zonaEstacionamiento) {
        ZonaEstacionamientoMongo zona = new ZonaEstacionamientoMongo();
        zona.areaDeLaUbicacion = pasarAPoligono(zonaEstacionamiento.getCoordenadas());

        return zona;
    }

    public static GeoJsonPolygon pasarAPoligono(List<Coordenada> area){
        List<Point> puntos = new ArrayList<>();
        for (Coordenada coordenada : area) {
            puntos.add(new Point(coordenada.getLongitud(), coordenada.getLatitud()));
        }

        //Agrega el primero al final para que sea un poligono
        if(!area.isEmpty()) {
            Coordenada primeraCoordenada = area.get(0);
            puntos.add(new Point(primeraCoordenada.getLongitud(), primeraCoordenada.getLatitud()));
        }


        return new GeoJsonPolygon(puntos);

    }
}
