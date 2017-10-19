package org.garen.cas.mybatis.service;

import org.garen.cas.mybatis.mapper.LoginMapper;
import org.garen.cas.mybatis.mapper.UserAppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/14.
 */
@Service
public class UserAppService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    UserAppMapper<T, Q, PK> mapper;
    @Override
    public UserAppMapper<T, Q, PK> getMapper() {
        return mapper;
    }

}
