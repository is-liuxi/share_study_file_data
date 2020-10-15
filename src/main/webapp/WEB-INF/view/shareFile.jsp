<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入 JSTL --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>资料分享</title>
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
    <form action="${APP_PATH}/shareFileUpload" method="post" enctype="multipart/form-data">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-file"></i> 文件分享</h2>
        <br>
        <div class="form-group">
            <label for="title">文件标题</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="File Title">
        </div>
        <div class="form-group">
            <label for="groupId">选择文件所属类型</label>
            <select class="form-control" name="groupId" id="groupId">
                <c:forEach items="${groupinfoList}" var="groupDetails">
                    <option value="${groupDetails.id}">${groupDetails.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="content">内容</label>
            <textarea class="form-control" name="content" id="content" rows="3" placeholder="请输入分享文件的内容"></textarea>
        </div>
        <div class="form-group">
            <label for="file">请选择文件</label>
            <input type="file" name="file" id="file">
        </div>
        <button type="button" class="btn btn-success" onclick="addShareFile()"><i class="glyphicon glyphicon-plus"></i> 分享</button>
        <button type="reset" class="btn btn-danger" style="margin-left: 20px"><i class="glyphicon glyphicon-refresh"></i> 取消</button>
    </form>
</div>

    <jsp:include page="commonJS.jsp"/>
</body>

    <script>
        <%-- ajax请求页面加载慢。使用 JSP注释，有 Java代码
        $(function(){
            $.ajax({
                type: "get",
                url: "${APP_PATH}/queryAllGroupDetaild",
                success: function(result){
                    console.log(result)
                    var data = result.groupinfoList;

                    var option = "";
                    $.each(data, function(index, item){
                        console.log(index, item)
                        option += "<option id='"+item.id+"'>"+item.name+"</option>"
                    })
                    $("#id").append(option);
                }
            })
        });--%>

        function addShareFile(){
            var groupId = $(":selected").val();
            var title = $("#title").val();
            var content = $("#content").val();
            var file = $("#file").val();
            if (title.trim().length == 0 || content.trim().length == 0){
                layer.msg("文本框中不能为空！！！", {time:1000, icon:5, shift:6});
                return;
            }
            if (file.trim().length == 0){
                layer.msg("请选择文件！！！", {time:1000, icon:5, shift:6});
                return;
            }
            $("form").submit();
            /* 使用 ajax文件上传
            var formData = new FormData();
            formData.append("groupId", groupId);
            formData.append("title", title);
            formData.append("content", content);
            formData.append("file", file); */

            <%--
            $.ajax({
                type:'POST',
                url:'${APP_PATH}/shareFileUpload/',
                dataType:'json',
                async: false,
                data: formData,
                // 使数据不做处理
                processData : false,
                // 不要设置Content-Type请求头
                contentType : false,
                success: function(data){
                    console.log(data);

                }
            });--%>
        }
    </script>
</html>
