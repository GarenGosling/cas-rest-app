package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.garen.cas.swagger.model.LoginInfo;
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
public class LoginInfoApiController implements LoginInfoApi {

    public ResponseEntity<ResponseModel> deleteLoginInfo(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getLoginInfo(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getLoginInfosAll() {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getLoginInfosByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
        @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveLoginInfo(@ApiParam(value = "登录信息"  ) @RequestBody LoginInfo loginInfo) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateLoginInfo(@ApiParam(value = "登录信息"  ) @RequestBody LoginInfo app) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

}
