package org.garen.cas.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * App
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

public class App   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("appCode")
  private String appCode = null;

  @JsonProperty("appName")
  private String appName = null;

  @JsonProperty("permission")
  private Boolean permission = null;

  public App id(Long id) {
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

  public App appCode(String appCode) {
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

  public App appName(String appName) {
    this.appName = appName;
    return this;
  }

   /**
   * 应用名称
   * @return appName
  **/
  @ApiModelProperty(value = "应用名称")
  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public App permission(Boolean permission) {
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
    App app = (App) o;
    return Objects.equals(this.id, app.id) &&
        Objects.equals(this.appCode, app.appCode) &&
        Objects.equals(this.appName, app.appName) &&
        Objects.equals(this.permission, app.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, appCode, appName, permission);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class App {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    appCode: ").append(toIndentedString(appCode)).append("\n");
    sb.append("    appName: ").append(toIndentedString(appName)).append("\n");
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

