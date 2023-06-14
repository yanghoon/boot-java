package slim.bootjava.rest.post;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import slim.bootjava.domain.post.entity.Post;
import slim.bootjava.domain.post.service.PostServiceWithHttpExchange;
import slim.bootjava.domain.post.service.PostServiceWithRestRepo;
import slim.bootjava.domain.post.service.PostServiceWithRetrofit;
import slim.bootjava.domain.post.service.PostServiceWithWebClient;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {
    
    private final String TYPE_WEB_CLIENT = "WebClient";
    private final String TYPE_REST_REPO = "RestRepo";
    private final String TYPE_RETROFIT = "Retrofit";
    private final String TYPE_HTTP_EXCHANGE = "HttpExchange";

    private final PostServiceWithWebClient webClientService;
    private final PostServiceWithRestRepo restRepoService;
    private final PostServiceWithRetrofit retrofitService;
    private final PostServiceWithHttpExchange httpExchangeService;

    @GetMapping
    public ResponseEntity<?> getPosts(@RequestParam(defaultValue = TYPE_WEB_CLIENT) String type) {
        Flux<Post> data;

        if (TYPE_REST_REPO.equalsIgnoreCase(type)) {
            data = restRepoService.getPosts();
        } else if (TYPE_RETROFIT.equalsIgnoreCase(type)) {
            data = retrofitService.getPosts();
        } else if (TYPE_HTTP_EXCHANGE.equalsIgnoreCase(type)) {
            data = httpExchangeService.getPosts();
        } else {
            data = webClientService.getPosts();
        }

        Mono<?> body = data.collectList().map(list -> PostRes.of(type, list));

        return ResponseEntity.ok(body);
    }
}
