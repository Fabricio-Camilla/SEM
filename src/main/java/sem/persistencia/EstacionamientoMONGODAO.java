package sem.persistencia;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import sem.modelo.Estacionamiento;
import sem.modelo.ZonaEstacionamiento;
import sem.persistencia.dto.ZonaEstacionamientoMongo;

import java.util.Optional;

public interface EstacionamientoMONGODAO extends MongoRepository<Estacionamiento, Long> {


    @Aggregation(pipeline = {
            ""
    })
    Optional<Double> validarZonaEstacionamiento(ZonaEstacionamiento zonaEstacionamiento);
}
