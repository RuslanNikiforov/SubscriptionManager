package ruslan.SubscriptionManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruslan.SubscriptionManager.entities.Subscription;
import ruslan.SubscriptionManager.entities.User;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findAllByUserId(long userId);
}
