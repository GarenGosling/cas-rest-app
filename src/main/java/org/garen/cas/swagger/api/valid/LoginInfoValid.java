package org.garen.cas.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.mybatis.domain.Login;
import org.garen.cas.service.AppManage;
import org.garen.cas.service.LoginInfoManage;
import org.garen.cas.swagger.model.App;
import org.garen.cas.swagger.model.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件信息接口入参验证类
 *
 * @author Garen Gosling
 * @create 2017-09-16 10:10
 * @since v1.0
 */
@Component
public class LoginInfoValid extends BaseValid {
    @Autowired
    LoginInfoManage loginInfoManage;

    /**
     * ID查询、删除文件类型，验证参数
     *
     * @param id
     * @return
     */
    public String idValid(Long id){
        if(id == null){
            return emptyMsg("id");
        }
        return null;
    }

    /**
     * 新增登录信息，验证参数
     *
     * @param loginInfo
     * @return
     */
    public String saveValid(LoginInfo loginInfo){
        if(loginInfo == null){
            return paramNullMsg();
        }
        if(StringUtils.isBlank(loginInfo.getLoginName())){
            return emptyMsg("登录名");
        }
        Login byLoginName = loginInfoManage.getByLoginName(loginInfo.getLoginName());
        if(null != byLoginName){
            return "登录名已存在";
        }
        if(StringUtils.isBlank(loginInfo.getPassword())){
            return emptyMsg("密码");
        }
        if(StringUtils.isBlank(loginInfo.getUserCode())){
            return emptyMsg("用户编码");
        }
        Login byUserCode = loginInfoManage.getByUserCode(loginInfo.getUserCode());
        if(null != byUserCode){
            return "用户编码已存在";
        }
        return null;
    }

    /**
     * 修改登录信息，验证参数
     *
     * @param loginInfo
     * @return
     */
    public String updateValid(LoginInfo loginInfo){
        if(loginInfo == null){
            return paramNullMsg();
        }
        if(loginInfo.getId() == null || loginInfo.getId() == 0){
            return emptyMsg("id");
        }
        if(StringUtils.isBlank(loginInfo.getLoginName())
                && StringUtils.isBlank(loginInfo.getPassword())
                && StringUtils.isBlank(loginInfo.getUserCode())
                ){
            return paramNullMsg();
        }
        return null;
    }
    
}
