<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Login</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <style>
        #username-info {
            display: none;
            border: none;
        }

        label {
            display: block;
            margin-top: 3px;
        }
    </style>

    <script type="text/javascript">
        function onJson() {
            $.ajax(
                {
                    type: 'post',
                    url: '${pageContext.request.contextPath}/user/reqJson',
                    contentType: 'application/json;charset=utf-8',
                    data: '{"username":"132","userpassword":"123","usermessage":"aaa","sex":"男"}',
                    success: function (data) {
                        alert(data);
                    }
                }
            );
        }


        //请求key/values
        function onResponseJson() {
            $.ajax(
                {
                    type: 'post',
                    url: '${pageContext.request.contextPath}/user/responseJson',
                    // contentType: 'application/json;charset=utf-8',  不需要这个
                    data: 'username=aa&userpassword=123',
                    success: function (data) {
                        alert(data);
                    }
                }
            );
        }


    </script>


</head>

<body>
<input type="button" value="请求json返回json" onclick="onJson()">
<input type="button" value="请求key/value返回json" onclick="onResponseJson()">


<br/>
<br/>
<br/>
<br/>
<hr/>
<form action="${pageContext.request.contextPath}/user/insert" method="get">
    UserName:<input id="username" type="text" name="username"><input type="text" id="username-info"/> <br/>
    UserPassword:<input type="password" name="userpassword"><br/>
    UserMessage:<input type="text" name="usermessage"><br/>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>

<script>
    $("#username").blur(function () {
        var username = $("#username").val();

        var user = {
            username:username,
            userpassword:123
        }
        if (username != undefined && username.length > 0) {
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/user/checkUserName',
                contentType: 'application/json;charset=utf-8',
                data:JSON.stringify(user),
                success:function (data) {
                    // alert(data);
                    $("#username-info").css("display","block");
                    $("#username-info").val(data);

                }
            });
        }
        else {
            alert("username not null")
        }
    })
</script>

<hr/>

<form action="${pageContext.request.contextPath}/user/check" method="post">
    <input type="text" name="searchtext" value="${searchtext}">
    <input type="submit" value="check">
</form>
<table border="1">
    <c:forEach items  ="${users}" var="user">

        <tr>
            <td>${user.username}</td>
            <td>${user.userpassword}</td>
            <td>${user.usermessage}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
