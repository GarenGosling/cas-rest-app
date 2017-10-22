package org.garen.cas.swagger.api;



import io.swagger.annotations.*;
import org.garen.cas.swagger.model.ResponseModel;
import org.garen.cas.swagger.model.UserApp;
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

@Api(value = "userApp", description = "the userApp API")
public interface UserAppApi {

    @ApiOperation(value = "删除用户应用关系", notes = "删除用户应用关系 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userApp",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteUserApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userApp",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getUserApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userApp/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getUserAppAll();


    @ApiOperation(value = "分页查询", notes = "分页查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userApp/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getUserAppsByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                    @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                                    @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode,
                                                    @ApiParam(value = "应用编码") @RequestParam(value = "appCode", required = false) String appCode,
                                                    @ApiParam(value = "上架 0 下架 1") @RequestParam(value = "permission", required = false) Boolean permission);


    @ApiOperation(value = "新增用户应用关系", notes = "新增用户应用关系 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userApp",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveUserApp(@ApiParam(value = "用户应用关系") @RequestBody UserApp userApp);


    @ApiOperation(value = "修改用户应用关系", notes = "修改用户应用关系 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userApp",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateUserApp(@ApiParam(value = "用户应用关系") @RequestBody UserApp app);

    @ApiOperation(value = "编码查询", notes = "编码查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/userApp/code",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getUserAppByCode(@ApiParam(value = "userCode") @RequestParam(value = "userCode", required = false) String userCode,
                                                   @ApiParam(value = "appCode") @RequestParam(value = "appCode", required = false) String appCode);
}
