package org.garen.cas.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class CodeManage {

    public String createUserCode(){
        return (UUID.randomUUID().toString()+System.currentTimeMillis()+ new Random(10).nextInt()).replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(new CodeManage().createUserCode());
        System.out.println(new CodeManage().createUserCode().length());
    }
}
