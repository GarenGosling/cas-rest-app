package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.garen.cas.swagger.model.ResponseModel;
import org.garen.cas.swagger.model.UserApp;
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
public class UserAppApiController implements UserAppApi {

    public ResponseEntity<ResponseModel> deleteUserApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserAppAll() {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserAppsByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode,
        @ApiParam(value = "应用编码") @RequestParam(value = "appCode", required = false) String appCode,
        @ApiParam(value = "上架 0 下架 1") @RequestParam(value = "permission", required = false) String permission) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveUserApp(@ApiParam(value = "用户应用关系"  ) @RequestBody UserApp userApp) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateUserApp(@ApiParam(value = "用户应用关系"  ) @RequestBody UserApp app) {
        // do some magic!
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

}
