package dev.ameda.kisevu.starterImpl.hellousingjps.controller;/*
*
@author ameda
@project jps-spring-boot-starter
@package dev.ameda.kisevu.starterImpl.hellousingjps.controller
*
*/

import dev.ameda.kisevu.jps.todo.JpsTodoClient;
import dev.ameda.kisevu.jps.todo.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final JpsTodoClient jpsTodoClient;

    public TodoController(JpsTodoClient jpsTodoClient) {
        this.jpsTodoClient = jpsTodoClient;
    }
    @GetMapping("")
    public List<Todo> findAll(){
        return jpsTodoClient.findAll();
    }
}
