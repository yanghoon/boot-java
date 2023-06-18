package slim.bootjava.domain.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import slim.bootjava.domain.notification.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
    
}
