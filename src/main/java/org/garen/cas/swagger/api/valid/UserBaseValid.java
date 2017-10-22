package org.garen.cas.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.AppManage;
import org.garen.cas.service.UserBaseManage;
import org.garen.cas.swagger.model.App;
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
public class UserBaseValid extends BaseValid {
    @Autowired
    UserBaseManage userBaseManage;

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
     * @param userBase
     * @return
     */
    public String saveValid(UserBase userBase){
        if(userBase == null){
            return paramNullMsg();
        }
        if(StringUtils.isNotBlank(userBase.getUserCode())){
            org.garen.cas.mybatis.domain.UserBase byUserCode = userBaseManage.getByUserCode(userBase.getUserCode());
            if(null != byUserCode){
                return "用户编码已存在";
            }
        }
        if(StringUtils.isNotBlank(userBase.getMobile())){
            org.garen.cas.mybatis.domain.UserBase byMobil = userBaseManage.getByMobil(userBase.getMobile());
            if(null != byMobil){
                return "手机号已存在";
            }
        }
        if(StringUtils.isNotBlank(userBase.getEmail())){
            org.garen.cas.mybatis.domain.UserBase byEmail = userBaseManage.getByEmail(userBase.getMobile());
            if(null != byEmail){
                return "邮箱已存在";
            }
        }
        return null;
    }

    /**
     * 修改应用类型，验证参数
     *
     * @param userBase
     * @return
     */
    public String updateValid(UserBase userBase){
        if(userBase == null){
            return paramNullMsg();
        }
        if(userBase.getId() == null || userBase.getId() == 0){
            return emptyMsg("id");
        }
        if(StringUtils.isBlank(userBase.getRealName())
                && StringUtils.isBlank(userBase.getNickname())
                && StringUtils.isBlank(userBase.getMobile())
                && StringUtils.isBlank(userBase.getEmail())
                ){
            return paramNullMsg();
        }
        return null;
    }
    
}
