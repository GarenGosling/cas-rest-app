package org.garen.cas.service;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.exception.BusinessException;
import org.garen.cas.util.MD5Util;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class CodeManage {

    /**
     * 生成用户编码
     *
     * @return
     */
    public String createUserCode(){
        return "USER-" + System.currentTimeMillis() + MD5Util.getMD5String(  new Random(10).nextInt() + "").substring(0,14);
    }

    /**
     * 生成Ticket
     *
     * @param userCode
     * @return
     */
    public String createTicket(String userCode){
        if(StringUtils.isBlank(userCode)){
            throw new BusinessException("userCode is null");
        }
        return userCode.replace("USER-", "") + "." + System.currentTimeMillis() + "." + MD5Util.getMD5String(  new Random(10).nextInt() + "");
    }

//    public static void main(String[] args) {
//        System.out.println(new CodeManage().createUserCode());
//        System.out.println(new CodeManage().createUserCode().length());
//
//        System.out.println(new CodeManage().createTicket("USER-15087800456568cb435b1526118"));
//        System.out.println(new CodeManage().createTicket("USER-15087800456568cb435b1526118").length());
//    }
}
