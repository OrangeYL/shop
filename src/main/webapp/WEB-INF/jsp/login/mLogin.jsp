<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>商城后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/ml/css/style.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/pintuer.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/admin.css">
    <script src="${ctx}/static/js/jquery.js"></script>
    <script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body >
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height: 150px;"></div>
            <div class="media media-y margin-big-bottom"></div>
            <form action="${ctx}/login/toLogin" method="post">
                <div class="panel login-box">
                    <div class="text-center margin-big padding-big-top"><h1>管理员登录</h1></div>
                    <div class="panel-body" style="padding: 30px;padding-bottom: 10px; padding-top: 10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="userName" placeholder="登录账号" data-validate="required:请填写账号" />
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" name="password"  placeholder="登录密码" data-validate="required:请填写密码" />
                                <span class="icon icon-key margin-small"></span>
                            </div>
                        </div>
                    </div>
                    <div style="padding: 30px;">
                        <input type="submit" class="button button-block bg-main text-big input-big" value="登录" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
