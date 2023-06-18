package slim.bootjava.domain.notification.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;
import slim.bootjava.domain.notification.entity.Email;
import slim.bootjava.domain.notification.repository.EmailRepository;
import slim.bootjava.domain.user.entity.User;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepo;

    public List<Email> getEmails() {
        return emailRepo.findAll();
    }

    public boolean sendEmail(User user) {
        final String to = user.getEmail();

        if (!StringUtils.hasText(to)) {
            throw new IllegalStateException("Method is not implemented - EmailService.sendEmail(User)");
        }

        Email email = new Email();
        email.setFrom("admin@email.com");
        email.setTo(to);
        // email.setTo(Set.of(to));
        email.setSubject(String.format("[Test] Welcom %s!", user.getUsername()));
        email.setContent(String.format("User Info : %s", user.toString()));

        Email sended = emailRepo.save(email);
        return sended != null;
    }

}
