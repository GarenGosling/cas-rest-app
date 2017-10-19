package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.garen.cas.swagger.model.ResponseModel;
import org.garen.cas.swagger.model.UserBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class UserBaseApiController implements UserBaseApi {

    public ResponseEntity<ResponseModel> deleteUserBase(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBase(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBaseAll() {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBasesByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode,
        @ApiParam(value = "真实姓名") @RequestParam(value = "realName", required = false) String realName,
        @ApiParam(value = "昵称") @RequestParam(value = "nickname", required = false) String nickname,
        @ApiParam(value = "手机号") @RequestParam(value = "mobile", required = false) String mobile,
        @ApiParam(value = "邮箱") @RequestParam(value = "email", required = false) String email) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveUserBase(@ApiParam(value = "用户基本信息"  ) @RequestBody UserBase userBase) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateUserBase(@ApiParam(value = "用户基本信息"  ) @RequestBody UserBase app) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

}
