package slim.bootjava.rest.post;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import slim.bootjava.domain.post.entity.Post;

@Getter
@AllArgsConstructor(staticName = "of")
public class PostRes {

    private String type;
    private List<Post> data;

}
