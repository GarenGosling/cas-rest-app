package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.AppManage;
import org.garen.cas.service.UserBaseManage;
import org.garen.cas.swagger.api.valid.AppValid;
import org.garen.cas.swagger.api.valid.UserBaseValid;
import org.garen.cas.swagger.model.BaseModel;
import org.garen.cas.swagger.model.ResponseModel;
import org.garen.cas.swagger.model.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class UserBaseApiController extends BaseModel implements UserBaseApi {

    @Autowired
    UserBaseValid valid;
    @Autowired
    UserBaseManage userBaseManage;

    public ResponseEntity<ResponseModel> deleteUserBase(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = userBaseManage.removeById(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBase(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = userBaseManage.findById(id);
        return new ResponseEntity<ResponseModel>(successModel("查询成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBaseAll() {
        List<org.garen.cas.mybatis.domain.UserBase> all =userBaseManage.findAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBasesByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode,
        @ApiParam(value = "真实姓名") @RequestParam(value = "realName", required = false) String realName,
        @ApiParam(value = "昵称") @RequestParam(value = "nickname", required = false) String nickname,
        @ApiParam(value = "手机号") @RequestParam(value = "mobile", required = false) String mobile,
        @ApiParam(value = "邮箱") @RequestParam(value = "email", required = false) String email) {
        Map page = userBaseManage.getByPage(start, length, userCode, realName, nickname, mobile, email);
        return new ResponseEntity<ResponseModel>(successModel("分页查询", page), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveUserBase(@ApiParam(value = "用户基本信息"  ) @RequestBody UserBase userBase) {
        String msg = valid.saveValid(userBase);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = userBaseManage.saveApp(userBase);
        return new ResponseEntity<ResponseModel>(successModelMsg("新增成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateUserBase(@ApiParam(value = "用户基本信息"  ) @RequestBody UserBase userBase) {
        String msg = valid.updateValid(userBase);
        int i = userBaseManage.updateApp(userBase);
        return new ResponseEntity<ResponseModel>(successModelMsg("修改成功，数量：" + i), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBaseByCode(@ApiParam(value = "userCode") @RequestParam(value = "userCode", required = false) String userCode) {
        org.garen.cas.mybatis.domain.UserBase byUserCode = userBaseManage.getByUserCode(userCode);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byUserCode), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBaseByMobile(@ApiParam(value = "mobile") @RequestParam(value = "mobile", required = false) String mobile) {
        org.garen.cas.mybatis.domain.UserBase byMobil = userBaseManage.getByMobil(mobile);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byMobil), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserBaseByEmail(@ApiParam(value = "email") @RequestParam(value = "email", required = false) String email) {
        org.garen.cas.mybatis.domain.UserBase byEmail = userBaseManage.getByEmail(email);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byEmail), HttpStatus.OK);
    }


}
