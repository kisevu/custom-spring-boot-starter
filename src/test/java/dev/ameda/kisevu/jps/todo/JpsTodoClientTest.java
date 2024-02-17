package dev.ameda.kisevu.jps.todo;

import dev.ameda.kisevu.jps.JpsServiceConfiguration;
import dev.ameda.kisevu.jps.JsonPlacerHolderServiceProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JpsTodoClientTest {
    private final ApplicationContextRunner applicationContextRunner =
            new ApplicationContextRunner()
                    .withConfiguration(AutoConfigurations.of(JpsServiceConfiguration.class,
                            RestClientAutoConfiguration.class));
    @Test
    void shouldContainTodoRestClient(){
        applicationContextRunner.run(context -> {
            assertTrue(context.containsBean("jsonPlaceHolderRestClient"));
            assertTrue(context.containsBean("jpsTodoClient"));
        });
    }
    @Test
    void shouldContainDefaultBaseUrl(){
        applicationContextRunner
                .run((context)->{
                    assertThat(context).hasSingleBean(JsonPlacerHolderServiceProperties.class);
                    assertThat(context.getBean(JsonPlacerHolderServiceProperties.class).baseUrl())
                            .isEqualTo("https://jsonplaceholder.typicode.com");
                });
    }

    @Test
    void shouldContainCustomBaseUrl(){
        applicationContextRunner
                .withPropertyValues("json-placeholder-service.base-url=https://localhost:3000")
                .run((context)->{
                    assertThat(context).hasSingleBean(JsonPlacerHolderServiceProperties.class);
                    assertThat(context.getBean(JsonPlacerHolderServiceProperties.class).baseUrl())
                            .isEqualTo("https://localhost:3000");
                });
    }

    @Test
    void shouldFindAllTodos(){
        applicationContextRunner
                .run((context)->{
                    JpsTodoClient todoClient = context.getBean(JpsTodoClient.class);
                    assertEquals(200,todoClient.findAll().size());
                });
    }
    @Test
    void shouldFindTodoById(){
        applicationContextRunner
                .run((context)->{
                    JpsTodoClient todoClient = context.getBean(JpsTodoClient.class);
                    Todo todo = todoClient.findById(1);
                    assertEquals(1,todo.userId());
                    assertEquals(1,todo.id());
                    assertEquals("delectus aut autem",todo.title());
                    assertEquals(false,todo.completed());
                });
    }
}