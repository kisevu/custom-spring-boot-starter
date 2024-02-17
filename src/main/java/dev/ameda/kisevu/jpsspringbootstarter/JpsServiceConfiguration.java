package dev.ameda.kisevu.jpsspringbootstarter;/*
*
@author ameda
@project jps-spring-boot-starter
@package dev.ameda.kisevu.jpsspringbootstarter
*
*/

import dev.ameda.kisevu.jpsspringbootstarter.todo.JpsTodoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(JsonPlacerHolderServiceProperties.class)
public class JpsServiceConfiguration {
    private static final Logger log = LoggerFactory.getLogger(JpsServiceConfiguration.class);
    private final JsonPlacerHolderServiceProperties jsonPlacerHolderServiceProperties;

    public JpsServiceConfiguration(JsonPlacerHolderServiceProperties jsonPlacerHolderServiceProperties) {
        this.jsonPlacerHolderServiceProperties = jsonPlacerHolderServiceProperties;
    }

    @Bean("jsonPlaceHolderRestClient")
    public RestClient restClient(RestClient.Builder builder){
        return builder
                .baseUrl(jsonPlacerHolderServiceProperties.baseUrl())
                .build();
    }
    @Bean
    JpsTodoClient jpsTodoClient(RestClient restClient){
        return new JpsTodoClient(restClient);
    }
}
