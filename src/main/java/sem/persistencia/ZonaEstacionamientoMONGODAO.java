package sem.persistencia;

import org.springframework.data.mongodb.repository.MongoRepository;
import sem.persistencia.dto.ZonaEstacionamientoMongo;

public interface ZonaEstacionamientoMONGODAO extends MongoRepository<ZonaEstacionamientoMongo, Long> {
}
