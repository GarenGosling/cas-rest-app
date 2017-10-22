package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.UserAppManage;
import org.garen.cas.service.UserBaseManage;
import org.garen.cas.swagger.api.valid.UserAppValid;
import org.garen.cas.swagger.api.valid.UserBaseValid;
import org.garen.cas.swagger.model.BaseModel;
import org.garen.cas.swagger.model.ResponseModel;
import org.garen.cas.swagger.model.UserApp;
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

import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class UserAppApiController extends BaseModel implements UserAppApi {

    @Autowired
    UserAppValid valid;
    @Autowired
    UserAppManage userAppManage;

    public ResponseEntity<ResponseModel> deleteUserApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = userAppManage.removeById(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = userAppManage.findById(id);
        return new ResponseEntity<ResponseModel>(successModel("查询成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserAppAll() {
        List<org.garen.cas.mybatis.domain.UserApp> all =userAppManage.findAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getUserAppsByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode,
        @ApiParam(value = "应用编码") @RequestParam(value = "appCode", required = false) String appCode,
        @ApiParam(value = "上架 0 下架 1") @RequestParam(value = "permission", required = false) Boolean permission) {
        Map page = userAppManage.getByPage(start, length, userCode, appCode, permission);
        return new ResponseEntity<ResponseModel>(successModel("分页查询", page), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveUserApp(@ApiParam(value = "用户应用关系"  ) @RequestBody UserApp userApp) {
        String msg = valid.saveValid(userApp);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = userAppManage.saveApp(userApp);
        return new ResponseEntity<ResponseModel>(successModelMsg("新增成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateUserApp(@ApiParam(value = "用户应用关系"  ) @RequestBody UserApp userApp) {
        String msg = valid.updateValid(userApp);
        int i = userAppManage.updateApp(userApp);
        return new ResponseEntity<ResponseModel>(successModelMsg("修改成功，数量：" + i), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getUserAppByCode(@ApiParam(value = "userCode") @RequestParam(value = "userCode", required = false) String userCode,
                                                          @ApiParam(value = "appCode") @RequestParam(value = "appCode", required = false) String appCode) {
        org.garen.cas.mybatis.domain.UserApp byCode = userAppManage.getByCode(userCode, appCode);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byCode), HttpStatus.OK);
    }

}
