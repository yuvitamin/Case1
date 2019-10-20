<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎进入商品详情页</title>
    <style>
        body {
            background: url("img/peien.jpg");
            padding-top: 20px;
            background-size: 100%;
            background-repeat: no-repeat;
        }

        table {

            width: 400px;
            padding-left: 150px;


        }

        caption {
            font-size: 50px;
            padding: 0px 0px 10px 0px;
            font-weight: bold;
            color: lightgray;
        }

        td {
            text-align: center;
            line-height: 30px;
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

        a:hover{
            color: #FFD026;
        }

    </style>
</head>
<body>
<form action="#" method="post">
    <table border="0" cellpadding="20" cellspacing="5" style="width: auto">
        <caption>商品详情</caption>
            <td style="color: white"><img src="${goods.g_goods_pic} "
                                          style="border: whitesmoke solid 8px;border-radius: 5px;" name="picture"
                                          width="450" height="400px"/>
                <br/>
                <a>
                    商品ID:${goods.g_id} </a>
                    <br/>
                <a> 商品价格: ${goods.g_goods_price} </a>
                    <br/>
                <a>   商品库存: ${goods.g_goods_stock} </a>
                    <br/>
                <a> 商品状态: ${goods.is_delete} </a>
            </td>
            <td style="width: 150px; color: white" id="td">  <a>商品名称:
                <br/>
                ${goods.g_goods_name} </a>
                <br/>
                <br/>
                <a>商品简介:
                <br/>
                ${goods.g_goods_description} </a>
                <br/>
            </td>

        <tr>
            <td colspan="2">
                <input type="button" value="返回" onclick="history.back()" id="sub5">
            </td>
        </tr>
    </table>
</form>
</table>
</body>
</html>
