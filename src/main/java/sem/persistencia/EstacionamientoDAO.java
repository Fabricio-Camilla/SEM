package sem.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sem.modelo.Estacionamiento;

@Repository
public interface EstacionamientoDAO extends JpaRepository<Estacionamiento, String> {

    @Query(
            "SELECT e FROM Estacionamiento e WHERE e.patente = :patente"
            )
    Estacionamiento recuperarByPatente(@Param("patente") String patente);

}
