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
        <strong><span class="icon-pencil-square-o">新增商品</span> </strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/item/exAdd" method="post" class="form-x" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label"><label>商品名称：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入商品名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品价格：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="price" data-validate="required:请输入商品价格" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品折扣：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="discount" data-validate="required:请输入商品折扣" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>商品类别：</label></div>
                <div class="field">
                    <select name="categoryIdTwo" class="input w50">
                        <c:forEach items="${types}" var="data" varStatus="l">
                            <option value="${data.id}">${data.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>主图：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图1：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图2：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图3：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>副图4：</label></div>
                <div class="field">
                    <input type="file" class="input w50" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>描述：</label></div>
                <div class="field">
                    <textarea name="des" type="text" class="input w50" data-validate="required:请输入商品描述"></textarea>
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