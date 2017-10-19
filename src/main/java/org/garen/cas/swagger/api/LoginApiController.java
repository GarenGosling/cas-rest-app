package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.garen.cas.swagger.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class LoginApiController implements LoginApi {

    public ResponseEntity<ResponseModel> login(@ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
                                               @ApiParam(value = "密码") @RequestParam(value = "password", required = false) String password) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

}
