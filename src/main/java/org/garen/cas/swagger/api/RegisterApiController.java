package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.LoginManage;
import org.garen.cas.service.RegisterManage;
import org.garen.cas.swagger.api.valid.RegisterValid;
import org.garen.cas.swagger.api.valid.UserAppValid;
import org.garen.cas.swagger.model.BaseModel;
import org.garen.cas.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class RegisterApiController extends BaseModel implements RegisterApi {
    @Autowired
    RegisterManage registerManage;
    @Autowired
    RegisterValid valid;
    @Autowired
    LoginManage loginManage;

    public ResponseEntity<ResponseModel> register(@ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
                                                  @ApiParam(value = "密码") @RequestParam(value = "password", required = false) String password,
                                                  @ApiParam(value = "应用编码拼串，以英文逗号分隔") @RequestParam(value = "appCodes", required = false) String appCodes) {
        String msg = valid.registerValid(loginName, password, appCodes);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = registerManage.register(loginName, password, appCodes);
        if(i==1){
            // 注册成功
            Map<String, Object> map = loginManage.login(loginName, password);
            if((Boolean) map.get("isLogin")){
                return new ResponseEntity<ResponseModel>(successModel("注册成功，登录", map), HttpStatus.OK);
            }
            return new ResponseEntity<ResponseModel>(badRequestModel("注册成功，登录失败"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel("注册失败"), HttpStatus.OK);
    }

    @Override
    public String toRegister() {
        return "register";
    }

}
