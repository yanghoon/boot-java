package slim.bootjava.domain.notification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Email {
    
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "fromAddress")
    private String from;
    @Column(name = "toAddress")
    private String to;
    // private Set<String> to;
    private String subject;
    private String content;
}
