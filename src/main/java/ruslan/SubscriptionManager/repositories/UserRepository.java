package ruslan.SubscriptionManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruslan.SubscriptionManager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
