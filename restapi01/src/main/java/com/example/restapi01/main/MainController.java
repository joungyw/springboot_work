package com.example.restapi01.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("main")
    private String main(){
        System.out.println(mainService);
        return "main";
    }

    @GetMapping("mainapi")
    public @ResponseBody String mainapi(){
        return "mainapi";

    }
}
