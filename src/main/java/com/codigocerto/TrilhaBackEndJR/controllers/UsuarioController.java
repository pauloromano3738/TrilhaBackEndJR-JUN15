package com.codigocerto.TrilhaBackEndJR.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping("/hello")
    public void hello() {
        System.out.println("hello world!");
    }
}
