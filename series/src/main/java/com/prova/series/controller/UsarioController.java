package com.prova.series.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;

public class UsarioController {
    @GetMapping("/cliente")
    public void doUserPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    }
}
