package slim.bootjava.domain.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String email;
}
