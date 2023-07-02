package slim.bootjava.domain.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PostSummary {
    
    private String title;
    private String body;
    private String username;
    private String email;

}
