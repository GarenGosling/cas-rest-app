package org.garen.cas.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserApp
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

public class UserApp   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userCode")
  private String userCode = null;

  @JsonProperty("appCode")
  private String appCode = null;

  @JsonProperty("permission")
  private Boolean permission = null;

  public UserApp id(Long id) {
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

  public UserApp userCode(String userCode) {
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

  public UserApp appCode(String appCode) {
    this.appCode = appCode;
    return this;
  }

   /**
   * 应用编码
   * @return appCode
  **/
  @ApiModelProperty(value = "应用编码")
  public String getAppCode() {
    return appCode;
  }

  public void setAppCode(String appCode) {
    this.appCode = appCode;
  }

  public UserApp permission(Boolean permission) {
    this.permission = permission;
    return this;
  }

   /**
   * 上架 0 下架 1
   * @return permission
  **/
  @ApiModelProperty(value = "上架 0 下架 1")
  public Boolean getPermission() {
    return permission;
  }

  public void setPermission(Boolean permission) {
    this.permission = permission;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserApp userApp = (UserApp) o;
    return Objects.equals(this.id, userApp.id) &&
        Objects.equals(this.userCode, userApp.userCode) &&
        Objects.equals(this.appCode, userApp.appCode) &&
        Objects.equals(this.permission, userApp.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userCode, appCode, permission);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserApp {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userCode: ").append(toIndentedString(userCode)).append("\n");
    sb.append("    appCode: ").append(toIndentedString(appCode)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
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

