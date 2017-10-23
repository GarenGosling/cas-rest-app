package org.garen.cas.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.cas.service.AppManage;
import org.garen.cas.swagger.api.valid.AppValid;
import org.garen.cas.swagger.model.App;
import org.garen.cas.swagger.model.BaseModel;
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

import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class AppApiController extends BaseModel implements AppApi {
    @Autowired
    AppValid valid;
    @Autowired
    AppManage appManage;

    public ResponseEntity<ResponseModel> deleteApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = appManage.removeById(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getApp(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        org.garen.cas.mybatis.domain.App app = appManage.findById(id);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", app ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getAppsAll() {
        List<org.garen.cas.mybatis.domain.App> all =appManage.findAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getAppsByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "应用编码") @RequestParam(value = "appCode", required = false) String appCode,
        @ApiParam(value = "应用名称") @RequestParam(value = "appName", required = false) String appName,
        @ApiParam(value = "上架 0 下架 1") @RequestParam(value = "permission", required = false) Boolean permission) {
        Map page = appManage.getByPage(start, length, appCode, appName, permission);
        return new ResponseEntity<ResponseModel>(successModel("分页查询", page), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveApp(@ApiParam(value = "应用"  ) @RequestBody App app) {
        String msg = valid.saveValid(app);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = appManage.saveApp(app);
        return new ResponseEntity<ResponseModel>(successModelMsg("新增成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateApp(@ApiParam(value = "应用"  ) @RequestBody App app) {
        String msg = valid.updateValid(app);
        int i = appManage.updateApp(app);
        return new ResponseEntity<ResponseModel>(successModelMsg("修改成功，数量：" + i), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getAppByCode(@ApiParam(value = "appCode") @RequestParam(value = "appCode", required = false) String appCode) {
        org.garen.cas.mybatis.domain.App byAppCode = appManage.getByAppCode(appCode);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byAppCode), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getAppByName(@ApiParam(value = "appName") @RequestParam(value = "appName", required = false) String appName) {
        org.garen.cas.mybatis.domain.App byAppName = appManage.getByAppName(appName);
        return new ResponseEntity<ResponseModel>(successModel("查询成功", byAppName), HttpStatus.OK);
    }

}
