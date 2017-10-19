package org.garen.cas.mybatis.domain;

import java.util.Date;

public class UserBase {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.id
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.user_code
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    private String userCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.real_name
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.nickname
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.mobile
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.email
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_base.create_time
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base.id
     *
     * @return the value of user_base.id
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base.id
     *
     * @param id the value for user_base.id
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base.user_code
     *
     * @return the value of user_base.user_code
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base.user_code
     *
     * @param userCode the value for user_base.user_code
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base.real_name
     *
     * @return the value of user_base.real_name
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base.real_name
     *
     * @param realName the value for user_base.real_name
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base.nickname
     *
     * @return the value of user_base.nickname
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base.nickname
     *
     * @param nickname the value for user_base.nickname
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base.mobile
     *
     * @return the value of user_base.mobile
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base.mobile
     *
     * @param mobile the value for user_base.mobile
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base.email
     *
     * @return the value of user_base.email
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base.email
     *
     * @param email the value for user_base.email
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_base.create_time
     *
     * @return the value of user_base.create_time
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_base.create_time
     *
     * @param createTime the value for user_base.create_time
     *
     * @mbg.generated Thu Oct 19 21:41:54 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}