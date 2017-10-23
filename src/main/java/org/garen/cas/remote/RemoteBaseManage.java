package org.garen.cas.remote;

import org.apache.shiro.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <B>文件名称：</B><BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>东方银谷 研发二部 CBG<BR>
 * <B>创建时间：</B>17/2/13<BR>
 *
 * @author 李云龙  liyunlong@yingu.com
 * @version 1.0
 **/

@Configuration
public class RemoteBaseManage {

    protected Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Value("${cas.host}")
    protected String CAS_HOST;
    @Value("${cas.appKey}")
    protected String CAS_APPKEY;
    @Value("${cas.appSecret}")
    protected String CAS_APPSECRET;
    @Value("${cas.rest}")
    protected String CAS_REST;
    @Value("${user.groupCode}")
    protected String GROUP_CODE;

    @Value("${service.host}")
    protected String SERVICE_HOST;

    protected String getCAS_REST_API(){
        return this.CAS_HOST + this.CAS_REST;
    }

    protected RestTemplateUtil restTemplate = new RestTemplateUtil();

    protected static String GET_ORG             = "/v1/hrAndOrg";
    protected static String GET_ORG_ONLY        = "/v1/orgTree";
    protected static String GET_ORG_BY_ID       = "/v1/orgTreeById";
    protected static String GET_SYNC_DATASOURCE = "/down/datasource";
    protected static String GET_HR_ORG_BY_ORGID = "/v1/hrAndOrgByOrgId";

    protected static String GET_TICKETS         = "/v1/tickets";

    protected Map<String,String> authorization(final String username, final String password){
        String base64Code 		    = "Basic " + Base64.encodeToString( (username + ":" + password).getBytes());
        Map<String,String> header   = new HashMap<String,String>();
        header.put("Authorization", base64Code);
        return header;
    }

}
