package sem.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String userName;

    private String userPassword;

    public Usuario(@NonNull String userName, @NonNull String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

}
