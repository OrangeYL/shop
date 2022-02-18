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
<body>
<div class="panel admin-panel">
    <div class="padding border-bottom">
        <ul class="search" style="padding-left: 10px;">
            <li>
                <a class="button border-main icon-plus-square-o" href="${ctx}/itemCategory/add">新增类目</a>
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th>ID</th>
            <th>类别名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pagers.list}" var="data" varStatus="l">
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>
                    <div class="button-group">
                        <a class="button border-main" href="${ctx}/itemCategory/querySubItemCategoryPage?pid=${data.id}"><span class="icon-edit">查看二级分类</span> </a>
                        <a class="button border-main" href="${ctx}/itemCategory/update?id=${data.id}"><span class="icon-edit">修改</span> </a>
                        <a class="button border-red" href="${ctx}/itemCategory/delete?id=${data.id}&&pageNum=${pagers.pageNum}&&pageTotal=${pagers.total}"><span class="icon-trash-o">删除</span> </a>
                    </div>
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
                        <a href="${ctx}/itemCategory/queryItemCategoryPage?pageNum=1">首页</a>
                    </li>
                    <c:if test="${pagers.pageNum == 1 }">
                        <li>
                            <a href="${ctx}/itemCategory/queryItemCategoryPage?pageNum=1">&laquo;</a>
                        </li>
                    </c:if>
                    <c:if test="${pagers.pageNum != 1 }">
                        <li>
                            <a href="${ctx}/itemCategory/queryItemCategoryPage?pageNum=${pagers.pageNum-1}">&laquo;</a>
                        </li>
                    </c:if>
                    <c:forEach items="${pagers.navigatepageNums }" var="page_Num">

                        <c:if test="${page_Num == pagers.pageNum }">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pagers.pageNum }">
                            <li><a href="${ctx}/itemCategory/queryItemCategoryPage?pageNum=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pagers.pageNum == pagers.pages }">
                        <li><a href="${ctx}/itemCategory/queryItemCategoryPage?pageNum=${pagers.pages}">&laquo;</a></li>
                    </c:if>
                    <c:if test="${pagers.pageNum != pagers.pages }">
                        <li><a href="${ctx}/itemCategory/queryItemCategoryPage?pageNum=${pagers.pageNum+1}">&raquo;</a></li>
                    </c:if>
                    <li>
                        <a href="${ctx}/itemCategory/queryItemCategoryPage?pageNum=${pagers.pages}">尾页</a>
                    </li>
                </ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
