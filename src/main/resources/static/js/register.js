function register() {
    if(!registerValid()){
        return false;
    }
    var params = {};
    params.loginName = $("#loginName").val();
    params.password = $("#password").val();
    params.appCodes = getPermissionAppCodes();
    $.ajax({
        url: 'http://'+ip_callback+':9090/register',
        type: 'POST',
        data: params,
        success: function (response) {
            console.log(response);
            if(response.code == 200){
                var ticket = response.data.ticket;
                window.location.href = "http://"+ip_callback+":8081?ticket="+ticket;
            }else{
                alert("登录失败，测试用户名：garen 密码：Garen666");
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("fail");
        }
    });
}

function registerValid(){
    var loginName = $("#loginName").val();
    var password = $("#password").val();
    var rePassword = $("#rePassword").val();
    if(!loginName){
        alert("请输入登录名");
        return false;
    }
    if(!password){
        alert("请输入密码");
        return false;
    }
    if(!rePassword){
        alert("请再次输入密码");
        return false;
    }
    if(password != rePassword){
        alert("两次输入的密码不一致");
        return false;
    }
    var permissionApps = $("input[name='permissionApp']:checked");
    if(permissionApps.length == 0) {
      alert("需要至少一个授权应用");
      return false;
    }
    return true;
}

function getPermissionAppCodes(){
    var permissionApps = $("input[name='permissionApp']:checked");
    var permissionAppCodes = "";
    for(var i=0;i<permissionApps.length;i++){
        var permissionApp = permissionApps[i];
        var permissionAppCode = permissionApp.value;
        permissionAppCodes += permissionAppCode;
        if(i<permissionApps.length-1){
            permissionAppCodes += ",";
        }
    }
    return permissionAppCodes;
}