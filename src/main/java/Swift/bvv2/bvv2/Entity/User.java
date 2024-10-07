package Swift.bvv2.bvv2.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public Object getPassword() {
        return password;
    }

    public String getFullName(){
        return this.fullName;
    }
}
