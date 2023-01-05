package com.xingzi.test;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestFather {

    private static final Map<String, String> map = new HashMap<>();

    public String getStr(){
        return "father";
    }

    @PostConstruct
    public void init(){
        System.out.println("father init");

        map.put(this.getClass().getName(), getStr());

        System.out.println("father init" + JSON.toJSONString(map));
    }

}
