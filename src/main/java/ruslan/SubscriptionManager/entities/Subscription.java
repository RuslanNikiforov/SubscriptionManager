package ruslan.SubscriptionManager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ruslan.SubscriptionManager.util.DigitalService;

@Entity
@Table(name = "subscriptions")
@Data
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DigitalService digitalService;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
