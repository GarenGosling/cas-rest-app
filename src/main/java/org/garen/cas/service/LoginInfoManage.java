package org.garen.cas.service;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.cas.EsapiUtil;
import org.garen.cas.mybatis.domain.*;
import org.garen.cas.mybatis.service.LoginService;
import org.garen.cas.mybatis.service.UserAppService;
import org.garen.cas.swagger.model.LoginInfo;
import org.garen.cas.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 登录信息业务类
 *
 * @author Garen Gosling
 * @create 2017-10-20 00:33
 * @since v1.0
 */
@Service
public class LoginInfoManage extends BaseManage<Long>{
    @Autowired
    LoginService<Login, LoginQuery, Long> service;

    @Override
    public LoginService<Login, LoginQuery, Long> getService() {
        return service;
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param loginName
     * @param userCode
     * @return
     */
    public Map getByPage(Integer start,
                         Integer length,
                         String loginName,
                         String userCode){
        List<Login> list = getPageList(start, length, loginName, userCode);
        List<Login> hidePasswordList = this.hidePassword(list);
        int count = getPageCount(loginName, userCode);
        return page(hidePasswordList, count);
    }

    /**
     * 分页查询之列表
     *
     * @param start
     * @param length
     * @param loginName
     * @param userCode
     * @return
     */
    private List<Login> getPageList(Integer start,
                                  Integer length,
                                  String loginName,
                                  String userCode){
        if(start == null) start = START;
        if(length == null) length = LENGTH;
        LoginQuery query = new LoginQuery();
        LoginQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(loginName)){
            criteria.andLoginNameEqualTo(loginName);
        }
        if(StringUtils.isNotBlank(userCode)){
            criteria.andUserCodeEqualTo(userCode);
        }
        query.setOrderByClause("id desc");
        return getService().findBy(new RowBounds(start, length), query);
    }


    /**
     * 分页查询之数量
     *
     * @param loginName
     * @param userCode
     * @return
     */
    private int getPageCount(String loginName,
                             String userCode){
        String sql = "select count(*) count from login where 1=1 ";
        if(StringUtils.isNotBlank(loginName)){
            sql += " AND login_name = '"+ EsapiUtil.sql(loginName) +"'";
        }
        if(StringUtils.isNotBlank(userCode)){
            sql += " AND user_code = '"+ EsapiUtil.sql(userCode) +"'";
        }
        return getService().countBySQL(sql);
    }

    /**
     * 新增
     *
     * @param loginInfo
     * @return
     */
    public int saveLoginInfo(org.garen.cas.swagger.model.LoginInfo loginInfo){
        // 类型转换
        Login dest = transfer(loginInfo);
        // 处理业务
        dest.setCreateTime(new Date());
        return create(dest);
    }

    /**
     * 修改
     *
     * @param loginInfo
     * @return
     */
    public int updateLoginInfo(org.garen.cas.swagger.model.LoginInfo loginInfo){
        // 类型转换
        Login dest = transfer(loginInfo);
        // 处理业务
        return modify(dest);
    }

    /**
     * 通过登录名查询
     *
     * @param loginName
     * @return
     */
    public Login getByLoginName(String loginName){
        return getByParam(loginName, null);
    }

    /**
     * 隐藏密码
     *
     * @param logins
     * @return
     */
    public List<Login> hidePassword(List<Login> logins){
        List<Login> list = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(logins)){
            for (Login login : logins) {
                login.setPassword("***");
                list.add(login);
            }
        }
        return list;
    }

    /**
     * 通过用户编码查询
     *
     * @param userCode
     * @return
     */
    public Login getByUserCode(String userCode){
        return getByParam(null, null);
    }

    /**
     * 类型转换
     *
     * @param loginInfo
     * @return
     */
    private Login transfer(org.garen.cas.swagger.model.LoginInfo loginInfo){
        Login dest = new Login();
        TransferUtil.transfer(dest, loginInfo);
        return dest;
    }

    /**
     * 根据loginName/userCode查询
     *
     * @param loginName
     * @param userCode
     * @return
     */
    private Login getByParam(String loginName, String userCode){
        LoginQuery query = new LoginQuery();
        LoginQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(loginName)){
            criteria.andLoginNameEqualTo(EsapiUtil.sql(loginName));
        }
        if(StringUtils.isNotBlank(userCode)){
            criteria.andUserCodeEqualTo(EsapiUtil.sql(userCode));
        }
        List<Login> logins = getService().findBy(query);
        Login login = null;
        if(logins.size() >= 1){
            login = logins.get(0);
        }
        return login;
    }

}
