package io.api.bitcoin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rpc.configuration")
public record RpcProperties(
        String url,
        String port,
        String username,
        String password) { }
