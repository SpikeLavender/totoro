<%--
  Created by IntelliJ IDEA.
  User: cmcc
  Date: 2020-01-18
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>ISpringMVC测试页</title>
    <style>
        div {
            padding: 10px;
        }

        .loader {
            padding: 10px;
            margin: 100px auto;
            width: 500px;

        }

        .loader h4{
            text-align: center;
        }

        .text-input {
            display: block;
            margin: 10px auto;
            width: 400px;
        }

        .text-input i {
            display: inline-block;
            width: 70px;
        }

        .text-input input {
            display: inline-block;
            width: 400px;
            height: 35px;
            padding: 10px;
            margin: 10px auto;
            text-align: center;
        }

        .submit-input input {
            display: inline-block;
            width: 100px;
            height: 35px;
            margin: 0 150px;
        }

    </style>

    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>

</head>
<body>
<div>
    <%--    <h2>multipart 文件上传</h2>--%>
    <fieldset class="loader">
        <form class="text-input" method="post" action="/demo/load">
            <h4>登录</h4>
            <input type="text" name="username" placeholder="用户名"/>
            <input type="text" name="password" placeholder="密码"/>
            <input type="submit" value="登录" />
        </form>

    </fieldset>

</div>
</body>
</html>



<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: cmcc--%>
<%--  Date: 2020-01-18--%>
<%--  Time: 23:41--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>ISpringMVC测试页</title>--%>
<%--    <style>--%>
<%--        div {--%>
<%--            padding: 10px;--%>
<%--        }--%>

<%--        .loader {--%>
<%--            padding: 10px;--%>
<%--            margin: 100px auto;--%>
<%--            width: 500px;--%>

<%--        }--%>

<%--        .loader h4{--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .text-input, .submit-input {--%>
<%--            display: block;--%>
<%--            margin: 10px auto;--%>
<%--            width: 400px;--%>
<%--        }--%>

<%--        .text-input i {--%>
<%--            display: inline-block;--%>
<%--            width: 70px;--%>
<%--        }--%>

<%--        .text-input input {--%>
<%--            display: inline-block;--%>
<%--            width: 320px;--%>
<%--            height: 35px;--%>
<%--        }--%>

<%--        .submit-input input {--%>
<%--            display: inline-block;--%>
<%--            width: 100px;--%>
<%--            height: 35px;--%>
<%--            margin: 0 150px;--%>
<%--        }--%>

<%--    </style>--%>

<%--    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>--%>

<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
<%--    &lt;%&ndash;    <h2>multipart 文件上传</h2>&ndash;%&gt;--%>
<%--    <fieldset class="loader">--%>
<%--        <h4>登录</h4>--%>
<%--        <form method="post" action="/demo/handle/">--%>
<%--            <div class="text-input"><i>用户名:</i><input type="text" name="username"/></div>--%>
<%--            <div class="text-input"><i>密码:  </i><input type="text" name="password"/></div>--%>
<%--            <div class="submit-input"><input id="ajaxBtn" type="button" value="登录" /></div>--%>
<%--        </form>--%>
<%--    </fieldset>--%>

<%--        <script>--%>
<%--            $(function () {--%>
<%--                $("#ajaxBtn").bind("click", function () {--%>
<%--                    $.ajax({--%>
<%--                        url: '/demo/resume',--%>
<%--                        type: 'GET',--%>
<%--                        contentType: 'application/json; charset=utf-8',--%>
<%--                        dataType: 'json',--%>
<%--                        success: function (data) {--%>
<%--                            alert(data.name);--%>
<%--                        }--%>
<%--                    })--%>
<%--                })--%>
<%--            })--%>
<%--        </script>--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
