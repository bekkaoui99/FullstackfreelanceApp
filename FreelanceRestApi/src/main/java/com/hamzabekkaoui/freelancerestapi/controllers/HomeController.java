package com.hamzabekkaoui.freelancerestapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/working")
public class HomeController {

    @GetMapping
    public String work(){
        return "the app is working";
    }

}
