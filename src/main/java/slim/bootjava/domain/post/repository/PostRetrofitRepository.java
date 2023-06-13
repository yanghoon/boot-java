package slim.bootjava.domain.post.repository;

import java.util.List;

import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import slim.bootjava.domain.post.entity.Post;

/**
 * @see https://square.github.io/retrofit/
 */
public interface PostRetrofitRepository {
    
    @GET("posts")
    Mono<List<Post>> findAll();

}
