package com.spider;

import com.spider.processer.Music163Processer;

public class HouseApplicationTests {


    public void contextLoads() {


    }

    public static void main(String[] args) throws Exception {
        String result =Music163Processer.makeContent("123","true",1);
        System.out.println(result);
    }




}
