package io.api.bitcoin.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@RequiredArgsConstructor
@Getter
@Configuration
public class RpcConfig {
    private final RpcProperties rpcProperties;

    @Bean
    public WebClient webClient(final RpcProperties rpcProperties) {
        return WebClient.builder()
                .baseUrl(buildUrl(rpcProperties.url(), rpcProperties.port()))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, buildAuthHeader(rpcProperties.username(), rpcProperties.password()))
                .build();
    }

    private String buildUrl(final String url, final String port) {
        return String.format("%s:%s", url, port);
    }

    private String buildAuthHeader(final String username, final String password) {
        return "Basic " + Base64.getEncoder().encodeToString((String.format("%s:%s", username, password)).getBytes());
    }
}
