package sem.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sem.modelo.Usuario;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<Usuario, String> {

    @Query(
        "FROM Usuario u WHERE u.userName = :userName "
    )
    Optional<Usuario> findByUserName(@Param("userName") String userName);
}
