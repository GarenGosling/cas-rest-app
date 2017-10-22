package org.garen.cas.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.cas.EsapiUtil;
import org.garen.cas.mybatis.domain.UserApp;
import org.garen.cas.mybatis.domain.UserAppQuery;
import org.garen.cas.mybatis.domain.UserBase;
import org.garen.cas.mybatis.domain.UserBaseQuery;
import org.garen.cas.mybatis.service.UserAppService;
import org.garen.cas.mybatis.service.UserBaseService;
import org.garen.cas.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户应用关系业务类
 *
 * @author Garen Gosling
 * @create 2017-10-20 00:33
 * @since v1.0
 */
@Service
public class UserAppManage extends BaseManage<Long>{
    @Autowired
    UserAppService<UserApp, UserAppQuery, Long> service;

    @Override
    public UserAppService<UserApp, UserAppQuery, Long> getService() {
        return service;
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param userCode
     * @param appCode
     * @param permission
     * @return
     */
    public Map getByPage(Integer start,
                         Integer length,
                         String userCode,
                         String appCode,
                         Boolean permission){
        List<UserApp> list = getPageList(start, length, userCode, appCode, permission);
        int count = getPageCount(userCode, appCode, permission);
        return page(list, count);
    }

    /**
     * 分页查询之列表
     *
     * @param start
     * @param length
     * @param userCode
     * @param appCode
     * @param permission
     * @return
     */
    private List<UserApp> getPageList(Integer start,
                                       Integer length,
                                       String userCode,
                                       String appCode,
                                       Boolean permission){
        if(start == null) start = START;
        if(length == null) length = LENGTH;
        UserAppQuery query = new UserAppQuery();
        UserAppQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(userCode)){
            criteria.andUserCodeEqualTo(userCode);
        }
        if(StringUtils.isNotBlank(appCode)){
            criteria.andAppCodeEqualTo(appCode);
        }
        if(null != permission){
            criteria.andPermissionEqualTo(permission);
        }
        query.setOrderByClause("id desc");
        return getService().findBy(new RowBounds(start, length), query);
    }


    /**
     * 分页查询之数量
     *
     * @param userCode
     * @param appCode
     * @param permission
     * @return
     */
    private int getPageCount(String userCode,
                             String appCode,
                             Boolean permission){
        String sql = "select count(*) count from user_app where 1=1 ";
        if(StringUtils.isNotBlank(userCode)){
            sql += " AND user_code = '"+ EsapiUtil.sql(userCode) +"'";
        }
        if(StringUtils.isNotBlank(appCode)){
            sql += " AND app_code = '"+ EsapiUtil.sql(appCode) +"'";
        }
        if(null != permission){
            sql += " AND permission = '"+ EsapiUtil.sql((permission?0:1)+"") +"'";
        }
        return getService().countBySQL(sql);
    }

    /**
     * 新增
     *
     * @param userApp
     * @return
     */
    public int saveApp(org.garen.cas.swagger.model.UserApp userApp){
        // 类型转换
        UserApp dest = transfer(userApp);
        // 处理业务
        dest.setCreateTime(new Date());
        return create(dest);
    }

    /**
     * 修改
     *
     * @param userApp
     * @return
     */
    public int updateApp(org.garen.cas.swagger.model.UserApp userApp){
        // 类型转换
        UserApp dest = transfer(userApp);
        // 处理业务
        return modify(dest);
    }

    /**
     * 类型转换
     *
     * @param userApp
     * @return
     */
    private UserApp transfer(org.garen.cas.swagger.model.UserApp userApp){
        UserApp dest = new UserApp();
        TransferUtil.transfer(dest, userApp);
        return dest;
    }

    /**
     * 根据 userCode & appCode 查询
     *
     * @param userCode
     * @param appCode
     * @return
     */
    public UserApp getByCode(String userCode, String appCode){
        UserAppQuery query = new UserAppQuery();
        UserAppQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(userCode) && StringUtils.isNotBlank(appCode)){
            criteria.andUserCodeEqualTo(EsapiUtil.sql(userCode));
            criteria.andAppCodeEqualTo(EsapiUtil.sql(appCode));
        }
        List<UserApp> userApps = getService().findBy(query);
        UserApp userApp = null;
        if(userApps.size() >= 1){
            userApp = userApps.get(0);
        }
        return userApp;
    }

}
