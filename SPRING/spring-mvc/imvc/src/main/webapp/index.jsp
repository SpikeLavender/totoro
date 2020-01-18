<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>ISpringMVC测试页</title>
    <style>
        div {
            padding: 10px 10px 10px 10px;
        }
        a {
            display: block;
            padding: 10px 10px 10px 10px;
        }
        fieldset {
            padding: 10px 10px 10px 10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h2>权限测试</h2>
<div>
<%--    <h2>multipart 文件上传</h2>--%>
    <h3>类权限："hetengjiao", "lagou"</h3>

    <fieldset>
        <%--
            1 method="post"
            2 enctype="multipart/form-data"
            3 type="file"
        --%>
            <h4>handle01权限：</h4>
            <a href="/demo/handle01?username=hetengjiao">handle01测试：hetengjiao</a>
            <a href="/demo/handle01?username=lagou">handle01测试：lagou</a>
            <a href="/demo/handle01?username=zhangsan">handle01测试: zhangsan</a>
    </fieldset>

    <fieldset>
        <%--
            1 method="post"
            2 enctype="multipart/form-data"
            3 type="file"
        --%>
            <h4>handle02权限："zhangsan", "lisi"</h4>
        <a href="/demo/handle02?username=hetengjiao">handle02测试：hetengjiao</a>
        <a href="/demo/handle02?username=zhangsan">handle02测试：zhangsan</a>
        <a href="/demo/handle02?username=lisi">handle02测试: lisi</a>
        <a href="/demo/handle02?username=wangwu">handle02测试: wangwu</a>
    </fieldset>

    <fieldset>
        <%--
            1 method="post"
            2 enctype="multipart/form-data"
            3 type="file"
        --%>
            <h4>handle03权限："wangwu", "zhaoliu"</h4>
            <a href="/demo/handle03?username=hetengjiao">handle03测试：hetengjiao</a>
            <a href="/demo/handle03?username=wangwu">handle03测试：wangwu</a>
            <a href="/demo/handle03?username=zhaoliu">handle03测试: zhaoliu</a>
            <a href="/demo/handle03?username=zhangsan">handle03测试: zhangsan</a>
    </fieldset>
</div>
</body>
</html>
