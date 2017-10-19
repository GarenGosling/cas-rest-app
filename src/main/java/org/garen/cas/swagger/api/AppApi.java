package org.garen.cas.swagger.api;



import io.swagger.annotations.*;
import org.garen.cas.swagger.model.App;
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

@Api(value = "app", description = "the app API")
public interface AppApi {

    @ApiOperation(value = "删除应用", notes = "删除应用 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/app",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/app",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/app/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAppsAll();


    @ApiOperation(value = "分页查询", notes = "分页查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/app/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAppsByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                                @ApiParam(value = "应用编码") @RequestParam(value = "appCode", required = false) String appCode,
                                                @ApiParam(value = "应用名称") @RequestParam(value = "appName", required = false) String appName,
                                                @ApiParam(value = "上架 0 下架 1") @RequestParam(value = "permission", required = false) String permission);


    @ApiOperation(value = "新增应用", notes = "新增应用 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/app",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveApp(@ApiParam(value = "应用") @RequestBody App app);


    @ApiOperation(value = "修改应用", notes = "修改应用 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/app",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateApp(@ApiParam(value = "应用") @RequestBody App app);

}
