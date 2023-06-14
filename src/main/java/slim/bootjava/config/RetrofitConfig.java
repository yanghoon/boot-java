package slim.bootjava.config;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import slim.bootjava.domain.post.repository.PostRetrofitRepository;

/**
 * @see https://square.github.io/retrofit/
 */
@Configuration
public class RetrofitConfig {

    private String baseUrl = "https://jsonplaceholder.typicode.com";
    
    private boolean proxyEnable = false;
    private String proxyHost = "127.0.0.1";
    private int proxyPost = 8080;
    
    @Bean
    public PostRetrofitRepository postRetrofitRepository() {
        return retrofit().create(PostRetrofitRepository.class);
    }

    @Bean
    public Retrofit retrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(ReactorCallAdapterFactory.create());
        
        if (proxyEnable) {
            builder.client(okHttpClient());
        }

        return builder.build();
    }

    private OkHttpClient okHttpClient() {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPost));
        return new OkHttpClient.Builder()
            .proxy(proxy)
            .build();
    }

}
