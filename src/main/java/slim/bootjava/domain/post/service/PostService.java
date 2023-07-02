package slim.bootjava.domain.post.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import slim.bootjava.domain.post.entity.Post;
import slim.bootjava.domain.post.entity.PostSummary;
import slim.bootjava.domain.post.repository.PostRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    
    private final PostRepository postRepo;

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<Post> getPostsWithUser() {
        return postRepo.findAllWithUser();
    }

    @Transactional(readOnly = true)
    public Post getPostById(Long id) {
        return postRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public List<PostSummary> getPostSummaries() {
        return postRepo.findAllPostSummaries();
    }
}
