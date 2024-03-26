package com.mh.restapi04.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HeadersController {
    @GetMapping(value = "param",headers = "v1=1")
    public String paramV1(){
        return "headersV1";
    }
    @GetMapping(value = "param",headers = "v1=2")
    public String paramV2(){
        return "headersV2";
    }
}