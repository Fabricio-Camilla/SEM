package sem.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sem.modelo.Estacionamiento;

@Repository
public interface EstacionamientoDAO extends JpaRepository<Estacionamiento, String> {

}
