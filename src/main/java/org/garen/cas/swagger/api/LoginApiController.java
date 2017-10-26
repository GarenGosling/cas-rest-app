package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.LoginInfoManage;
import org.garen.cas.service.LoginManage;
import org.garen.cas.swagger.model.BaseModel;
import org.garen.cas.swagger.model.ResponseModel;
import org.garen.cas.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public ResponseEntity<ResponseModel> getLoginVo(HttpServletRequest request, HttpServletResponse response) {
        String ticket = request.getHeader("ticket");
        if(StringUtils.isBlank(ticket)){
            return new ResponseEntity<ResponseModel>(badRequestModel("获取登录信息失败，没有登录票据"), HttpStatus.OK);
        }
        LoginVo loginVo = loginManage.getLoginVoByTicket(ticket);
        if(loginVo == null){
            return new ResponseEntity<ResponseModel>(badRequestModel("获取登录信息失败，登录信息为空"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(successModel("获取登录信息成功", loginVo), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getLoginVo2(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket) {
        if(StringUtils.isBlank(ticket)){
            return new ResponseEntity<ResponseModel>(badRequestModel("获取登录信息失败，没有登录票据"), HttpStatus.OK);
        }
        LoginVo loginVo = loginManage.getLoginVoByTicket(ticket);
        if(loginVo == null){
            return new ResponseEntity<ResponseModel>(badRequestModel("获取登录信息失败，登录信息为空"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(successModel("获取登录信息成功", loginVo), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> isLogin(HttpServletRequest request, HttpServletResponse response) {
        String ticket = request.getHeader("ticket");
        boolean isLogin = loginManage.isLogin(ticket);
        if(isLogin){
            return new ResponseEntity<ResponseModel>(successModel("已登录"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel("未登录"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> isLogin(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket) {
        if(StringUtils.isBlank(ticket)){
            return new ResponseEntity<ResponseModel>(badRequestModel("未登录"), HttpStatus.OK);
        }
        boolean isLogin = loginManage.isLogin(ticket);
        if(isLogin){
            return new ResponseEntity<ResponseModel>(successModel("已登录"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel("未登录"), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> logout(HttpServletRequest request, HttpServletResponse response) {
        String ticket = request.getHeader("ticket");
        if(StringUtils.isBlank(ticket)){
            return new ResponseEntity<ResponseModel>(badRequestModel("退出登录失败，没有登录票据"), HttpStatus.OK);
        }
        boolean logout = loginManage.logout(ticket);
        if(logout){
            return new ResponseEntity<ResponseModel>(successModel("退出登录成功"), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel("退出登录失败，系统异常"), HttpStatus.OK);
    }

    @Override
    public String toLogin(){
        return "login";
    }


}
