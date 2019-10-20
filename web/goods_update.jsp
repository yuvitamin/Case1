
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎进入商品更新页面</title>
    <style>
        body {
            background: url("img/update.jpg");
            padding-top: 40px;
            background-size: cover;
            background-repeat: no-repeat;
        }

        caption {
            font-size: 50px;
            padding: 50px 0px 20px 0px;
            font-weight: bold;
            color: lightgray;
        }

        table {
            margin-top: 100px;
            width: 400px;
            /*background-color: rgba(255, 249, 218, 0.32);;*/
        }

        td {
            text-align: center;
            color: black;
        }

        .text-center {
            text-align: center;
            border-radius: 1px;

        }

        #tb{
            position: absolute;
            margin-top: 50px;
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
</head>
<body>

<form action="updateGoodsServlet2" method="post">
    <table id="tb" align="left">
        <tr>
        <td style="color: white"><img src="${goods.g_goods_pic} "
                                      style="border: rosybrown solid 8px;border-radius: 5px;" name="g_goods_pic"
                                      width="250" height="250"/>
            <br/>
            <a>当前商品</a>
            </td>
        </tr>
    </table>


    <table  align="center" style="border: 6px solid rosybrown;border-radius: 8px;background-color:#f8ffa2"  cellpadding="5" cellspacing="12">

        <input type="hidden" name="g_id" value="${goods.g_id}">
        <tr>
            <td>商品名称</td>
            <td><input class="text-center"  required="required" type="text" name="g_goods_name" /></td>
        </tr>
        <tr>
            <td>图片</td>
            <td><a href="uploadServlet"><input class="text-center" type="file"  required="required" name="g_goods_pic" value="${goods.g_goods_pic}"/></a></td>

        </tr>

        <tr>
            <td>商品价格</td>
            <td><input class="text-center" type="text" name="g_goods_price"  required="required" value="${goods.g_goods_price}"/></td>
        </tr>
        <tr>
            <td>商品简介</td>
            <td><input class="text-center" type="text"  name="g_goods_description" required="required" value="${goods.g_goods_description}"/></td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td><input class="text-center" type="text" name="g_goods_stock"  required="required" value="${goods.g_goods_stock}"/></td>
        </tr>
        <tr>
            <td>商品状态</td>
            <td>
                <select name="is_delete"  required="required" value="${goods.is_delete}">
                    <option value="0">0(上架)</option>
                    <option value="1">1(下架)</option>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="更新" id="sub5">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="返回" onclick="history.back()" id="sub6">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
