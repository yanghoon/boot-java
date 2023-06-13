package slim.bootjava.domain.post.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import slim.bootjava.domain.post.entity.Post;
import slim.bootjava.domain.post.repository.PostRestRepository;

@Service
@RequiredArgsConstructor
public class PostServiceWithRestRepo {
    
    private final PostRestRepository postHttpRepo;

    public Flux<Post> getPosts() {
        return postHttpRepo.findAll();
    }

}
