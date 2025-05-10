package ruslan.SubscriptionManager.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {

    public long id;

    public String email;

    public String username;

}
