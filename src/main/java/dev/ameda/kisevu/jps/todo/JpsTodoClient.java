package dev.ameda.kisevu.jps.todo;/*
*
@author ameda
@project jps-spring-boot-starter
@package dev.ameda.kisevu.jps.todo
*
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class JpsTodoClient {
    private static final Logger logger = LoggerFactory.getLogger(JpsTodoClient.class);
    private final RestClient restClient;

    public JpsTodoClient(RestClient restClient) {
        this.restClient = restClient;
    }
    public List<Todo> findAll(){
        return restClient.get()
                .uri("/todos")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Todo>>() {});
    }

    public Todo findById(Integer id){
        return restClient.get()
                .uri("/todos/{id}",id)
                .retrieve()
                .body(Todo.class);
    }

    public Todo create(Todo todo){
        return restClient.post()
                .uri("/todos")
                .body(todo)
                .retrieve()
                .body(Todo.class);
    }
}
