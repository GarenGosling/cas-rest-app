function login() {
    if(!loginValid()){
        return false;
    }
    var params = {};
    params.loginName = $("#loginName").val();
    params.password = $("#password").val();
    $.ajax({
        url: 'http://'+ip_callback+':9090/login',
        type: 'POST',
        data: params,
        success: function (response) {
            console.log(response);
            if(response.code == 200){
                var ticket = response.data.ticket;
                window.location.href = "http://"+ip_callback+":8081?ticket="+ticket;
            }else{
                alert("用户名或密码不正确");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("fail");
        }
    });
}

function loginValid(){
    var loginName = $("#loginName").val();
    var password = $("#password").val();
    if(!loginName){
        alert("请输入登录名");
        return false;
    }
    if(!password){
        alert("请输入密码");
        return false;
    }
    return true;
}