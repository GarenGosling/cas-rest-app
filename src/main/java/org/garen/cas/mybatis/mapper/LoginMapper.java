package org.garen.cas.mybatis.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.cas.mybatis.domain.Login;
import org.garen.cas.mybatis.domain.LoginQuery;

public interface LoginMapper <T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    long countByExample(LoginQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int deleteByExample(LoginQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int insert(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int insertSelective(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    List<Login> selectByExample(LoginQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    Login selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int updateByExample(@Param("record") Login record, @Param("example") LoginQuery example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int updateByPrimaryKeySelective(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    int updateByPrimaryKey(Login record);
}