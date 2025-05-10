package ruslan.SubscriptionManager.services;

import ruslan.SubscriptionManager.entities.Subscription;
import ruslan.SubscriptionManager.util.DigitalService;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> getAll();

    Subscription get(long id);

    List<Subscription> getAllByUserId(long userId);

    Subscription save(long id, Subscription subscription);

    void delete(long userId, long id);

    List<DigitalService> mostPopularSubscriptions();
}
