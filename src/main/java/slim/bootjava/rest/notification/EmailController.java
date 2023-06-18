package slim.bootjava.rest.notification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import slim.bootjava.domain.notification.service.EmailService;

@RestController
@RequiredArgsConstructor
public class EmailController {
    
    private final EmailService emailService;

    @GetMapping("api/emails")
    public ResponseEntity<?> getEmails() {
        return ResponseEntity.ok(emailService.getEmails());
    }

}
