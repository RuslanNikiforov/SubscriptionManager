package ruslan.SubscriptionManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruslan.SubscriptionManager.dto.SubscriptionResponse;
import ruslan.SubscriptionManager.entities.Subscription;
import ruslan.SubscriptionManager.services.SubscriptionService;
import ruslan.SubscriptionManager.services.SubscriptionServiceImpl;
import ruslan.SubscriptionManager.services.UserServiceImpl;
import ruslan.SubscriptionManager.util.DigitalService;

import java.util.List;

@RestController
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/users/{id}/subscriptions")
    public ResponseEntity<SubscriptionResponse> createSubscription(@PathVariable long id,
                                                                   @RequestBody Subscription subscription) {
        Subscription createdSubscription = subscriptionService.save(id, subscription);
        return ResponseEntity.ok(SubscriptionServiceImpl.toDTO(createdSubscription));
    }

    @GetMapping("/users/{id}/subscriptions")
    public ResponseEntity<List<SubscriptionResponse>> getUserSubscriptions(@PathVariable long id) {
        var subscriptions = subscriptionService.getAllByUserId(id);
        return ResponseEntity.ok(subscriptions.stream().map(SubscriptionServiceImpl::toDTO).toList());
    }

    @DeleteMapping("/users/{id}/subscriptions/{sub_id}")
    public void deleteSubscription(@PathVariable long id, @PathVariable long sub_id) {
        subscriptionService.delete(id, sub_id);
    }

    @GetMapping("subscriptions/top")
    public ResponseEntity<List<DigitalService>> getMostPopularSubscriptions() {
        return ResponseEntity.ok(subscriptionService.mostPopularSubscriptions());
    }

}
