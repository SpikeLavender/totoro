<%--
  Created by IntelliJ IDEA.
  User: cmcc
  Date: 2020-01-18
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>resume</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<%--    <link rel="stylesheet" href="/css/handsontable.min.css">--%>

    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<%--    <script type="text/javascript" src="/js/handsontable.min.js"></script>--%>

    <style>
        #resume-table {
            width: 1800px;
            height: 1000px;
        }

        tr {
            display: block;
        }

        td {
            display: inline-block;
            width: 200px;
        }
    </style>
</head>
<body>
<div>
    <input type="button" value="新增" onclick="addResume()">
    <el-input v-model="input" placeholder="请输入内容"></el-input>
    <table id="resume-table" class="table table-bordered">

    </table>

</div>

<script>
    $(function () {
        //刷新页面
        refresh();
    });
    
    function addResume() {
        $.ajax({
            url: '/demo/resume?token=' + ${token},
            type: 'POST',
            data: '{"name": "test", "address": "西安", "phone": "17600022000"}',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function () {
                // $('#resume-' + id).attr("display", "none");
                refresh();
            }
        })
    }
    
    function deleteResume(id) {
        $.ajax({
            url: '/demo/resume/' + id + '?token=' + ${token},
            type: 'DELETE',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function () {
                // $('#resume-' + id).attr("display", "none");
                refresh();
            }
        })
    }

    function updateResume(id) {
        $.ajax({
            url: '/demo/resume/' + id + '?token=' + ${token},
            type: 'PUT',
            data: '{"name": "testUpdate", "address": "西安", "phone": "17600022002"}',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function () {
                refresh();
            }
        })
    }

    function refresh() {
        $.ajax({
            url: '/demo/resume?token=' + ${token},
            type: 'GET',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                var str = '';
                for (var i = 0; i < data.length; i++) {
                    str += '<tr id="resume-'+ data[i].id + '">';
                    str += '<td>' + data[i].id + '</td>';
                    str += '<td>' + data[i].name + '</td>';
                    str += '<td>' + data[i].address + '</td>';
                    str += '<td>' + data[i].phone + '</td>';
                    str += '<td><input type="button" value="编辑" onclick="updateResume('+ data[i].id +')"></td>';
                    str += '<td><input type="button" value="删除" onclick="deleteResume('+ data[i].id +')"></td>';
                    str += '</tr>';
                }
                $('#resume-table').html(str);
            }
        })
    }
    
</script>
</body>
</html>
