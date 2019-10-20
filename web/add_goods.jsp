
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎登录商品添加页面</title>
</head>
<style>
    body{
        background: url("img/add.jpg");
        padding-top: 40px;
        background-size: cover;
        background-repeat: no-repeat;
    }
    caption{
        font-size: 50px;
        padding: 50px 0px 20px 0px;
        font-weight: bold;
        color: lightgray;
    }
    table{
        margin-left: 16%;
        width: 400px;
        background-color: white;
        border-radius: 5px;
    }
    td{
        text-align: center;
    }

    .text-center {
        text-align: center;
        border-radius: 1px;

    }

    #sub5 {
        border-radius: 15px;
        width: 70px;
        height: 30px;
        background: transparent url(img/submit2.jpg) no-repeat;
        border: none;
    }

    #sub5:hover {
        color: red;
    }

    #sub6 {
        border-radius: 15px;
        width: 70px;
        height: 30px;
        background: transparent url(img/submit2.jpg) no-repeat;
        border: none;
    }

    #sub6:hover {
        color: red;
    }
</style>
<body>
<form action="addGoodsServlet" method="post" >
        <table  border="0"cellpadding="10" cellspacing="0">
            <caption>新增商品</caption>
        <tr>
            <td>ID</td>
            <td class="text-center" ><input type="text" name="g_id" size="35px" class="text-center" required="required"/></td>
        </tr>
        <tr>
        <tr>
            <td>商品名称</td>
            <td class="text-center"><input type="text" name="g_goods_name" size="35px" class="text-center" required="required"/></td>
        </tr>
        <tr>
            <td>上传图片</td>
            <td class="text-center" ><a href="uploadServlet"><input type="file" name="g_goods_pic" size="35px" class="text-center" required="required" ></a></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td class="text-center" ><input type="text" name="g_goods_price" size="35px" class="text-center" required="required"/></td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td class="text-center" ><input type="text" name="g_goods_description" size="35px" class="text-center" required="required"/></td>
        </tr>

        <tr>
            <td>商品库存</td>
            <td class="text-center"><input type="text" name="g_goods_stock" size="35px" class="text-center" required="required"/></td>
        </tr>
        <tr>
        <td class="text-center" >商品状态</td>
        <td >
            <select name="is_delete" required="required">
                <option value="0">在售</option>
                <option value="1">下架</option>
            </select>
        </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="保存 " id="sub5">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="返回" onclick="history.back()" id="sub6">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
