package org.garen.cas.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserBase
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

public class UserBase   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userCode")
  private String userCode = null;

  @JsonProperty("realName")
  private String realName = null;

  @JsonProperty("nickname")
  private String nickname = null;

  @JsonProperty("mobile")
  private String mobile = null;

  @JsonProperty("email")
  private String email = null;

  public UserBase id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * ID
   * @return id
  **/
  @ApiModelProperty(value = "ID")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserBase userCode(String userCode) {
    this.userCode = userCode;
    return this;
  }

   /**
   * 用户编码
   * @return userCode
  **/
  @ApiModelProperty(value = "用户编码")
  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public UserBase realName(String realName) {
    this.realName = realName;
    return this;
  }

   /**
   * 真实姓名
   * @return realName
  **/
  @ApiModelProperty(value = "真实姓名")
  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public UserBase nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

   /**
   * 昵称
   * @return nickname
  **/
  @ApiModelProperty(value = "昵称")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public UserBase mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

   /**
   * 手机号
   * @return mobile
  **/
  @ApiModelProperty(value = "手机号")
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public UserBase email(String email) {
    this.email = email;
    return this;
  }

   /**
   * 邮箱
   * @return email
  **/
  @ApiModelProperty(value = "邮箱")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserBase userBase = (UserBase) o;
    return Objects.equals(this.id, userBase.id) &&
        Objects.equals(this.userCode, userBase.userCode) &&
        Objects.equals(this.realName, userBase.realName) &&
        Objects.equals(this.nickname, userBase.nickname) &&
        Objects.equals(this.mobile, userBase.mobile) &&
        Objects.equals(this.email, userBase.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userCode, realName, nickname, mobile, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBase {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userCode: ").append(toIndentedString(userCode)).append("\n");
    sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

