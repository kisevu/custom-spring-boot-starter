package dev.ameda.kisevu.jpsspringbootstarter.todo;/*
*
@author ameda
@project jps-spring-boot-starter
@package dev.ameda.kisevu.jpsspringbootstarter.todo
*
*/
public record Todo
        (Integer userId,
         Integer id,
         String title,
         Boolean completed) {

}
