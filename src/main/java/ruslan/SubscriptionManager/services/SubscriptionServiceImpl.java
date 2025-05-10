package ruslan.SubscriptionManager.services;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruslan.SubscriptionManager.dto.SubscriptionResponse;
import ruslan.SubscriptionManager.dto.UserResponse;
import ruslan.SubscriptionManager.entities.Subscription;
import ruslan.SubscriptionManager.entities.User;
import ruslan.SubscriptionManager.repositories.SubscriptionRepository;
import ruslan.SubscriptionManager.repositories.UserRepository;
import ruslan.SubscriptionManager.util.DigitalService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, UserService userService) {
        this.subscriptionRepository = subscriptionRepository;
        this.userService = userService;
    }

    @Override
    public List<Subscription> getAll() {
        logger.info("Getting all subscriptions");
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription save(long userId, Subscription subscription) {
        logger.info("Saving subscription");
        User owner = userService.getById(userId);
        subscription.setUser(owner);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUserId(long userId) {
        logger.info("Getting all subscriptions by user");
        return subscriptionRepository.findAllByUserId(userId);
    }

    @Override
    public Subscription get(long id) {
        logger.info("Getting subscription by id");
        return subscriptionRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(long userId, long id) {
        if(!isUserOwnSubscription(userId, id)) {
            logger.info("User (id:{}) does not own subscription (id:{})", userId, id);
            throw new EntityNotFoundException("User does not own subscription");
        }
        logger.info("Deleting subscription");
        subscriptionRepository.deleteById(id);
    }

    public boolean isUserOwnSubscription(long userId, long id) {
        Subscription existingSubscription = get(id);
        return existingSubscription.getUser().getId() == userId;
    }

    @Override
    public List<DigitalService> mostPopularSubscriptions() {
        logger.info("Getting most popular subscriptions");
        return getAll().stream().collect(Collectors.groupingBy(Subscription::getDigitalService)).entrySet().stream()
                .sorted((x, y)
                        -> y.getValue().size() - x.getValue().size()).limit(3).map(Map.Entry::getKey).toList();
    }

    public static SubscriptionResponse toDTO(Subscription subscription) {
        return SubscriptionResponse.builder()
                .id(subscription.getId())
                .digitalService(subscription.getDigitalService()).build();
    }
}
