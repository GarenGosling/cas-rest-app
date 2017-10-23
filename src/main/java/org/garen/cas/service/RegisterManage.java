package org.garen.cas.service;


import org.garen.cas.mybatis.domain.Login;
import org.garen.cas.swagger.model.LoginInfo;
import org.garen.cas.swagger.model.UserApp;
import org.garen.cas.swagger.model.UserBase;
import org.garen.cas.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 注册业务类
 *
 * @author Garen Gosling
 * @create 2017-10-20 00:33
 * @since v1.0
 */
@Service
public class RegisterManage {

    @Autowired
    LoginInfoManage loginInfoManage;
    @Autowired
    UserBaseManage userBaseManage;
    @Autowired
    CodeManage codeManage;
    @Autowired
    UserAppManage userAppManage;

    @Transactional
    public int register(String loginName, String password, String appCodes){
        // 登录信息
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginName(loginName);
        loginInfo.setPassword(MD5Util.getMD5String(password));
        String userCode = codeManage.createUserCode();
        loginInfo.setUserCode(userCode);
        // 用户基础信息
        UserBase userBase = new UserBase();
        userBase.setUserCode(userCode);
        int i = loginInfoManage.saveLoginInfo(loginInfo);
        int j = userBaseManage.saveUserBase(userBase);
        // 绑定应用
        UserApp userApp = new UserApp();
        userApp.setUserCode(userCode);
        userApp.setPermission(true);
        String[] split = appCodes.split(",");
        for(String appCode : split){
            userApp.setAppCode(appCode);
        }
        int k = userAppManage.saveUserApp(userApp);
        if(i==1 && j==1 && k==1){
            return 1;
        }else{
            return 0;
        }

    }

}
