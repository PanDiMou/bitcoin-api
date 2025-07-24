package io.api.bitcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BitcoinApi {
    //-------
    public static void main(final String[] args) {
        SpringApplication.run(BitcoinApi.class, args);
    }
    //##################################################################################################################
}
