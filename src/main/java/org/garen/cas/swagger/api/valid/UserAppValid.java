package org.garen.cas.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.UserAppManage;
import org.garen.cas.service.UserBaseManage;
import org.garen.cas.swagger.model.UserApp;
import org.garen.cas.swagger.model.UserBase;
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
public class UserAppValid extends BaseValid {
    @Autowired
    UserAppManage userAppManage;

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
     * 新增应用，验证参数
     *
     * @param userApp
     * @return
     */
    public String saveValid(UserApp userApp){
        if(userApp == null){
            return paramNullMsg();
        }
        if(StringUtils.isBlank(userApp.getUserCode())){
            return emptyMsg("用户编码");
        }
        if(StringUtils.isBlank(userApp.getAppCode())){
            return emptyMsg("应用编码");
        }
        org.garen.cas.mybatis.domain.UserApp byCode = userAppManage.getByCode(userApp.getUserCode(), userApp.getAppCode());
        if(null != byCode){
            return "用户应用关系已存在";
        }
        if(null == userApp.getPermission()){
            return "是否应用不能为空";
        }
        return null;
    }

    /**
     * 修改应用类型，验证参数
     *
     * @param userApp
     * @return
     */
    public String updateValid(UserApp userApp){
        if(userApp == null){
            return paramNullMsg();
        }
        if(userApp.getId() == null || userApp.getId() == 0){
            return emptyMsg("id");
        }
        if(StringUtils.isBlank(userApp.getUserCode())
                && StringUtils.isBlank(userApp.getAppCode())
                && null == userApp.getPermission()
                ){
            return paramNullMsg();
        }
        return null;
    }
    
}
