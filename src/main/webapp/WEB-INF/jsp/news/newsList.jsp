<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/user/css/style.css">
    <script src="${ctx}/static/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/static/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
    <%@include file="/common/utop.jsp"%>
<!--导航条-->
<div class="width100" style="height: 45px;background: #dd4545;margin-top: 40px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/news/newsList">公告</a>
            <a href="${ctx}/message/addMessage">留言</a>
        </div>
    </div>
</div>
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top:34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipRight" style="width: 1200px">
            <div class="fon24" style="height: 60px;line-height: 60px;text-indent: 50px;background: #f5f8fa;border-bottom: 1px solid #ddd;">
                公告列表
            </div>
            <div class="hidden_yh" style="padding:20px;width:898px;">
                <c:forEach items="${pagers.list}" var="data" varStatus="l">
                    <a href="${ctx}/news/view?id=${data.id}">
                        <div class="width100 hidden_yh" style="border-bottom: 1px dashed #ddd; padding-top:10px;padding-bottom: 10px;">
                            <div class="left_yh" style="width:580px;">
                                <font color="red"> ${data.name}</font>
                            </div>
                            <div class="right_yh">
                                <font color="black"><fmt:formatDate value="${data.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/></font>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
        <div class="pagelist">
            <div>
                当前第${pagers.pageNum}页，总共${pagers.pages}页，总共${pagers.total}条记录
            </div>

            <a href="${ctx}/news/newsList?pageNum=1" style="color: #0f0f0f">首页</a>
            <c:if test="${pagers.pageNum == 1 }">
                <a href="${ctx}/news/newsList?pageNum=1" style="color: #0f0f0f">&laquo;</a>
            </c:if>
            <c:if test="${pagers.pageNum != 1 }">
                <a href="${ctx}/news/newsList?pageNum=${pagers.pageNum-1}" style="color: #0f0f0f">&laquo;</a>
            </c:if>
            <c:forEach items="${pagers.navigatepageNums }" var="page_Num">
                <c:if test="${page_Num == pagers.pageNum }">
                    <a class="active" href="#" style="color: #0f0f0f">${page_Num}</a>
                </c:if>
                <c:if test="${page_Num != pagers.pageNum }">
                    <a href="${ctx}/news/newsList?pageNum=${page_Num}" style="color: #0f0f0f">${page_Num}</a>
                </c:if>
            </c:forEach>
            <c:if test="${pagers.pageNum == pagers.pages }">
                <a href="${ctx}/news/newsList?pageNum=${pagers.pages}" style="color: #0f0f0f">&laquo;</a>
            </c:if>
            <c:if test="${pagers.pageNum != pagers.pages }">
                <a href="${ctx}/news/newsList?pageNum=${pagers.pageNum+1}" style="color: #0f0f0f">&raquo;</a>
            </c:if>
            <a href="${ctx}/news/newsList?pageNum=${pagers.pages}" style="color: #0f0f0f">尾页</a>
        </div>
    </div>
</div>

<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















