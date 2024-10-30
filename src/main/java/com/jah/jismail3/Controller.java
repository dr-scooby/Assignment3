package com.jah.jismail3;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Name: Jahangir Ismail
 * ID: A00036852
 * Assignment 3
 * WebController to handle REST requests
 */


@RestController
public class Controller {



    // end point url: localhost:8080/foo
    @GetMapping("/foo")
    public String getReply(){
        return "bar";
    }

}
