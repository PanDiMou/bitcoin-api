package io.api.bitcoin.config;

import org.springframework.http.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    //-------
    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl("http://127.0.0.1:8332")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .defaultHeader(HttpHeaders.AUTHORIZATION,
                        "Basic cGFuZGltb3U6ZlpFZ2ZqaG1uQnN4N3BhbmRpbW91N0RUR2c2OTVnZjF6ZTJnZmQ3")
                .build();
    }
    //##################################################################################################################
}
