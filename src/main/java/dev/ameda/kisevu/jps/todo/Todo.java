package dev.ameda.kisevu.jps.todo;/*
*
@author ameda
@project jps-spring-boot-starter
@package dev.ameda.kisevu.jps.todo
*
*/
public record Todo
        (Integer userId,
         Integer id,
         String title,
         Boolean completed) {

}
