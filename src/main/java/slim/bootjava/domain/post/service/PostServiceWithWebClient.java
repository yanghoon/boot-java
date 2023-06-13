package slim.bootjava.domain.post.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import slim.bootjava.domain.post.entity.Post;

@Service
@RequiredArgsConstructor
public class PostServiceWithWebClient {
    
    private final WebClient postWebClient;

    public Flux<Post> getPosts() {
        final String URI_POSTS = "/posts";
        return postWebClient.get().uri(URI_POSTS).retrieve().bodyToFlux(Post.class);
    }

}
