package org.garen.cas.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.AppManage;
import org.garen.cas.swagger.model.App;
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
public class RegisterValid extends BaseValid {
    @Autowired
    AppManage appManage;

    /**
     * 登录验证
     * @param loginName
     * @param password
     * @param appCodes
     * @return
     */
    public String registerValid(String loginName, String password, String appCodes){
        if(StringUtils.isBlank(loginName)){
            return emptyMsg("登录名");
        }
        // TODO 验证合法性、是否已存在

        if(StringUtils.isBlank(password)){
            return emptyMsg("密码");
        }
        // TODO 验证合法性

        if(StringUtils.isBlank(appCodes)){
            return emptyMsg("应用编码");
        }
        // TODO 验证合法性、是否已存在

        return null;
    }

    /**
     * 新增应用，验证参数
     *
     * @param app
     * @return
     */
    public String saveValid(App app){
        if(app == null){
            return paramNullMsg();
        }
        if(StringUtils.isBlank(app.getAppCode())){
            return emptyMsg("应用编码");
        }
        org.garen.cas.mybatis.domain.App byAppCode = appManage.getByAppCode(app.getAppCode());
        if(null != byAppCode){
            return "应用编码已存在";
        }
        if(StringUtils.isBlank(app.getAppName())){
            return emptyMsg("应用名称");
        }
        org.garen.cas.mybatis.domain.App byAppName = appManage.getByAppName(app.getAppName());
        if(null != byAppName){
            return "应用名称已存在";
        }
        if(app.getPermission() == null){
            return emptyMsg("是否应用");
        }
        return null;
    }

    /**
     * 修改应用类型，验证参数
     *
     * @param app
     * @return
     */
    public String updateValid(App app){
        if(app == null){
            return paramNullMsg();
        }
        if(app.getId() == null || app.getId() == 0){
            return emptyMsg("id");
        }
        if(StringUtils.isBlank(app.getAppCode())
                && StringUtils.isBlank(app.getAppName())
                && null == app.getPermission()
                ){
            return paramNullMsg();
        }
        return null;
    }
    
}
