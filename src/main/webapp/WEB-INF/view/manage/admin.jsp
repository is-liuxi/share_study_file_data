<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员界面</title>
    <jsp:include page="./../commonCSS.jsp"/>
    <meta charset="UTF-8">
    <style>
        body {
            padding-top: 70px;
        }

        nav {
            height: 70px;
        }

        #navLi {
            background-color: #eee;
            height: 70px;
            padding-left: 0px;
        }

        #navLi > li {
            list-style: none;
            float: left;
        }

        #navLi > li > a {
            text-decoration: none;
            color: black;
            display: inline-block;
            height: 70px;
            line-height: 70px;
            width: 140px;
            text-align: center;
            font-size: 18px;
        }

        #navLi > li > a:hover {
            background-color: pink;
        }

        /* 用户操作 */
        #user {
            position: relative;
        }

        #user > button {
            width: 100px;
            height: 70px;
            padding: 0;
        }

        #user > ul {
            margin: 0;
            padding: 0px;
            display: none;
            background-color: #0f0;
            left: -58px;
        }

        #user > ul {
            margin: 0;
            padding: 0px;
            display: none;
            background-color: #0f0;
            left: -58px;
        }

        #user:hover ul {
            background-color: #ccc;
            display: inline-block;
        }

        #tableContent td {
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #eee;">
    <div class="container">
        <ul id="navLi">
            <li>
                <a href="javascript:void(0)" onclick="main()">首页</a>
            </li>
            <li>
                <a href="javascript:void(0)" onclick="checkUpload()">文件上传审批</a>
            </li>
            <li id="user" style="float: right">
                <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i> ${admin.name} <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#" onclick="addAdmin()"><i class="glyphicon glyphicon-cog"></i> 添加管理员</a>
                    </li>
                    <li><a href="javascript:void(0)" onclick="logout()"><i class="glyphicon glyphicon-off"></i> 退出系统</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <table class="container table table-striped" id="tableContent">
        <caption><h2>所有用户展示</h2></caption>
        <thead id="theadContent">
        <tr>
            <th>用户 ID</th>
            <th>账号</th>
            <th>手机号</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>注册时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="userDetails">
            <tr>
                <td>${userDetails.id}</td>
                <td>${userDetails.username}</td>
                <td>${userDetails.mobile == null ? "用户信息未完善" : userDetails.mobile}</td>
                <td>${userDetails.gender == null ? "用户信息未完善" : userDetails.gender}</td>
                <td>${userDetails.email}</td>
                <td>${userDetails.createDate.toLocaleString()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="./../commonJS.jsp"/>
<script>
    /* 退出登录 */
    function logout() {
        window.location.href = "${APP_PATH}/logout"
    }

    /* 首页 */
    function main() {
        window.location.href = "${APP_PATH}/manage/adminPage"
    }

    function checkUpload() {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/groupDetailsUnCheckFiles",
            success: function (success) {
                var data = success.groupDetailsUnCheckFiles;
                // console.log(data);

                $("#tableContent").html("");
                var tableContent = "";
                tableContent += '<caption><h2>文件审核：共 ' + success.total + ' 条</h2></caption>';
                tableContent += '<thead><tr>';
                tableContent += '<th>标题</th>';
                tableContent += '<th>内容</th>';
                tableContent += '<th>文件存放路径</th>';
                tableContent += '<th>上传时间</th>';
                tableContent += '<th>操作</th>';
                tableContent += '</tr></thead>';

                $("#tableContent").append(tableContent);

                var tbodyContent = "";
                tbodyContent += '<tbody><tr>'
                $.each(data, function (index, item) {
                    // console.log(index, item);
                    tbodyContent += '<tr><td>' + item.title + '</td>';
                    tbodyContent += '<td>' + item.content + '</td>';
                    tbodyContent += '<td>' + (item.filePath == null ? "无" : item.filePath) + '</td>';
                    tbodyContent += '<td>' + timestampToTime(item.createDate) + '</td>';
                    tbodyContent += '<td><button type="button" class="btn btn-success" onclick="checkSuccess(' + item.id + ',' + item.groupId + ')"><i class="glyphicon glyphicon-plus"></i> 通过</button><button type="button" onclick="deleteFile(' + item.id + ',' + item.groupId + ')" class="btn btn-danger" style="margin-left: 20px"><i class="glyphicon glyphicon-refresh"></i> 删除</button></td><tr/>'

                });

                tbodyContent += '</tr></tbody>'

                $("#tableContent").append(tbodyContent)
            }
        });
    }

    /* 审核功能 */
    function checkSuccess(fileId, groupId) {
        /* 高数 */
        if (1 <= groupId && groupId <= 3) {
            AJAXFunction("updateHighNumberStatus", fileId)
        }

        /* 英语 */
        if (groupId == 4 || groupId == 5) {
            AJAXFunction("updateEnglishStatus", fileId)
        }

        /* 政治 */
        if (groupId == 6) {
            AJAXFunction("updatePoliticsStatus", fileId)
        }

        /* 计算机 */
        if (groupId == 7) {
            AJAXFunction("updateComputerStatus", fileId)
        }
    }

    /* 删除审核 */
    function deleteFile(fileId, groupId){
        // console.log(fileId, groupId);
        /* 高数 */
        if (1 < groupId && groupId <= 3) {
            deleteAJAXFunction("deleteHighNumberStatus", fileId)
        }

        /* 英语 */
        if (groupId == 4 || groupId == 5) {
            deleteAJAXFunction("deleteEnglishById", fileId)
        }

        /* 政治 */
        if (groupId == 6) {
            deleteAJAXFunction("deletePoliticsById", fileId)
        }

        /* 计算机 */
        if (groupId == 7) {
            deleteAJAXFunction("deleteComputerById", fileId)
        }
    }

    /* 审核，get请求 ajax封装 */
    function AJAXFunction(uri, fileId) {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/" + uri + "/" + fileId,
            success: function (success) {
                if (success === "success") {
                    checkUpload();
                } else {
                    layer.msg("服务器内部错误", {time: 1000, icon: 0, shift: 6});
                }
            }
        })
    }

    /* 删除，delete请求 ajax封装 */
    function deleteAJAXFunction(uri, fileId) {
        $.ajax({
            type: "delete",
            url: "${APP_PATH}/" + uri + "/" + fileId,
            success: function (success) {
                if (success === "success") {
                    checkUpload();
                } else {
                    layer.msg("服务器内部错误", {time: 1000, icon: 0, shift: 6});
                }
            }
        })
    }

    /* 添加管理员 */
    function addAdmin(){
        window.location.href = "${APP_PATH}/manage/addAdminPage";
    }

    /* 将时间戳转换为本地时间 */
    function timestampToTime(timestamp) {
        //时间戳为10位需*1000，时间戳为13位的话不需乘1000
        var date = new Date(timestamp);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
        var h = (date.getHours() < 10 ? '0' + (date.getHours()) : date.getHours()) + ':';
        var m = (date.getMinutes() < 10 ? '0' + (date.getMinutes()) : date.getMinutes()) + ':';
        var s = (date.getSeconds() < 10 ? '0' + (date.getSeconds()) : date.getSeconds());
        return Y + M + D + h + m + s;
    }
</script>
