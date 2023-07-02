package slim.bootjava.domain;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import slim.bootjava.domain.post.entity.Post;

@Slf4j        
public class ExportDataSql {

    private final static String ENDPOINT = "https://jsonplaceholder.typicode.com/";
    private static WebClient webclient;

    @BeforeAll
    static void init() {
        webclient = WebClient.create(ENDPOINT);
    }
    
    @Test
    void export_data_sql_from_rest() {
        Flux<Post> posts = webclient.get().uri("/posts/").retrieve().bodyToFlux(Post.class);
        // log.info("---- Posts");
        // posts.map(Post::toString).subscribe(log::info);
        // posts.subscribe(System.out::println);

        // log.info("---- Posts");
        // posts.collectList().block().stream().forEach(p -> log.info(p.toString()));
        // posts.collectList().block().stream().forEach(p -> System.out.println(p));

        Flux.concat(Mono.just("---- Posts"), posts)
            .map(Object::toString)
            // .flatMap(Object::toString)
            .subscribe(log::info);
            // .subscribe(s -> System.out.println(s));
        
        // posts.blockFirst();
        posts.blockLast();

        // Flux.merge(Mono.just("---- Posts"), posts.collectList())
        // //     .map(Object::toString)
        // // //     // .flatMap(Object::toString)
        // // //     // .subscribe(log::info);
        //     .subscribe(s -> {
        //         System.out.println(Thread.currentThread().getName());
        //         System.out.println(s);
        //     });
        
        // posts.collectList()
        //     .subscribe(s -> {
        //         System.out.println(Thread.currentThread().getName());
        //         System.out.println(s);
        //     });
    }

    @Test
    void test_flux_concat_complte() throws InterruptedException {
        // final Duration delay = Duration.ofSeconds(5);
        // final Scheduler on = Schedulers.immediate();
        // Flux<String> one = Flux.just("one").delaySequence(delay).publishOn(on);
        // Flux<String> two = Flux.just("two").delaySequence(delay).publishOn(on);
        Flux<String> one = delayedFlux("one");
        Flux<String> two = delayedFlux("two");

        Flux.concat(one, two)
            // .publishOn(Schedulers.immediate())
            // .subscribeOn(Schedulers.immediate())
            .subscribe(e -> log.info(e.toString()));
        
        // Thread.sleep(Duration.ofSeconds(12).toMillis());
        two.blockLast();
    }

    Flux<String> delayedFlux(String element) {
        final Duration delay = Duration.ofSeconds(5);
        return Flux.just(element)
                    .delaySequence(delay)
                    // .delaySequence(delay, Schedulers.immediate())
                    .map(e -> {
                        log.info(e);
                        return e;
                    });
    }
}
