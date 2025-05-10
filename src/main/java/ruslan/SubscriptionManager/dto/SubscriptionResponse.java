package ruslan.SubscriptionManager.dto;

import lombok.Builder;
import lombok.Data;
import ruslan.SubscriptionManager.util.DigitalService;

@Data
@Builder
public class SubscriptionResponse {

    public long id;

    public DigitalService digitalService;
}
