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
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Api(value = "register", description = "the register API")
public interface RegisterApi {

    @ApiOperation(value = "注册", notes = "注册 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/register",
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> register(@ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
                                           @ApiParam(value = "密码") @RequestParam(value = "password", required = false) String password,
                                           @ApiParam(value = "应用编码拼串，以英文逗号分隔") @RequestParam(value = "appCodes", required = false) String appCodes);

}
