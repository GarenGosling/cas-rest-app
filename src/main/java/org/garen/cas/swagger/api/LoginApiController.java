package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.garen.cas.service.LoginInfoManage;
import org.garen.cas.service.LoginManage;
import org.garen.cas.swagger.model.BaseModel;
import org.garen.cas.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class LoginApiController extends BaseModel implements LoginApi {

    @Autowired
    LoginManage loginManage;

    public ResponseEntity<ResponseModel> login(@ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
                                               @ApiParam(value = "密码") @RequestParam(value = "password", required = false) String password) {
        Map<String, Object> map = loginManage.login(loginName, password);
        if((Boolean) map.get("isLogin")){
            return new ResponseEntity<ResponseModel>(successModel("登录", map), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel("登录失败"), HttpStatus.OK);
    }

}
