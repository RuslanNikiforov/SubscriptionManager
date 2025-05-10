package ruslan.SubscriptionManager.services;

import ruslan.SubscriptionManager.entities.Subscription;
import ruslan.SubscriptionManager.entities.User;
import ruslan.SubscriptionManager.util.DigitalService;

import java.util.List;

public interface UserService {

    User save(User user);

    User getById(Long id);

    void delete(Long id);


}
