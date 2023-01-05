package com.xingzi.test;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestService {
    public Logger delimiter = LoggerFactory.getLogger("delimiter");
    public Logger json = LoggerFactory.getLogger("json");
    public Logger simple = LoggerFactory.getLogger("simple");
    public Logger regex = LoggerFactory.getLogger("regex");
    public Logger test = LoggerFactory.getLogger("test");
    public Logger test1 = LoggerFactory.getLogger("test1");
    public Logger test2 = LoggerFactory.getLogger("test2");

    public ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 10, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

    @PostConstruct
    public void test(){
        executor.execute(()->{
            int index = 0;
            while (true) {
                delimiter.info("name && 123123123 && time && {}", index);
                index += 1;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
            }
        });

        executor.execute(()->{
            int index = 0;
            while (true){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", "fixName");
                jsonObject.put("time", new Date().getTime());
                jsonObject.put("index", index);
                json.info(jsonObject.toString());
                index += 1;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {}
            }
        });

        executor.execute(()->{
            int index = 0;
            while (true) {
                simple.info("test log simple with index {}", index);
                index += 1;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
            }
        });

        executor.execute(()->{
            int index = 0;
            while (true) {
                regex.info("2222-test-logger-regex {}", index);
                index = index + 1;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
            }
        });

        executor.execute(()->{
            int index = 0;
            while (true) {
                test.info("2222-test-logger-regex \n there is a test info with index {}", index);
                index = index + 1;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
            }
        });

        executor.execute(()->{
            int index = 0;
            while (true) {
                test1.info("2222-test-logger-regex \n there is a test info with index \n this is the 2rd line {}", index);
                index = index + 1;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
            }
        });

        executor.execute(()->{
            int index = 0;
            while (true) {
                test2.info("[time-to-do-the-list] \n only with index that come here {}", index);
                index = index + 1;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {
                }
            }
        });
    }

}
