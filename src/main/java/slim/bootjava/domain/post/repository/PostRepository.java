package slim.bootjava.domain.post.repository;

import java.util.List;

import slim.bootjava.domain.post.entity.Post;
import slim.bootjava.domain.post.entity.PostSummary;

public interface PostRepository {

    List<Post> findAll();

    List<Post> findAllWithUser();

    Post findById(Long id);

    List<PostSummary> findAllPostSummaries();

}
