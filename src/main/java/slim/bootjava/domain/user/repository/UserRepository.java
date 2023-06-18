package slim.bootjava.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import slim.bootjava.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
