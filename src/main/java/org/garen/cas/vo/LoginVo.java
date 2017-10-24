package org.garen.cas.vo;

import org.garen.cas.mybatis.domain.App;
import org.garen.cas.mybatis.domain.Login;
import org.garen.cas.mybatis.domain.UserBase;

import java.util.List;

public class LoginVo {
    private Login loginInfo;
    private UserBase userBase;
    private List<App> apps;

    public LoginVo() {
    }

    public LoginVo(Login loginInfo, UserBase userBase, List<App> apps) {
        this.loginInfo = loginInfo;
        this.userBase = userBase;
        this.apps = apps;
    }

    public Login getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(Login loginInfo) {
        this.loginInfo = loginInfo;
    }

    public UserBase getUserBase() {
        return userBase;
    }

    public void setUserBase(UserBase userBase) {
        this.userBase = userBase;
    }

    public List<App> getApps() {
        return apps;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
    }
}
