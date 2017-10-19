package org.garen.cas.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * LoginInfo
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

public class LoginInfo   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("loginName")
  private String loginName = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("userCode")
  private String userCode = null;

  public LoginInfo id(Long id) {
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

  public LoginInfo loginName(String loginName) {
    this.loginName = loginName;
    return this;
  }

   /**
   * 登录名
   * @return loginName
  **/
  @ApiModelProperty(value = "登录名")
  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public LoginInfo password(String password) {
    this.password = password;
    return this;
  }

   /**
   * 密码
   * @return password
  **/
  @ApiModelProperty(value = "密码")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LoginInfo userCode(String userCode) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginInfo loginInfo = (LoginInfo) o;
    return Objects.equals(this.id, loginInfo.id) &&
        Objects.equals(this.loginName, loginInfo.loginName) &&
        Objects.equals(this.password, loginInfo.password) &&
        Objects.equals(this.userCode, loginInfo.userCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, loginName, password, userCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    userCode: ").append(toIndentedString(userCode)).append("\n");
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

