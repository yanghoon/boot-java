package slim.bootjava.domain.post;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;
import slim.bootjava.domain.post.entity.Post;
import slim.bootjava.domain.post.entity.PostSummary;
import slim.bootjava.domain.post.service.PostService;

@Slf4j
@DataJpaTest(properties = "spring.jpa.properties.hibernate.format_sql=true")
@ComponentScan
public class PostDomainTests {

    @Autowired
    private PostService service;
    
    @Test
    void test_find_all() {
        List<Post> posts = service.getPosts();

        log.info("---- Posts");
        posts.forEach(post -> {
            log.info("{}", post);
            log.info("\t{}", post.getUser());
        });
    }

    @Test
    void test_find_all_with_user() {
        List<Post> posts = service.getPostsWithUser();

        log.info("---- Posts with User");
        posts.forEach(post -> {
            log.info("{}", post);
            log.info("\t{}", post.getUser());
        });
    }

    @Test
    void test_find_by_id() {
        Post post = service.getPostById(1L);

        log.info("---- Post by ID");
        Stream.of(post).forEach(p -> {
            log.info("{}", p);
            log.info("\t{}", p.getUser());
        });
    }

    @Test
    void test_find_post_summary() {
        List<PostSummary> posts = service.getPostSummaries();

        log.info("---- Post Summaries");
        posts.forEach(p -> log.info("{}", p));
    }
}
