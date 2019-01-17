package com.sakura.ofm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("string")
    @ResponseBody
    public String test(@RequestParam("data") String a){

        System.out.println(a);
        return "dadad";
    }
}
