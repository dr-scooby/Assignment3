package com.jah.jismail3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Name: Jahangir Ismail
 * ID: A00036852
 * Assignment 3
 * WebController to handle REST requests
 */


@RestController
public class Controller {


    @Autowired
    private Config conz;

    @Autowired
    private Data thedata;

    // --- End Points --- //

    // end point url: localhost:8080/foo
    @GetMapping("/foo")
    public String getReply(){
        return "bar";
    }


    // end point url: localhost:8080/hello
    /*
    in postman:
    {
        "name":"jah"
    }
     */
    @PostMapping("/hello")
    public String getHello(@RequestBody User user){
        // get the data from the client body - JSON, and convert to User class
        User auser = user;
        System.out.println("\n\nGot user:: " + auser.getName());
        // return the user name
        return "hello " + auser.getName() + "!\n";

    }


    @GetMapping("/configValue")
    public String getConfigValue(){
        return conz.getConfigValue();
    }


    @GetMapping("/secretValue")
    public String getSecretValue(){
        return conz.getSecretValue();
    }


    @GetMapping("/envValue")
    public String getEnValue(){
        return conz.getEnvirVariable();
    }


    // cpu intensive task to get cpu busy
    @GetMapping("/busywait")
    public String busyWait(){
        long endTime = System.currentTimeMillis() + 3 * 60 * 1000; // 3 minutes in milliseconds
        System.out.println("start: " + System.currentTimeMillis());
        while (System.currentTimeMillis() < endTime) {
            // CPU-intensive task: A simple loop that keeps the CPU busy.
            for (int i = 0; i < 1_000_000; i++) {
                // More intensive CPU work with nested calculations
                double result = Math.pow(Math.random(), Math.random());
                Math.log(result);
                Math.sin(result);
                Math.cos(result);
                Math.tan(result);
                // print to console, testing only
                System.out.println("i: " + i + " : " + Math.tan(result));
            }
        }

        System.out.println("end: " + System.currentTimeMillis());

        return "cpu intensive task completed";
    }


    // end point localhost:30000/saveString
    /*
    curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST --data '{"data": "savedSnake"}' localhost:30000/saveString
     */
    @PostMapping("/saveString")
    public ResponseEntity<String> saveString(@RequestBody Data somedata){
        //Data datas = somedata;
        thedata = somedata;
        System.out.println("\nGot some data, write to file:> " + thedata.getData());
        // get the file name and path from configs
        thedata.setFile(conz.getFileName());
        boolean ok = false;
        if(thedata.isExist()) {
            System.out.println("file exists, writing data");
            try {
                thedata.saveData();
                return new ResponseEntity<>("File found", HttpStatus.OK);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else
            return new ResponseEntity<>("file not found", HttpStatus.NOT_FOUND);

    }


    @GetMapping("/getString")
    public  ResponseEntity<String> getString(){

        if(thedata.isExist()){
            return new ResponseEntity<>("File found, the data:\n" + thedata.getData(), HttpStatus.OK);
        }else
            return new ResponseEntity<>("file not found", HttpStatus.NOT_FOUND);

    }


    @GetMapping("/isAlive")
    public String isAlive() {
        return "I'm alive";
    }
}
