$(document).ready(function () {





    //登录
    $("#login_button").click(function () {
        login()
    })


    //监听回车事件登录
    document.onkeydown = function () {
        var oEvent = window.event;
        if (oEvent.keyCode == 13) {
            login()
        }
    }

})


//登录
function login() {
    var formObject = $('#userForm').serializeJSON();
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        contentType : 'application/json;charset=utf-8',
        dataType: "json",//预期服务器返回的数据类型
        url: "user/login" ,//url
        data: JSON.stringify(formObject),
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            if (result.resultCode=="4002"){
                window.location.href=result.successUrl;
            }else if (result.resultCode == "4004"){
                alert("账号或者密码错误!")
            }
        },
        error : function() {
            alert("账号或者密码错误!")
        }
    });
}



