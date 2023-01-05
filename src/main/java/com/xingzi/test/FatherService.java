package com.xingzi.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class FatherService {

    @Resource
    private TestFather testChild;


    @PostConstruct
    public void init(){

    }
}
