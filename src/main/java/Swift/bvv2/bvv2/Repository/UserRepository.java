package Swift.bvv2.bvv2.Repository;

import Swift.bvv2.bvv2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer> {
}
