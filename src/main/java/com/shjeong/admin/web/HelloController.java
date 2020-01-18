package com.shjeong.admin.web;

import com.shjeong.admin.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/hello/dto")
    //@리퀘스트파람 외부 api로 넘긴 파라미터를 가져오는 어노테이션
    //외부 변수를 name 변수에 넣어줌
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,@RequestParam("amount") int amount)
    {
       // return name;
        return new HelloResponseDto(name,amount);
    }
}
