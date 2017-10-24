package org.garen.cas.service;


import org.garen.cas.mybatis.domain.App;
import org.garen.cas.mybatis.domain.Login;
import org.garen.cas.mybatis.domain.UserApp;
import org.garen.cas.mybatis.domain.UserBase;
import org.garen.cas.redis.RedisService;
import org.garen.cas.util.JsonMapper;
import org.garen.cas.util.MD5Util;
import org.garen.cas.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录业务类
 *
 * @author Garen Gosling
 * @create 2017-10-20 00:33
 * @since v1.0
 */
@Service
public class LoginManage {

    @Autowired
    LoginInfoManage loginInfoManage;
    @Autowired
    UserBaseManage userBaseManage;
    @Autowired
    UserAppManage userAppManage;
    @Autowired
    AppManage appManage;
    @Autowired
    CodeManage codeManage;
    @Autowired
    private RedisService redisService;

    /**
     * 登录
     *
     * @param loginName
     * @param password
     * @return
     */
    public Map<String, Object> login(String loginName, String password){
        // 登录结果
        Map<String, Object> res = new HashMap<>();
        res.put("isLogin",false);   // 未登录
        // 登录失败 1
        Login loginInfo = loginInfoManage.getByLoginName(loginName);
        if(loginInfo == null){
            return res;
        }
        // 登录失败 2
        String md5String = MD5Util.getMD5String(password);
        if(!md5String.equals(loginInfo.getPassword())){
            return res;
        }
        // 登录成功，保存登录信息、用户基本信息、已开启的应用列表
        loginInfo.setPassword("***");   // 登录信息，隐藏密码
        UserBase userBase = userBaseManage.getByUserCode(loginInfo.getUserCode());  // 用户基础信息
        List<App> apps = appManage.findByUserCodeEntity(loginInfo.getUserCode()); // 已开启的应用列表
        LoginVo loginVo = new LoginVo(loginInfo, userBase, apps);
        res.put("loginVo", loginVo);
        // 生成ticket，并保存
        String ticket = codeManage.createTicket(loginInfo.getUserCode());
        res.put("ticket", ticket);
        // 登录信息保存到redis
        String loginVoJson = new JsonMapper().toJson(loginVo);
        redisService.putH("loginInfo", ticket, loginVoJson);
        res.put("isLogin", true);   // 登录成功
        return res;
    }


}
