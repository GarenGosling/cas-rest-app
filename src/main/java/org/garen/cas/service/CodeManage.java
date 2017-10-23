package org.garen.cas.service;

import org.garen.cas.util.MD5Util;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class CodeManage {

    public String createUserCode(){
        return "USER-"+ System.currentTimeMillis() + MD5Util.getMD5String(  new Random(10).nextInt() + "").substring(0,14);
    }

//    public static void main(String[] args) {
//        System.out.println(new CodeManage().createUserCode());
//        System.out.println(new CodeManage().createUserCode().length());
//    }
}
