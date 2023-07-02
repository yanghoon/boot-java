package slim.bootjava.domain.post.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import slim.bootjava.domain.user.entity.User;

@Getter
@Setter
@ToString(exclude = "user")
@Entity
@NamedQueries({
    @NamedQuery(name=Post.FIND_ALL, query = "select p from Post p"),
    @NamedQuery(name=Post.FIND_BY_ID, query = "select p from Post p where p.id = :id"),
    @NamedQuery(name=Post.FIND_ALL_WITH_USER, query = "select p from Post p left join fetch p.user u")
})
public class Post {

    public static final String FIND_ALL = "Post.findAll";
    public static final String FIND_BY_ID = "Post.findById";
    public static final String FIND_ALL_WITH_USER = "Post.findAllWithUser";

    @Id @GeneratedValue
    private long id;
    // private long userId;
    private String title;
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private long version;

}
