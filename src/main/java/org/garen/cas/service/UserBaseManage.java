package org.garen.cas.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.cas.EsapiUtil;
import org.garen.cas.mybatis.domain.App;
import org.garen.cas.mybatis.domain.AppQuery;
import org.garen.cas.mybatis.domain.UserBase;
import org.garen.cas.mybatis.domain.UserBaseQuery;
import org.garen.cas.mybatis.service.AppService;
import org.garen.cas.mybatis.service.UserBaseService;
import org.garen.cas.util.TransferUtil;
import org.owasp.esapi.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户基本信息业务类
 *
 * @author Garen Gosling
 * @create 2017-10-20 00:33
 * @since v1.0
 */
@Service
public class UserBaseManage extends BaseManage<Long>{
    @Autowired
    UserBaseService<UserBase, UserBaseQuery, Long> service;

    @Override
    public UserBaseService<UserBase, UserBaseQuery, Long> getService() {
        return service;
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param userCode
     * @param realName
     * @param nickname
     * @param mobile
     * @param email
     * @return
     */
    public Map getByPage(Integer start,
                         Integer length,
                         String userCode,
                         String realName,
                         String nickname,
                         String mobile,
                         String email){
        List<UserBase> list = getPageList(start, length, userCode, realName, nickname, mobile, email);
        int count = getPageCount(userCode, realName, nickname, mobile, email);
        return page(list, count);
    }

    /**
     * 分页查询之列表
     *
     * @param start
     * @param length
     * @param userCode
     * @param realName
     * @param nickname
     * @param mobile
     * @param email
     * @return
     */
    private List<UserBase> getPageList(Integer start,
                                  Integer length,
                                  String userCode,
                                  String realName,
                                  String nickname,
                                  String mobile,
                                  String email){
        if(start == null) start = START;
        if(length == null) length = LENGTH;
        UserBaseQuery query = new UserBaseQuery();
        UserBaseQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(userCode)){
            criteria.andUserCodeEqualTo(userCode);
        }
        if(StringUtils.isNotBlank(realName)){
            criteria.andRealNameEqualTo("%" + EsapiUtil.sql(realName) + "%");
        }
        if(StringUtils.isNotBlank(nickname)){
            criteria.andNicknameEqualTo("%" + EsapiUtil.sql(nickname) + "%");
        }
        if(StringUtils.isNotBlank(mobile)){
            criteria.andMobileEqualTo(mobile);
        }
        if(StringUtils.isNotBlank(email)){
            criteria.andEmailEqualTo(email);
        }
        query.setOrderByClause("id desc");
        return getService().findBy(new RowBounds(start, length), query);
    }


    /**
     * 分页查询之数量
     *
     * @param userCode
     * @param realName
     * @param nickname
     * @param mobile
     * @param email
     * @return
     */
    private int getPageCount(String userCode,
                             String realName,
                             String nickname,
                             String mobile,
                             String email){
        String sql = "select count(*) count from app where 1=1 ";
        if(StringUtils.isNotBlank(userCode)){
            sql += " AND user_code = '"+ EsapiUtil.sql(userCode) +"'";
        }
        if(StringUtils.isNotBlank(realName)){
            sql += " AND real_name like '%"+ EsapiUtil.sql(realName) +"%'";
        }
        if(StringUtils.isNotBlank(nickname)){
            sql += " AND nickname like '%"+ EsapiUtil.sql(nickname) +"%'";
        }
        if(StringUtils.isNotBlank(mobile)){
            sql += " AND mobile = '"+ EsapiUtil.sql(mobile) +"'";
        }
        if(StringUtils.isNotBlank(email)){
            sql += " AND email = '"+ EsapiUtil.sql(email) +"'";
        }
        return getService().countBySQL(sql);
    }

    /**
     * 新增
     *
     * @param userBase
     * @return
     */
    public int saveApp(org.garen.cas.swagger.model.UserBase userBase){
        // 类型转换
        UserBase dest = transfer(userBase);
        // 处理业务
        dest.setCreateTime(new Date());
        return create(dest);
    }

    /**
     * 修改
     *
     * @param userBase
     * @return
     */
    public int updateApp(org.garen.cas.swagger.model.UserBase userBase){
        // 类型转换
        UserBase dest = transfer(userBase);
        // 处理业务
        return modify(dest);
    }

    /**
     * 通过用户编码查询
     *
     * @param userCode
     * @return
     */
    public UserBase getByUserCode(String userCode){
        return getByParam(userCode, null, null);
    }

    /**
     * 通过手机号查询
     *
     * @param mobile
     * @return
     */
    public UserBase getByMobil(String mobile){
        return getByParam(null, mobile, null);
    }

    /**
     * 通过邮箱查询
     *
     * @param email
     * @return
     */
    public UserBase getByEmail(String email){
        return getByParam(null, null, email);
    }

    /**
     * 类型转换
     *
     * @param userBase
     * @return
     */
    private UserBase transfer(org.garen.cas.swagger.model.UserBase userBase){
        UserBase dest = new UserBase();
        TransferUtil.transfer(dest, userBase);
        return dest;
    }

    /**
     * 根据userCode/mobile/email查询
     *
     * @param userCode
     * @param mobile
     * @param email
     * @return
     */
    private UserBase getByParam(String userCode, String mobile, String email){
        UserBaseQuery query = new UserBaseQuery();
        UserBaseQuery.Criteria criteria = query.createCriteria();
        if(StringUtils.isNotBlank(userCode)){
            criteria.andUserCodeEqualTo(EsapiUtil.sql(userCode));
        }
        if(StringUtils.isNotBlank(mobile)){
            criteria.andMobileEqualTo(EsapiUtil.sql(mobile));
        }
        if(StringUtils.isNotBlank(email)){
            criteria.andEmailEqualTo(EsapiUtil.sql(email));
        }
        List<UserBase> userBases = getService().findBy(query);
        UserBase userBase = null;
        if(userBases.size() >= 1){
            userBase = userBases.get(0);
        }
        return userBase;
    }
}
