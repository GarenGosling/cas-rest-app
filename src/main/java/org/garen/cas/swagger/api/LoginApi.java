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

}
