package com.xingzi.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

    public final static Pattern PROJECT_PATTERN =  Pattern.compile("[a-z0-9\\-]+?");


    public static void main(String[] args) {
        TestChild testChild = new TestChild();
        System.out.println(testChild instanceof TestFather);
    }

    public static void copyUpdatableObjectIfNotNull(Object source, Object destination){
        Field[] fields = source.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            // 如果是基本类，直接复制
            if (isPrimitive(field.getType())) {
                try {
                    Object sourceValue = field.get(source);
                    if (sourceValue != null) {
                        field.set(destination, sourceValue);
                    }
                } catch (Exception ignored) {
                }
            } else {
                // 如果不知基本类，进一步复制
                try {
                    copyUpdatableObjectIfNotNull(field.get(source), field.get(destination));
                } catch (Exception ignored) {
                }
            }
        }
    }

    public static boolean isPrimitive(Class<?> clazz){
        Class<?>[] cls = new Class[]{
                String.class,Integer.class,Double.class,Boolean.class,
                Byte.class,Long.class,Float.class,Short.class,Character.class
        };

        return Arrays.asList(cls).contains(clazz);
    }

    public static boolean isPrimitive(Object o){
        boolean isPrimitive = false;
        try {
            isPrimitive = ((Class<?>)o.getClass().getField("TYPE").get(null)).isPrimitive();
        } catch (Exception ignored){}

        return isPrimitive;
    }

}
