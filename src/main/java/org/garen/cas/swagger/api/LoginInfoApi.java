package org.garen.cas.swagger.api;



import io.swagger.annotations.*;
import org.garen.cas.swagger.model.LoginInfo;
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

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Api(value = "loginInfo", description = "the loginInfo API")
public interface LoginInfoApi {

    @ApiOperation(value = "删除登录信息", notes = "删除登录信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginInfo",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteLoginInfo(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginInfo",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLoginInfo(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginInfo/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLoginInfosAll();


    @ApiOperation(value = "分页查询", notes = "分页查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginInfo/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLoginInfosByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                      @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                                      @ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
                                                      @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode);


    @ApiOperation(value = "新增登录信息", notes = "新增登录信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginInfo",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveLoginInfo(@ApiParam(value = "登录信息") @RequestBody LoginInfo loginInfo);


    @ApiOperation(value = "修改登录信息", notes = "修改登录信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/loginInfo",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateLoginInfo(@ApiParam(value = "登录信息") @RequestBody LoginInfo app);

}
