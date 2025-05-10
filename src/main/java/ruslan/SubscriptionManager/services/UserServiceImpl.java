package ruslan.SubscriptionManager.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruslan.SubscriptionManager.dto.UserResponse;
import ruslan.SubscriptionManager.entities.User;
import ruslan.SubscriptionManager.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        log.info("Saving user: " + user);
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        log.info("Getting user by id: " + id);
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("Deleted user with id: " + id);
    }

    public static UserResponse toDTO(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername()).build();
    }
}
