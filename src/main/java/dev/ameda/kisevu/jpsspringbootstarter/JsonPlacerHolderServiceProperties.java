package dev.ameda.kisevu.jpsspringbootstarter;/*
*
@author ameda
@project jps-spring-boot-starter
@package dev.ameda.kisevu.jpsspringbootstarter
*
*/

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("json-placeholder-service")
public record JsonPlacerHolderServiceProperties(
        @DefaultValue("https://jsonplaceholder.typicode.com")
        String baseUrl) {

}
