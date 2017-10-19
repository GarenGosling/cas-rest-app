package org.garen.cas.mybatis.service;

import org.garen.cas.mybatis.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/14.
 */
@Service
public class AppService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    AppMapper<T, Q, PK> mapper;
    @Override
    public AppMapper<T, Q, PK> getMapper() {
        return mapper;
    }

}
