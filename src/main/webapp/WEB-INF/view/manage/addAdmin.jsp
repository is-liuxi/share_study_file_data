<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员添加</title>
    <jsp:include page="./../commonCSS.jsp"/>
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
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 添加管理员</h2>

        <div class="form-group">
            <label for="name">name</label>
            <input type="username" name="name" class="form-control" id="name" placeholder="name">
        </div>
        <div class="form-group">
            <label for="pwd">pwd</label>
            <input type="password" name="pwd" class="form-control" id="pwd" placeholder="pwd">
        </div>
        <button type="button" class="btn btn-success" onclick="addUser()"><i class="glyphicon glyphicon-plus"></i> 新增</button>
        <button type="reset" class="btn btn-danger" style="margin-left: 20px"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
    </form>
</div>

<jsp:include page="./../commonJS.jsp"/>

<script>
    /* 添加用户，邮箱使用正则验证 */
    function addUser(){
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        if (name.trim().length == 0 || pwd.trim().length == 0){
            layer.msg("用户名或者密码不能为空！！！", {time:1000, icon:5, shift:6});
            return;
        }
        var userDetails = {
            name: name,
            pwd: pwd
        };

        /* 添加用户 */
        $.ajax({
            type: "post",
            url: "${APP_PATH}/addAdmin",
            contentType: "application/json;character=utf-8",
            data: JSON.stringify(userDetails),
            beforeSend : function() {
                layer.msg('处理中', {icon : 16});
            },
            success: function (result) {
                console.log(result)
                if (result === "success"){
                    layer.msg("添加成功！", {time:1000, icon:1, shift:5});
                }else{
                    layer.msg("服务器内部错误", {time:1000, icon:0, shift:6});
                }
            }
        })
    }

</script>
</body>
</html>

