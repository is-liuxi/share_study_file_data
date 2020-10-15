<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="commonCSS.jsp"/>
    <title>用户信息修改</title>
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
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户信息</h2>

        <div class="form-group">
            <label for="username">Username</label>
            <input type="username" name="username" class="form-control" id="username" value="${user.username}" readonly>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" value="${user.password}" readonly>
        </div>
        <div class="form-group">
            <label for="mobile">Phone Number</label>
            <input type="number" name="mobile" class="form-control" id="mobile" value="${user.mobile}" placeholder="Mobile">
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="Email" name="email" class="form-control" id="email" value="${user.email}" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="Email">Gender</label>
            <select class="form-control" name="gender">
                <option value="boy">男</option>
                <option value="girl">女</option>
            </select>
        </div>
        <button type="button" class="btn btn-success" onclick="updateUserDetails()"><i class="glyphicon glyphicon-plus"></i> 确定</button>
        <button type="reset" class="btn btn-danger" style="margin-left: 20px"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
    </form>
</div>

<jsp:include page="commonJS.jsp"/>

<script>

    /* 添加用户，邮箱使用正则验证 */
    function updateUserDetails(){
        var mobile = $("#mobile").val();
        var gender = $(":selected").val();
        var email = $("#email").val();

        // 正则验证手机号
        var ab = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (ab.test(mobile) == false) {
            layer.alert("请正确填写手机号码!", { icon: 5, offset: '200px' });
            return false;
        }
        var checkEmail = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        if(!checkEmail.test(email)){
            layer.msg("请输入正确的邮箱地址！！！", {time:1000, icon:5, shift:6});
            return;
        }

        var userDetails = {
            id: ${user.id},
            mobile: mobile,
            gender: gender,
            email: email
        };

        /* 添加用户 */
        $.ajax({
            type: "post",
            url: "${APP_PATH}/updateUserDetails",
            contentType: "application/json;character=utf-8",
            data: JSON.stringify(userDetails),
            beforeSend : function() {
                layer.msg('处理中', {icon : 16});
            },
            success: function (result) {
                console.log(result)
                if (result == "success"){
                    window.location.href = "${APP_PATH}/queryUserById/" + ${user.id};
                }else{
                    layer.msg("服务器内部错误", {time:1000, icon:0, shift:6});
                }
            }
        })

    }
</script>
</body>
</html>
