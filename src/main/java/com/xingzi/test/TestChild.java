package com.xingzi.test;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestChild extends TestFather{

    @Override
    public String getStr(){
        return "father";
    }


}
