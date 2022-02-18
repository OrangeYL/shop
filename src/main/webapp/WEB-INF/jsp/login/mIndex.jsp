<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
  <title>管理员后台</title>
  <link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
  <link rel="stylesheet" href="${ctx}/static/css/admin.css">
  <script src="${ctx}/static/js/jquery.js"></script>
  <script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body style="background-color: #f2f9fd">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top" style="color: #0f0f0f">
    <h1>管理员后台</h1>
  </div>
  <div class="head-l">
    <a class="button button-little bg-green" href="${ctx}/login/uIndex" target="_blank">
      <span class="icon-home"></span>前台首页
    </a>
    <a class="button button-little bg-red" href="${ctx}/login/mLogout">
      <span class="icon-power-off"></span>退出登录
    </a>
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list" style="color: #0f0f0f">菜单列表</span> </strong></div>
  <h2><span class="icon-user"></span>基本设置 </h2>
  <ul style="display: block">
    <li><a href="${ctx}/itemCategory/queryItemCategoryPage" target="right"><span class="icon-caret-right"></span>类目管理</a> </li>
    <li><a href="${ctx}/user/queryUserPage" target="right"><span class="icon-caret-right"></span>用户管理</a> </li>
    <li><a href="${ctx}/item/queryItemPage" target="right"><span class="icon-caret-right"></span>商品管理</a> </li>
    <li><a href="${ctx}/itemOrder/queryItemOrderPage" target="right"><span class="icon-caret-right"></span>订单管理</a> </li>
    <li><a href="${ctx}/news/queryNewsPage" target="right"><span class="icon-caret-right"></span>公告管理</a> </li>
    <li><a href="${ctx}/message/queryMessagePage" target="right"><span class="icon-caret-right"></span>留言管理</a> </li>
  </ul>
</div>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>
