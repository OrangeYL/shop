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
    <form action="${ctx}/news/queryNewsPage" id="listform" method="post">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left: 10px;">
                <li>
                    <a class="button border-main icon-plus-square-o" href="${ctx}/news/add">添加公告</a>
                </li>
                <li>
                    <input type="text" placeholder="请输入公告名称" name="name" class="input" value="${obj.name}"
                        style="width: 250px;line-height: 17px;display: inline-block" />
                    <a href="javascript:void(0)" onclick="changeSearch()" class="button border-main icon-search">搜索</a>
                </li>
            </ul>
        </div>
    </form>
    <table class="table table-hover text-center">
        <tr>
            <th>名称</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${pagers.list}" var="data" varStatus="l">
        <tr>
            <td>${data.name}</td>
            <td><fmt:formatDate value="${data.addTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
            <td>
                <a class="button border-main" href="${ctx}/news/update?id=${data.id}"><span class="icon-edit">修改</span> </a>
                <a class="button border-red" href="${ctx}/news/delete?id=${data.id}&&pageNum=${pagers.pageNum}&&pageTotal=${pagers.total}"><span class="icon-trash-o">删除</span> </a>
            </td>

        </tr>
    </c:forEach>
        <tr>
            <td colspan="8">
                <div>
                    当前第${pagers.pageNum}页，总共${pagers.pages}页，总共${pagers.total}条记录
                </div>

                <ul class="pagination">
                    <li>
                        <a href="${ctx}/news/queryNewsPage?pageNum=1">首页</a>
                    </li>
                    <c:if test="${pagers.pageNum == 1 }">
                        <li>
                            <a href="${ctx}/news/queryNewsPage?pageNum=1">&laquo;</a>
                        </li>
                    </c:if>
                    <c:if test="${pagers.pageNum != 1 }">
                        <li>
                            <a href="${ctx}/news/queryNewsPage?pageNum=${pagers.pageNum-1}">&laquo;</a>
                        </li>
                    </c:if>
                    <c:forEach items="${pagers.navigatepageNums }" var="page_Num">

                        <c:if test="${page_Num == pagers.pageNum }">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pagers.pageNum }">
                            <li><a href="${ctx}/news/queryNewsPage?pageNum=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pagers.pageNum == pagers.pages }">
                        <li><a href="${ctx}/news/queryNewsPage?pageNum=${pagers.pages}">&laquo;</a></li>
                    </c:if>
                    <c:if test="${pagers.pageNum != pagers.pages }">
                        <li><a href="${ctx}/news/queryNewsPage?pageNum=${pagers.pageNum+1}">&raquo;</a></li>
                    </c:if>
                    <li>
                        <a href="${ctx}/news/queryNewsPage?pageNum=${pagers.pages}">尾页</a>
                    </li>
                </ul>
            </td>
        </tr>
    </table>
</div>
<script>
    function changeSearch(){
        $("#listform").submit();
    }
</script>
</body>

</html>