package com.romainlabbe.candidatures.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romainlabbe.candidatures.dto.HelloworldResponse;

@RestController 
public class HelloWorld{
    @GetMapping("/")
    public HelloworldResponse HelloWorld(){
        return new HelloworldResponse("Hello World !");
    }
}