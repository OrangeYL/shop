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
    <table class="table table-hover text-center">
        <tr>
            <th>商品名称</th>
            <th>商品主图</th>
            <th>商品单价</th>
            <th>购买数量</th>
            <th>小计</th>
            <th>状态</th>
        </tr>
    <c:forEach items="${pagers.list}" var="data" varStatus="l">
        <tr>
            <td>${data.item.name}</td>
            <td><img src="${data.item.url1}" alt="" style="width: 100px;height: 100px;"></td>
            <td>${data.item.price}</td>
            <td>${data.num}</td>
            <td>${data.total}</td>
            <td style="color: red">
                <c:if test="${data.status == 0}">
                        未退货
                </c:if>
                <c:if test="${data.status == 1}">
                    已退货
                </c:if>
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
                        <a href="${ctx}/orderDetail/queryOrderDetailPage?pageNum=1&&orderId=${obj.orderId}">首页</a>
                    </li>
                    <c:if test="${pagers.pageNum == 1 }">
                        <li>
                            <a href="${ctx}/orderDetail/queryOrderDetailPage?pageNum=1&&orderId=${obj.orderId}">&laquo;</a>
                        </li>
                    </c:if>
                    <c:if test="${pagers.pageNum != 1 }">
                        <li>
                            <a href="${ctx}/orderDetail/queryOrderDetailPage?pageNum=${pagers.pageNum-1}&&orderId=${obj.orderId}">&laquo;</a>
                        </li>
                    </c:if>
                    <c:forEach items="${pagers.navigatepageNums }" var="page_Num">

                        <c:if test="${page_Num == pagers.pageNum }">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pagers.pageNum }">
                            <li><a href="${ctx}/orderDetail/queryOrderDetailPage?pageNum=${page_Num}&&orderId=${obj.orderId}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pagers.pageNum == pagers.pages }">
                        <li><a href="${ctx}/orderDetail/queryOrderDetailPage?pageNum=${pagers.pages}&&orderId=${obj.orderId}">&laquo;</a></li>
                    </c:if>
                    <c:if test="${pagers.pageNum != pagers.pages }">
                        <li><a href="${ctx}/orderDetail/queryOrderDetailPage?pageNum=${pagers.pageNum+1}&&orderId=${obj.orderId}">&raquo;</a></li>
                    </c:if>
                    <li>
                        <a href="${ctx}/orderDetail/queryOrderDetailPage?pageNum=${pagers.pages}&&orderId=${obj.orderId}">尾页</a>
                    </li>
                </ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>