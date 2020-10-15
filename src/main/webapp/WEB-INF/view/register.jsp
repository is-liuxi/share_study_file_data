<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
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
            <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户注册</h2>

            <div class="form-group">
                <label for="username">Username</label>
                <input type="username" name="username" class="form-control" id="username" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Password">
            </div>
            <%--<div class="form-group">
                <label for="mobile">Phone Number</label>
                <input type="number" name="mobile" class="form-control" id="mobile" placeholder="Mobile">
            </div>--%>
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="Email" name="email" class="form-control" id="email" placeholder="Email">
            </div>
            <%--<div class="form-group">
                <label for="Email">Gender</label>
                <select class="form-control" name="gender">
                    <option value="boy">男</option>
                    <option value="girl">女</option>
                </select>
            </div>--%>
            <button type="button" class="btn btn-success" onclick="addUser()"><i class="glyphicon glyphicon-plus"></i> 新增</button>
            <button type="reset" class="btn btn-danger" style="margin-left: 20px"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
        </form>
    </div>

    <jsp:include page="commonJS.jsp"/>

    <script>
        /* 添加用户，邮箱使用正则验证 */
        function addUser(){
            var username = $("#username").val();
            var password = $("#password").val();
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

            var userDetails = {
                username: username,
                password: password,
                email: email
            };

            /* 添加用户 */
            $.ajax({
                type: "post",
                url: "${APP_PATH}/addUser",
                contentType: "application/json;character=utf-8",
                data: JSON.stringify(userDetails),
                beforeSend : function() {
                    layer.msg('处理中', {icon : 16});
                },
                success: function (result) {
                    console.log(result)
                    if (result.data == "success"){
                        console.log("success")
                        window.location.href = "queryUserById/" + result.userId;
                    }else{
                        layer.msg("服务器内部错误", {time:1000, icon:0, shift:6});
                    }
                }
            })

        }

    </script>
</body>
</html>
