package slim.bootjava.domain.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import slim.bootjava.domain.notification.service.EmailService;
import slim.bootjava.domain.user.entity.User;
import slim.bootjava.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepo;
    private final EmailService emailService;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User register(User user) {
        User registered = userRepo.save(user);

        emailService.sendEmail(registered);

        return registered;
    }

}
