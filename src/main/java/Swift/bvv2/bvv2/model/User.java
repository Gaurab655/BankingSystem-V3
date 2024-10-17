package Swift.bvv2.bvv2.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class myUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String fullName;
    private String email ;
    private String password;
}
