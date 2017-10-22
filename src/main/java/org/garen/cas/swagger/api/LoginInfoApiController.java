package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.mybatis.domain.Login;
import org.garen.cas.service.AppManage;
import org.garen.cas.service.LoginInfoManage;
import org.garen.cas.swagger.api.valid.AppValid;
import org.garen.cas.swagger.api.valid.LoginInfoValid;
import org.garen.cas.swagger.model.BaseModel;
import org.garen.cas.swagger.model.LoginInfo;
import org.garen.cas.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class LoginInfoApiController extends BaseModel implements LoginInfoApi {

    @Autowired
    LoginInfoValid valid;
    @Autowired
    LoginInfoManage loginInfoManage;

    public ResponseEntity<ResponseModel> deleteLoginInfo(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = loginInfoManage.removeById(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getLoginInfo(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = loginInfoManage.findById(id);
        return new ResponseEntity<ResponseModel>(successModel("查询成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getLoginInfosAll() {
        List<org.garen.cas.mybatis.domain.Login> all =loginInfoManage.findAll();
        List<Login> logins = loginInfoManage.hidePassword(all);
        return new ResponseEntity<ResponseModel>(successModel("查询全部", logins), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getLoginInfosByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "登录名称") @RequestParam(value = "loginName", required = false) String loginName,
        @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode) {
        Map page = loginInfoManage.getByPage(start, length, loginName, userCode);
        return new ResponseEntity<ResponseModel>(successModel("分页查询", page), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveLoginInfo(@ApiParam(value = "登录信息"  ) @RequestBody LoginInfo loginInfo) {
        String msg = valid.saveValid(loginInfo);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = loginInfoManage.saveLoginInfo(loginInfo);
        return new ResponseEntity<ResponseModel>(successModelMsg("新增成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateLoginInfo(@ApiParam(value = "登录信息"  ) @RequestBody LoginInfo loginInfo) {
        String msg = valid.updateValid(loginInfo);
        int i = loginInfoManage.updateLoginInfo(loginInfo);
        return new ResponseEntity<ResponseModel>(successModelMsg("修改成功，数量：" + i), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByLoginName(@ApiParam(value = "loginName") @RequestParam(value = "loginName", required = false) String loginName) {
        Login byLoginName = loginInfoManage.getByLoginName(loginName);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byLoginName), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByUserCode(@ApiParam(value = "userCode") @RequestParam(value = "userCode", required = false) String userCode) {
        Login byUserCode = loginInfoManage.getByUserCode(userCode);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byUserCode), HttpStatus.OK);
    }


}
