package slim.bootjava.domain.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    // private Address address;
    // private Company company;

    private long version;
}
