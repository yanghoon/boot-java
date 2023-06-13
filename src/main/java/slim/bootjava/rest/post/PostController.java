package slim.bootjava.rest.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import slim.bootjava.domain.post.service.PostService;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {
    
    private final PostService service;

    @GetMapping
    public ResponseEntity<?> getPosts(@RequestParam(required = false) String type) {
        return ResponseEntity.ok(service.getPostsByWebClient());
    }
}
