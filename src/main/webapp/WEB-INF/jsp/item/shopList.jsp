<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
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

<div class="width1200 center_yh hidden_yh font14" style="height: 40px;line-height: 40px;">
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>><a href="#" class="c_66">商品列表</a>
</div>
<div class="width1198 center_yh" style="height: 35px;background: #f0f0f0; border: 1px solid #ddd;margin-top:25px;">
    <a href="${ctx}/item/shopList?categoryIdTwo=${obj.categoryIdTwo}" class="mR">默认</a>
    <a href="${ctx}/item/shopList?price=1&categoryIdTwo=${obj.categoryIdTwo}" class="mR">
        价格
        <img src="${ctx}/static/user/images/gg.png" alt="">
    </a>
    <a href="${ctx}/item/shopList?buyNum=1&categoryIdTwo=${obj.categoryIdTwo}" class="mR">
        销量
        <img src="${ctx}/static/user/images/gg.png" alt="">
    </a>

</div>
<!--商品列表-->
<div class="width1200 center_yh hidden_yh" style="margin-top: 25px;">
    <ul class="listSs">
        <c:forEach items="${pagers.list}" var="data" varStatus="l">
            <li>
                <a href="${ctx}/item/view?id=${data.id}" class="bjK">
                    <img src="${data.url1}" alt="">
                </a>
                <h3 class="spName">${data.name}</h3>
                <p class="center_yh block_yh hidden_yh" style="width: 202px;">
                    <font class="left_yh red font16">￥${data.price}</font>
                    <c:if test="${data.discount!=null}">
                        <font class="right_yh font14">
                            ${data.discount}
                            <span style="color: red">折</span>
                        </font>
                    </c:if>
                </p>
                <div class="wCa">
                    <a href="${ctx}/collect/addCollect?itemId=${data.id}" class="fav">
                        <div class="wCa1">
                            <b><img src="${ctx}/static/user/images/star.png" alt=""></b>
                            <font>收藏</font>
                        </div>
                    </a>

                    <div class="wCa2" onclick="addcar('${data.id}')">
                        <b><img src="${ctx}/static/user/images/sar.png" alt=""></b>
                        <font>加入购物车</font>
                    </div>

                </div>
            </li>
        </c:forEach>
    </ul>
</div>
    <div id="navs">
        <div class="pagelist">
            <div>
                当前第${pagers.pageNum}页，总共${pagers.pages}页，总共${pagers.total}条记录
            </div>

            <a href="${ctx}/item/shopList?pageNum=1">首页</a>
            <c:if test="${pagers.pageNum == 1 }">
                <a href="${ctx}/item/shopList?pageNum=1">&laquo;</a>
            </c:if>
            <c:if test="${pagers.pageNum != 1 }">
                <a href="${ctx}/item/shopList?pageNum=${pagers.pageNum-1}">&laquo;</a>
            </c:if>
            <c:forEach items="${pagers.navigatepageNums }" var="page_Num">
                <c:if test="${page_Num == pagers.pageNum }">
                    <a class="active" href="#">${page_Num}</a>
                </c:if>
                <c:if test="${page_Num != pagers.pageNum }">
                    <a href="${ctx}/item/shopList?pageNum=${page_Num}">${page_Num}</a>
                </c:if>
            </c:forEach>
            <c:if test="${pagers.pageNum == pagers.pages }">
                <a href="${ctx}/item/shopList?pageNum=${pagers.pages}">&laquo;</a>
            </c:if>
            <c:if test="${pagers.pageNum != pagers.pages }">
                <a href="${ctx}/item/shopList?pageNum=${pagers.pageNum+1}">&raquo;</a>
            </c:if>
            <a href="${ctx}/item/shopList?pageNum=${pagers.pages}">尾页</a>
        </div>
    </div>
<script>
    function addcar(id) {
        $.ajax({
            type:"POST",
            url:"${ctx}/car/exAddCar?itemId="+id+"&num=1",
            success:function (result) {
                var re = result;
                if(re.res == 0){
                    alert("请登录");
                    window.location.href="${ctx}/login/uLogin";
                }else {
                    window.location.href="${ctx}/car/queryCar";
                }
            }
        });
    }
</script>
<%@include file="/common/ufooter.jsp"%>
</body>
</html>



















