package org.garen.cas.swagger.api;



import io.swagger.annotations.*;
import org.garen.cas.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Api(value = "login", description = "the login API")
public interface LoginApi {

    @ApiOperation(value = "登录", notes = "登录 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/login",
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> login(@ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
                                        @ApiParam(value = "密码") @RequestParam(value = "password", required = false) String password);

    @ApiOperation(value = "获取登录信息", notes = "获取登录信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginVo",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLoginVo(HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "获取登录信息", notes = "获取登录信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginVo2",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLoginVo2(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket);

    @ApiOperation(value = "登录验证", notes = "登录验证 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/isLogin",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> isLogin(HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "登录验证", notes = "登录验证 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/isLogin",
            method = RequestMethod.POST)
    ResponseEntity<ResponseModel> isLogin(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket);

    @ApiOperation(value = "退出登录", notes = "退出登录 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/logout",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> logout(HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "跳转到登录页面", notes = "跳转到登录页面 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String toLogin();


}
