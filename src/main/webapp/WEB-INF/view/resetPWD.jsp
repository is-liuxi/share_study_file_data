<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
    <jsp:include page="commonCSS.jsp"/>
    <style>
        body {
            padding-top: 30px;
            padding-bottom: 40px;
            background-color: #eee;
        }
        form{
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container">
    <form>
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 找回密码</h2>

        <div class="form-group">
            <label for="username">Username</label>
            <input type="username" name="username" class="form-control" id="username" placeholder="Username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="Email" name="email" class="form-control" id="email" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="code">校验码 </label><a href="#" style="float: right" id="clickSendCode">点击获取验证码</a>
            <input type="text" name="code" class="form-control" id="code" placeholder="请输入收到的邮箱验证码">
        </div>
        <button type="button" class="btn btn-success" onclick="resetPWD()"><i class="glyphicon glyphicon-plus"></i> 重置密码</button>
        <button type="reset" class="btn btn-danger" style="margin-left: 20px"><i class="glyphicon glyphicon-refresh"></i> 返回首页</button>
    </form>
</div>

<jsp:include page="commonJS.jsp"/>
<script>
    function resetPWD(){
        var username = $("#username").val();
        var password = $("#password").val();
        var code = $("input[name='code']").val();
        var email = $("#email").val();
        if (username.trim().length == 0 || password.trim().length == 0){
            layer.msg("用户名或者密码不能为空！！！", {time:1000, icon:5, shift:6});
            return;
        }
        var checkEmail = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        if(!checkEmail.test(email)){
            layer.msg("请输入正确的邮箱地址！！！", {time:1000, icon:5, shift:6});
            return;
        }
        if (code.trim().length == 0){
            layer.msg("邮箱验证码不能为空！！！", {time:1000, icon:5, shift:6});
            return;
        }

    }

    $("#clickSendCode").click(function(){
        $.ajax({
            type: "get",
            url: "${APP_PATH}/code",
            success: function(result){
                $("input[name='code']").val(result)
            }
        })
    });
</script>
</body>
</html>
