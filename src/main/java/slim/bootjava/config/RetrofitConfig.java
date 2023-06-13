package slim.bootjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import slim.bootjava.domain.post.repository.PostRetrofitRepository;

/**
 * @see https://square.github.io/retrofit/
 */
@Configuration
public class RetrofitConfig {

    private String baseUrl = "https://jsonplaceholder.typicode.com";
    
    @Bean
    public PostRetrofitRepository postRetrofitRepository() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(ReactorCallAdapterFactory.create())
            .build();

        return retrofit.create(PostRetrofitRepository.class);
    }

}
