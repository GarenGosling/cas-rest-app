package org.garen.cas.swagger.api;



import io.swagger.annotations.*;
import org.garen.cas.swagger.model.ResponseModel;
import org.garen.cas.swagger.model.UserBase;
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

@Api(value = "userBase", description = "the userBase API")
public interface UserBaseApi {

    @ApiOperation(value = "删除用户基本信息", notes = "删除用户基本信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userBase",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteUserBase(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userBase",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getUserBase(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userBase/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getUserBaseAll();


    @ApiOperation(value = "分页查询", notes = "分页查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userBase/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getUserBasesByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                     @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                                     @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode,
                                                     @ApiParam(value = "真实姓名") @RequestParam(value = "realName", required = false) String realName,
                                                     @ApiParam(value = "昵称") @RequestParam(value = "nickname", required = false) String nickname,
                                                     @ApiParam(value = "手机号") @RequestParam(value = "mobile", required = false) String mobile,
                                                     @ApiParam(value = "邮箱") @RequestParam(value = "email", required = false) String email);


    @ApiOperation(value = "新增用户基本信息", notes = "新增用户基本信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userBase",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveUserBase(@ApiParam(value = "用户基本信息") @RequestBody UserBase userBase);


    @ApiOperation(value = "修改用户基本信息", notes = "修改用户基本信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userBase",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateUserBase(@ApiParam(value = "用户基本信息") @RequestBody UserBase app);

}
