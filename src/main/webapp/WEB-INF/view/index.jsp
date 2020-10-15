<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <jsp:include page="commonCSS.jsp"/>
    <style>
        body {
            padding-top: 30px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>
<body>

<div class="container">

    <form class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="username" naem="username" placeholder="请输入用户名" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入登录密码"
                   style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control" name="type">
                <option value="user" selected>用户</option>
                <option value="admin">管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label style="padding-left: 0px">
                <a href="javascript:void(0)" onclick="resetPWD()">忘记密码</a>
            </label>
            <label style="float:right">
                <a href="javascript:void(0)" id="register">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" id="login">登录</a>
    </form>
</div>


<jsp:include page="commonJS.jsp"/>
<script>
    /* 登录 */
    $("#login").click(function () {
        // 获取登录类型
        var loginType = $(":selected").val();
        var username = $("#username").val();
        var password = $("#password").val();
        if (username.trim().length == 0 || password.trim().length == 0) {
            layer.msg("用户名或者密码不能为空！！！", {time: 1000, icon: 5, shift: 6});
            return;
        }
        var userData = {
            loginType: loginType,
            username: username,
            password: password
        }
        $.ajax({
            type: "post",
            url: "${APP_PATH}/login",
            contentType: "application/json;character=utf-8",
            data: JSON.stringify(userData),
            beforeSend: function () {
                layer.msg('处理中', {icon: 16});
            },
            success: function (result) {
                console.log(result)
                if (result === "user") {
                    window.location.href = "mainPage";
                } else if (result === "admin") {
                    window.location.href = "manage/adminPage";
                } else {
                    layer.msg("用户名或者密码错误！！！", {time: 1000, icon: 2, shift: 6});
                }
            }
        })
    });

    /* 重置密码 */
    function resetPWD(){
        window.location.href = "resetPWDPage";
    }

    $("#register").click(function () {
        window.location.href = "registerPage";
    });
</script>
</body>
</html>
