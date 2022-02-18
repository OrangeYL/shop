<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/static/css/admin.css">
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">修改公告</span> </strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/news/exUpdate" method="post" class="form-x" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${obj.id}">
            <div class="form-group">
                <div class="label"><label>标题：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入标题" value="${obj.name}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>内容：</label></div>
                <div class="field">
                    <textarea type="text" name="content" class="input w100" data-validate="required:请输入标题">${obj.content}</textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>