<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>main</title>
    <jsp:include page="commonCSS.jsp"/>
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
            width: 100px;
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

        /* 高数二级菜单 */
        #highNumberLi {
            position: relative;
        }

        #internalHigh {
            position: absolute;
            background-color: #ccc;
            padding: 0px;
            display: none;
        }

        #internalHigh > li {
            list-style: none;
        }

        #internalHigh > li > a {
            text-decoration: none;
            display: inline-block;
            text-align: center;
            line-height: 50px;
            width: 100px;
            height: 50px;

        }

        #highNumberLi:hover #internalHigh {
            background-color: pink;
            color: #000;
            display: block;
        }

        #internalHigh a:hover {
            background-color: red;
            color: white;
        }

        /* 英语二级菜单 */
        #internalHigh {
            position: relative;
        }

        #internalEnglish {
            position: absolute;
            list-style: none;
            padding: 0px;
            background-color: #eee;
            width: 100px;
            height: 80px;
            display: none;
        }

        #englishLi:hover #internalEnglish {
            background-color: pink;
            display: block;
        }

        #internalEnglish > li {
            height: 40px;
            text-align: center;
            line-height: 40px;
        }

        #internalEnglish > li > a:hover {
            display: inline-block;
            width: 100px;
            background-color: red;
            color: white;
        }

        #internalEnglish a {
            text-decoration: none;
            color: #000;
        }

        /* 设置单元格 */
        #content td, th {
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
            <li id="highNumberLi">
                <a href="javascript:void(0)" onclick="highNumber()">高数</a>
                <ul id="internalHigh">
                    <li>
                        <a href="javascript:void(0)" onclick="queryHighNumber(1)">高数模块一</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="queryHighNumber(2)">高数模块二</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="queryHighNumber(3)">高数模块三</a>
                    </li>
                </ul>
            </li>
            <li id="englishLi">
                <a href="javascript:void(0)" onclick="englishAll()">英语</a>
                <ul id="internalEnglish">
                    <li>
                        <a href="javascript:void(0)" onclick="queryEnglishByModule(4)">英语模块一</a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="queryEnglishByModule(5)">英语模块二</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:void(0)" onclick="queryALLPolitics()">政治</a>
            </li>
            <li>
                <a href="javascript:void(0)" onclick="queryALLComputer()">计算机</a>
            </li>
            <li>
                <a href="javascript:void(0)" onclick="study()">在线学习</a>
            </li>
            <li>
                <a href="javascript:void(0)" onclick="daka(${user.id})">签到</a>
            </li>
            <li id="user" style="float: right">
                <%-- 查看是否已登录，没有登录提示 --%>
                <c:if test="${empty sessionScope.user}">
                    <button type="button" onclick="loginPage()" class="btn btn-danger" data-toggle="dropdown">
                        <h5 style="display: inline"><i class="glyphicon glyphicon-exclamation-sign"></i></h5> 未登录
                    </button>
                </c:if>
                <c:if test="${!empty sessionScope.user}">
                    <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-user"></i> ${user.username} <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#" onclick="userDetails(${user.id})"><i class="glyphicon glyphicon-cog"></i>
                            完善资料</a>
                        </li>
                        <li><a href="#" onclick="shareFile()"><i class="glyphicon glyphicon-folder-open"></i> 分享资料</a>
                        </li>
                        <li><a href="javascript:void(0)" onclick="logout()"><i class="glyphicon glyphicon-off"></i> 退出系统</a>
                        </li>
                    </ul>
                </c:if>
            </li>
        </ul>
    </div>
</nav>
<div class="container" id="content">
    <div id="highNumber">
    </div>
    <br>
    <div id="englishDetails">
    </div>
    <br>
    <div id="computerList">
    </div>
    <br>
    <div id="politicsList">
    </div>
</div>


<jsp:include page="./commonJS.jsp"/>
<script>
    /* 登录页面跳转 */
    function loginPage() {
        window.location.href = "${APP_PATH}/index"
    }

    /* 首页页面加载初始化数据 */
    $(function () {
        /* 首页：高数 */
        $.ajax({
            type: "get",
            url: "${APP_PATH}/highNumberList",
            success: function (result) {
                var highNumberList = result.highNumberList;
                // console.log(highNumberList);

                var tableTitle = '<h2>高数</h2><table class="table table-striped"><tr><th>分类</th><th>标题</th><th>操作</th></tr>';
                var tr = '';
                $.each(highNumberList, function (index, item) {
                    var td = '';
                    td += '<tr>';
                    td += '<td>' + item.name + '</td>'
                    td += '<td>' + item.highNumber[0].title + '</td>'
                    td += '<td><a href="javascript:void(0)" onclick="highNumberContentDetails(' + item.id + ')">详情</a></td>'
                    td += '</tr>'
                    tr += td;
                });
                tableTitle += tr + '</table>'
                $("#highNumber").append(tableTitle);
            }
        });

        /* 首页：英语 */
        $.ajax({
            type: "get",
            url: "${APP_PATH}/englishList",
            success: function (result) {
                var englishList = result.englishList;
                // console.log(englishList);

                var englishTableContent = '<h2>英语</h2><table class="table table-striped"><tr><th>分类</th><th>标题</th><th>操作</th></tr>';
                var tr = '';
                $.each(englishList, function (index, item) {
                    var td = '';
                    td += '<tr>';
                    td += '<td>' + item.name + '</td>';
                    td += '<td>' + item.english[0].title + '</td>';
                    td += '<td><a href="javascript:void(0)" onclick="englishContentDetails(' + item.id + ')">详情</a></td>';
                    td += '</tr>';
                    tr += td;
                });
                englishTableContent += tr + '</table>';
                $("#englishDetails").append(englishTableContent);
            }
        });

        /* 首页：计算机 */
        $.ajax({
            type: "get",
            url: "${APP_PATH}/computerList",
            success: function (result) {
                var computerList = result.computerList;
                // console.log(result)

                var tableTitle = '<h2>计算机</h2><table class="table table-striped"><tr><th>序号</th><th>标题</th><th>操作</th></tr>';
                var tr = '';
                $.each(computerList, function (index, item) {
                    var td = '';
                    td += '<tr>';
                    td += '<td>' + (index+1) + '</td>';
                    td += '<td>' + item.title + '</td>';
                    td += '<td><a href="javascript:void(0)" onclick="computerContentDetails(' + item.id + ')">详情</a></td>'
                    td += '</tr>';
                    tr += td;
                });
                tableTitle += tr + '</table>';
                $("#computerList").append(tableTitle);
            }
        })

        /* 首页：政治 */
        $.ajax({
            type: "get",
            url: "${APP_PATH}/politicsList",
            success: function (result) {
                var politicsList = result.politicsList;
                // console.log(result)

                var tableTitle = '<h2>政治</h2><table class="table table-striped"><tr><th>序号</th><th>标题</th><th>操作</th></tr>';
                var tr = '';
                $.each(politicsList, function (index, item) {
                    var td = '';
                    td += '<tr>';
                    td += '<td>' + (index+1) + '</td>';
                    td += '<td>' + item.title + '</td>';
                    td += '<td><a href="javascript:void(0)" onclick="politicsContentDetails(' + item.id + ')">详情</a></td>'
                    td += '</tr>';
                    tr += td;
                });
                tableTitle += tr + '</table>';
                $("#politicsList").append(tableTitle);
            }
        })

    });

    /* 进入首页界面 */
    function main() {
        window.location.href = "${APP_PATH}/mainPage"
    }

    /* 进入高数模块：查询的全部 */
    function highNumber() {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/highNumberLists",
            success: function (result) {
                var highNumberList = result.highNumberLists;
                /*console.log(highNumberList)*/

                // 标题
                var title = "全部高数资料展示";

                highNumbertableContentDetails(title, highNumberList);
            }
        });
    }

    /* 高数模块查询 */
    function queryHighNumber(item) {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryHighNumByGroupNum/" + item,
            success: function (result) {
                var highNumberList = result.queryHighNumByGroupNums;
                // console.log(highNumberList);

                var title = "";
                if (item === 1) {
                    title = "高数模块一资料展示";
                } else if (item === 2) {
                    title = "高数模块二资料展示";
                } else if (item === 3) {
                    title = "高数模块三资料展示";
                } else {
                    title = "";
                }

                highNumbertableContentDetails(title, highNumberList);
            }
        });
    }

    /* 高数页面中表格展示内容方法封装 */
    function highNumbertableContentDetails(title, itemList) {
        $("#content").html("");
        var tableTitle = '<h2>' + title + '</h2><table class="table table-striped"><tr><th>分类</th><th>标题</th><th>操作</th></tr>';
        var tr = '';
        $.each(itemList, function (index, item) {
            var td = '';
            td += '<tr>'
            td += '<td>' + item.name + '</td>'
            td += '<td>' + item.highNumber[0].title + '</td>'
            td += '<td><a href="javascript:void(0)" onclick="highNumberContentDetails(' + item.id + ')">详情</a></td>'
            td += '</tr>'
            tr += td;
        });
        tableTitle += tr + '</table>'
        $("#content").append(tableTitle);
    }

    /* 英语页面中表格展示内容方法封装 */
    function englishTableContentDetails(title, itemList) {
        $("#content").html("");
        var tableTitle = '<h2>' + title + '</h2><table class="table table-striped"><tr><th>分类</th><th>标题</th><th>操作</th></tr>';
        var tr = '';
        $.each(itemList, function (index, item) {
            var td = '';
            td += '<tr>'
            td += '<td>' + item.name + '</td>'
            td += '<td>' + item.english[0].title + '</td>'
            td += '<td><a href="javascript:void(0)" onclick="englishContentDetails(' + item.id + ')">详情</a></td>'
            td += '</tr>'
            tr += td;
        });
        tableTitle += tr + '</table>'
        $("#content").append(tableTitle);
    }

    /* 进入英语模块查询：英语全部数据 */
    function englishAll() {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/englishDetails",
            success: function (success) {
                var englishDetails = success.englishDetails;
                // console.log(englishDetails);

                var title = "<h1>全部英语资料展示</h1>";

                englishTableContentDetails(title, englishDetails);
            }
        });
    }

    /* 英语模块查询 */
    function queryEnglishByModule(item) {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryEnglishByGroupNum/" + item,
            success: function (result) {
                var englishList = result.eGroupList;
                /*console.log(highNumberList)*/
                var title = "";
                if (item === 4) {
                    title = "英语模块一资料展示";
                } else if (item === 5) {
                    title = "英语模块二资料展示";
                } else {
                    title = "";
                }
                englishTableContentDetails(title, englishList);
            }
        });
    }

    /* 点击二级菜单后隐藏 */
    $("#highNumberLi a").click(function(){
        $("#internalHigh").hide();
    });

    $("#highNumberLi").mouseover(function () {
        $("#internalHigh").show();
    });

    $("#highNumberLi").mouseout(function () {
        $("#internalHigh").hide();
    });

    $("#englishLi a").click(function(){
        $("#internalEnglish").hide();
    });

    $("#englishLi").mouseover(function () {
        $("#internalEnglish").show();
    });

    $("#englishLi").mouseout(function () {
        $("#internalEnglish").hide();
    });

    /* 政治查询 */
    function queryALLPolitics() {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryAllPolitics",
            success: function (result) {
                var politicsList = result.queryAllPolitics;
                /*console.log(highNumberList)*/
                $("#content").html("");
                var tableTitle = '<h2>政治资料展示</h2><table class="table table-striped"><tr><th>序号</th><th>标题</th><th>操作</th></tr>';
                var tr = '';
                $.each(politicsList, function (index, item) {
                    var td = '';
                    td += '<tr>'
                    td += '<td>' + (index+1) + '</td>'
                    td += '<td>' + item.title + '</td>'
                    td += '<td><a href="javascript:void(0)" onclick="politicsContentDetails(' + item.id + ')">详情</a></td>'
                    td += '</tr>'
                    tr += td;
                });
                tableTitle += tr + '</table>'
                $("#content").append(tableTitle);
            }
        });
    }

    /* 计算机科目查询 */
    function queryALLComputer() {
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryAllComputers",
            success: function (result) {
                var computerList = result.queryAllComputers;
                /*console.log(highNumberList)*/
                $("#content").html("");
                var tableTitle = '<h2>计算机资料展示</h2><table class="table table-striped"><tr><th>序号</th><th>标题</th><th>操作</th></tr>';
                var tr = '';
                $.each(computerList, function (index, item) {
                    var td = '';
                    td += '<tr>'
                    td += '<td>' + (index+1) + '</td>'
                    td += '<td>' + item.title + '</td>'
                    td += '<td><a href="javascript:void(0)" onclick="computerContentDetails(' + item.id + ')">详情</a></td>'
                    td += '</tr>'
                    tr += td;
                });
                tableTitle += tr + '</table>'
                $("#content").append(tableTitle);
            }
        });
    }

    /* 在线学习 */
    function study() {
        var user = "${sessionScope.user}";
        if (user.length === 0) {
            alert("请先登录！");
            return;
        }
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryAllStudys",
            success: function (result) {
                var data = result.studyList;
                // console.log(data)
                var content = '';
                $.each(data, function (index, item) {
                    content += '<div class="col-sm-6 col-md-4">';
                    content += '<div class="thumbnail">';
                    content += '<a href="' + item.url + '" target="_blank"><img src="${APP_PATH}' + item.imgPath + '" alt="图片不存在"></a>';
                    content += '<div class="caption">';
                    content += '<h3>' + item.title + '</h3>';
                    content += '<p>' + item.content + '</p>';
                    content += '</div>';
                    content += '</div>';
                    content += '</div>';

                    $('<div class="row"></div>').append(content);
                });

                $("#content").html(content)
            }
        });

    }

    /* 未登录不能进入打卡 */
    function daka(userid) {
        if (typeof (userid) == "undefined") {
            /* 有 bug，在首页点击没有显示
            layer.msg("", {time:1000, icon:2, shift:6}); */
            alert("请先登录");
            return;
        }
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryDakaDetails/" + userid,
            success: function (result) {
                // console.log(result)
                var daka_date = timestampToTime(result.dakaDetails.daka_date);
                $("#content").html("");
                $("#content").append("<div style='width: 550px;margin: 70px auto'><h1 style='color: green;'>签到成功，累计打卡 " + result.dakaiTotal + "次</h1><h3>" + daka_date + "</h3></div>");
            }
        })
    }

    /* 完善用户信息 */
    function userDetails(item) {
        window.location.href = "${APP_PATH}/updateUserPage/" + item;
    }

    /* 退出登录 */
    function logout() {
        window.location.href = "${APP_PATH}/logout"
    }

    /* 分享文件 */
    function shareFile() {
        window.location.href = "${APP_PATH}/shareFile"
    }

    /* 高数详情展示 */
    function highNumberContentDetails(id) {
        var user = "${sessionScope.user}";
        if (user.length === 0) {
            alert("请先登录！");
            return;
        }
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryHighNumberById/" + id,
            success: function (result) {
                var data = result.highNumber;
                // console.log(data);

                showContentDetails(data);
            }
        })
    }

    /* 查看详情封装 */
    function showContentDetails(data){
        $("#content").html("");
        var tableContent = "";
        tableContent += '<h2>文件详情查看</h2><table class="table table-striped"><tr><td>标题</td>';
        tableContent += '<td>'+data.title+'</td></tr>';
        tableContent += '<tr><td>点击查看</td>';
        tableContent += '<td><a href="${APP_PATH}/'+data.filePath+'" target="_blank">'+data.name+'</a></td></tr>';
        tableContent += '<tr><td>内容</td>';
        tableContent += '<td>'+data.content+'</td></tr>';
        tableContent += '<tr><td>发布时间</td>';
        tableContent += '<td>'+timestampToTime(data.createDate)+'</td></tr>';
        tableContent += '</table>';
        $("#content").append(tableContent);
    }

    /* 英语详情展示 */
    function englishContentDetails(id) {
        var user = "${sessionScope.user}";
        if (user.length === 0) {
            alert("请先登录！");
            return;
        }
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryEnglishById/" + id,
            success: function (result) {
                var data = result.english;
                console.log(data);

                showContentDetails(data);
            }
        })
    }

    /* 计算机详情展示 */
    function computerContentDetails(id) {
        var user = "${sessionScope.user}";
        if (user.length === 0) {
            alert("请先登录！");
            return;
        }
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryComputerById/" + id,
            success: function (result) {
                var data = result.computer;
                // console.log(data);

                showContentDetails(data);
            }
        })
    }

    /* 政治详情展示 */
    function politicsContentDetails(id) {
        var user = "${sessionScope.user}";
        if (user.length === 0) {
            alert("请先登录！");
            return;
        }
        $.ajax({
            type: "get",
            url: "${APP_PATH}/queryPoliticsById/" + id,
            success: function (result) {
                var data = result.politics;
                // console.log(data)

                showContentDetails(data);
            }
        })
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
</body>
</html>
