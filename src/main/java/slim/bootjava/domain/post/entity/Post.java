package slim.bootjava.domain.post.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private long id;
    private long userId;
    private String title;
    private String body;

}
