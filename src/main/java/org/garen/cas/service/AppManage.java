package org.garen.cas.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.tomcat.jni.FileInfo;
import org.garen.cas.EsapiUtil;
import org.garen.cas.mybatis.domain.App;
import org.garen.cas.mybatis.domain.AppQuery;
import org.garen.cas.mybatis.service.AppService;
import org.garen.cas.mybatis.service.CommonsService;
import org.garen.cas.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 应用业务类
 *
 * @author Garen Gosling
 * @create 2017-10-20 00:33
 * @since v1.0
 */
@Service
public class AppManage extends BaseManage<Long>{

    @Autowired
    AppService<App, AppQuery, Long> service;

    @Override
    public AppService<App, AppQuery, Long> getService() {
        return service;
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param appCode
     * @param appName
     * @param permission
     * @return
     */
    public Map getByPage(Integer start,
                         Integer length,
                         String appCode,
                         String appName,
                         Boolean permission){
        List<App> list = getPageList(start, length, appCode, appName, permission);
        int count = getPageCount(appCode, appName, permission);
        return page(list, count);
    }

    /**
     * 分页查询之列表
     *
     * @param start
     * @param length
     * @param appCode
     * @param appName
     * @param permission
     * @return
     */
    private List<App> getPageList(Integer start,
                                       Integer length,
                                       String appCode,
                                       String appName,
                                       Boolean permission){
        if(start == null) start = START;
        if(length == null) length = LENGTH;
        AppQuery query = new AppQuery();
        AppQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(appCode)){
            criteria.andAppCodeEqualTo(appCode);
        }
        if(StringUtils.isNotBlank(appName)){
            criteria.andAppNameEqualTo("%" + EsapiUtil.sql(appName) + "%");
        }
        if(permission != null){
            criteria.andPermissionEqualTo(permission);
        }
        query.setOrderByClause("id desc");
        return getService().findBy(new RowBounds(start, length), query);
    }


    /**
     * 分页查询之数量
     *
     * @param appCode
     * @param appName
     * @param permission
     * @return
     */
    private int getPageCount(String appCode,
                             String appName,
                             Boolean permission){
        String sql = "select count(*) count from app where 1=1 ";
        if(StringUtils.isNotBlank(appCode)){
            sql += " AND app_code = '"+ EsapiUtil.sql(appCode) +"'";
        }
        if(StringUtils.isNotBlank(appName)){
            sql += " AND app_name like '%"+ EsapiUtil.sql(appName) +"%'";
        }
        if(permission != null){
            sql += " AND permission = "+ permission;
        }
        return getService().countBySQL(sql);
    }

    /**
     * 新增
     *
     * @param app
     * @return
     */
    public int saveApp(org.garen.cas.swagger.model.App app){
        // 类型转换
        App dest = transfer(app);
        // 处理业务
        dest.setCreateTime(new Date());
        return create(dest);
    }

    /**
     * 修改
     *
     * @param app
     * @return
     */
    public int updateApp(org.garen.cas.swagger.model.App app){
        // 类型转换
        App dest = transfer(app);
        // 处理业务
        dest.setUpdateTime(new Date());
        return modify(dest);
    }

    /**
     * 通过appCode查询
     *
     * @param appCode
     * @return
     */
    public App getByAppCode(String appCode){
        return getByParam(appCode, null);
    }

    /**
     * 通过appName查询
     *
     * @param appName
     * @return
     */
    public App getByAppName(String appName){
        return getByParam(null, appName);
    }

    /**
     * 类型转换
     *
     * @param app
     * @return
     */
    private App transfer(org.garen.cas.swagger.model.App app){
        App dest = new App();
        TransferUtil.transfer(dest, app);
        return dest;
    }

    /**
     * 根据appCode/appName查询
     *
     * @param appCode
     * @param appName
     * @return
     */
    private App getByParam(String appCode, String appName){
        AppQuery query = new AppQuery();
        AppQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(appCode)){
            criteria.andAppCodeEqualTo(EsapiUtil.sql(appCode));
        }
        if(StringUtils.isNotBlank(appName)){
            criteria.andAppNameEqualTo(EsapiUtil.sql(appName));
        }
        List<App> apps = getService().findBy(query);
        App app = null;
        if(apps.size() >= 1){
            app = apps.get(0);
        }
        return app;
    }
}
