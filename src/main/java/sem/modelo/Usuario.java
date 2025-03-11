package sem.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Entity
public class Usuario {

    @Id
    private String userName;

    @Column(unique=true)
    private String userPassword;

    public Usuario(@NonNull String userName, @NonNull String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

}
