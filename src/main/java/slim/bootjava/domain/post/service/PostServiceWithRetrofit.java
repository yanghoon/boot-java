package slim.bootjava.domain.post.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import slim.bootjava.domain.post.entity.Post;
import slim.bootjava.domain.post.repository.PostRetrofitRepository;

@Service
@RequiredArgsConstructor
public class PostServiceWithRetrofit {
    
    private final PostRetrofitRepository postRepo;

    public Flux<Post> getPosts() {
        return postRepo.findAll().flatMapMany(Flux::fromIterable);
    }

}
