$(document).ready(function () {


    //登录
    $("#login_button").click(function () {
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
                }
            },
            error : function() {
                alert("异常！");
            }
        });
    })




})