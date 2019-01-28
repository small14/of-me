package com.sakura.ofm.controller;

import com.sakura.ofm.tools.EMailHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }

    @RequestMapping("/sakura")
    public String sakura(){
        return "中文测试";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        if (file.isEmpty()){
            return "NO file is checked";
        }
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get("E:\\upload\\test\\"+file.getOriginalFilename());
            Files.write(path, bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("/cn")
    public String cn(@RequestParam("cn") String cn){
        System.out.println(cn);
        return "正确处理中文";
    }


    @RequestMapping("/mail")
    public String mail(){
        EMailHelper eMailHelper = new EMailHelper();
        eMailHelper.sendMail("测试","<h2>测试</h2>",new Date(),"982697020@qq.com");
        return "success";
    }


}
