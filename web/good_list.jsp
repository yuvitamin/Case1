<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎登录商品管理系统</title>
    <style type="text/css">
        .login-box {
            width: 80%;
            margin: 0 auto;
            margin-top: 250px;

        }


        body {
            background: url("img/bg.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }

        .table {
            width: auto;
            padding: 0px 0px 30px 0px;
        }

        td {
            color: white;
            text-align: center;
            padding: 10px 10px 10px 5px;
        }


        a {
            color: #FFD026;
        }

        a1 {
            font-size: 18px;
            font-family: Tahoma;
        }

        .a2 {
            color: papayawhip;
            font-family: "Maiandra GD";
        }

        .add {
            position: absolute;
            left: 45%;
            top: 380px;
            font-size: 22px;
        }

        .add4 {
            position: absolute;
            left: 49%;
            top: 410px;
            font-size: 15px;
            font-family: SimSun-ExtB;
        }

        .add2 {
            position: absolute; /* 绝对定位，相对于浏览器*/
            padding-left: 83%;
            top: 60px;
            font-size: 13px;
        }

        .add3 {
            position: absolute;
            left: 34%;
            top: 76.5%;
            font-size: 14px;
            color: #f0ff55;
            font-family: Tahoma;
            font-weight: bold;        }

        .div1 {
            padding-top: 20px;
            padding-left: 90%;
            font-size: 15px;
            color: white;
            font-family: Aharoni;
        }

        p {
            position: absolute;
            padding: 70px 0px 0px 55px;
            color: white;
        }

        h2 {
            color: white;
            text-align: center;
            padding-top: 65px;
        }

        h4 {
            color: white;
            text-align: center;
            padding-bottom: 20px;
        }

        .blue {
            color: #66bbee;
        }

        .green {
            color: #66ee66;
        }

        .welcome {
            color: darkkhaki;
        }

        div3 {
            font-size: 12px;
            color: white;
            padding-left: 350px;
        }

        div4 {
            color: white;
            padding-left: 450px;
            font-size: 12px;
        }

        div5 {
            color: white;
            padding-left: 560px;
            font-size: 12px;
        }

        div6 {
            padding-left: 8%;
            color: white;
            font-size: 30px;
            font-family: Dotum;
        }

        span1 {
            font-size: 22px;
            font-family: Dotum;
        }


        input::-webkit-input-placeholder { /*提示文字颜色*/
            padding-left: 8px;
            color: silver;

        }

        div7 {
            position: absolute;
            padding-top: 170px;
            padding-left: 480px;
        }

        #sub {
            border-radius: 15px;
            width: 70px;
            height: 30px;
            background: transparent url(img/submit.jpg) no-repeat;
            border: none;
        }

        #sub2 {
            border-radius: 15px;
            width: 70px;
            height: 30px;
            background: transparent url(img/submit2.jpg) no-repeat;
            border: none;
        }

        #sub3 {
            border-radius: 15px;
            width: 70px;
            height: 30px;
            background: transparent url(img/submit2.jpg) no-repeat;
            border: none;
        }

        #sub4 {
            border-radius: 15px;
            width: 70px;
            height: 30px;
            background: transparent url(img/submit2.jpg) no-repeat;
            border: none;
        }

        #sub5 {
            border-radius: 15px;
            width: 70px;
            height: 30px;
            background: transparent url(img/submit2.jpg) no-repeat;
            border: none;
        }

        #sub2:hover {
            color: red;
        }

        #sub3:hover {
            color: red;
        }

        #sub4:hover {
            color: red;
        }

        #sub5:hover {
            color: red;
        }

        #selectAll {
            border-radius: 15px;
            width: 80px;
            height: 30px;
            background: transparent url(#) no-repeat;
            border: none;
            font-size: 14px;
            color: #f0ff55;
            font-family: Tahoma;
            font-weight: bold;
        }

        #unSelectAll {
            margin-left: 10px;
            border-radius: 15px;
            width: 120px;
            height: 30px;
            font-size: 14px;
            background: transparent url(#) no-repeat;
            border: none;
            color: #f0ff55;
            font-family: Tahoma;
            font-weight: bold;
        }

        #selectRev {
            margin-left: 10px;
            border-radius: 15px;
            width: 80px;
            height: 30px;
            font-size: 14px;
            background: transparent url(#) no-repeat;
            border: none;
            color: #f0ff55;
            font-family: Tahoma;
            font-weight: bold;
        }

        .bg:hover {
            width: 35px;
            height: 20px;
            background-color: rgba(157, 157, 157, 0.57);
        }

        .bg2:hover {
            width: 35px;
            height: 20px;
            background-color: rgba(157, 157, 157, 0.57);

        }

        .bg3:hover {
            width: 35px;
            height: 20px;
            background-color: rgba(157, 157, 157, 0.57);
        }


        a5:hover{
            color: blue;
            font-weight: bold;
        }


    </style>
</head>
<script type="text/javascript">

    function onUpdate(g_id) {
        window.location.href = "updateGoodsServlet1?g_id=" + g_id;
    }

    function detail(g_id) {
        window.location.href = "detailPageServlet?g_id=" + g_id;
    }

    function onDelete(g_id) {

        if (confirm("确定删除吗？")) {
            window.location.href = "deleteServlet?g_id=" + g_id;
        }
    }

    function removeStuBatch() {
        document.getElementById("form").submit();
    }

    window.onload = function () {

        //全选
        document.getElementById("selectAll").onclick = function () {
            //获取所有的checkbox，复选框
            var cbArr = document.getElementsByName("g_id");
            for (var i = 0; i < cbArr.length; i++) {
                var cb = cbArr[i];
                //改变checked属性
                cb.checked = true;
            }
        }
        //全不选
        document.getElementById("unSelectAll").onclick = function () {
            var cbArr = document.getElementsByName("g_id");
            for (var i = 0; i < cbArr.length; i++) {
                cbArr[i].checked = false;
            }


        }

        //反选
        document.getElementById("selectRev").onclick = function () {
            var cbArr = document.getElementsByName("g_id");
            for (var i = 0; i < cbArr.length; i++) {
                if (cbArr[i].checked) {
                    cbArr[i].checked = false;
                } else {
                    cbArr[i].checked = true;
                }
            }
        }
    }

    function onSelect() {
        var g_id = document.getElementById("g_id").value;
        window.location.href = "detailPageServlet?g_id=" + g_id;
        var name = document.getElementById("inputname").value;
        window.location.href = "selectServlet?name=" + name;
        var price = document.getElementById("inputprice").value;
        window.location.href = "selectServlet?price=" + price;
        var flag = document.getElementById("inputflag").value;
        window.location.href = "selectServlet?flag=" + flag;

    }



</script>


<!-- SITE TOP -->

<div class="div1"> Welcome, <a href="#">${user}</a></div>
<div6><strong>Snow White's</strong>
    <span1>template&nbsp;<a1>白雪公主的模板</a1>
    </span1>
</div6>

</div> <!-- .site-header -->
<div class="site-banner">
    <h2>Welcome to login <span class="blue">commodity management </span><span class="green">system</span></h2>
    <h4><span class="welcome">欢迎登录</span><span class="welcome">商品管理</span><span class="welcome">系统</span></h4>
    <div3>More and more enterprises need an intelligent product information management system,
        which can help enterprises manage all products effectively.
    </div3>
    <br/>
    <div4>We provide a one-stop product management platform, a system to manage all products of enterprises,</div4>
    <div5>improve the efficiency of product sales and management.</div5>
</div>
<div7>
    <input type="text" id="g_id" style="border:1px solid white;background:none; color: white" placeholder="需要查询的ID">
    <input type="text" style="border:1px solid white;background:none; color: white" placeholder="需要查询的商品名称">
    <input type="text" style="border:1px solid white;background:none; color: white" placeholder="需要查询的商品价格">
    <input type="submit" value="查询" name="submit" id="sub" class="sub1" onclick="onSelect()">
</div7>



<div class="login-box">
    <span class="bg">
        <input type="button" id="selectAll" value="全选">
    </span>
    <span class="bg2">
        <input type="button" id="unSelectAll" value="全不选">
    </span>
    <span class="bg3">
    <input type="button" id="selectRev" value="反选">
    </span>


    <div class="add2">
        <a href="logoutServlet">Logout</a></div>
    <div class="add">
        <a href="add_goods.jsp" class="a2">New commodities</a>
    </div>
    <div class="add4">
        <a href="add_goods.jsp" class="a2">新增商品</a>
    </div>
    <div class="add3">
        <a href="javascript:void(0);" onclick="removeStuBatch();" class="a2">逻辑删除</a>
    </div>


    <form action="deletionServlet" method="post" id="form">


        <table class="table" border="0px" cellspacing="20" align="left">

            <c:forEach items="${list}" var="goods" varStatus="s">

                <td>
                    <input type="checkbox" name="g_id" value="${goods.g_id}">
                </td>
                <td style="background-color: white" width="100px"><img src="${goods.g_goods_pic}"
                                                                               style="border: whitesmoke solid 8px;border-radius: 5px"
                                                                               width="200px" height="180px">
                <br/>
               <a style="color: black;font-size: 14px"><a5>商品名称</a5></a>
                <br/>
                    <a style="color: black;font-size: 15px"><a5>${goods.g_goods_name}</a5></a>
                <br/>
                <a style="color: black;font-size: 14px"><a5>售价：</a5></a>
                    <a style="color: black;font-size: 15px"><a5>${goods.g_goods_price}元</a5></a>
            </td>
                <td width="200px">
                    <input type="button" value="详情" id="sub4" style="margin-bottom: 10px"
                           onclick="detail('${goods.g_id}')">
                    <input type="button" value="更新" id="sub3" style="margin-bottom: 10px"
                    onclick="onUpdate('${goods.g_id}')">
                    <input type="button" value="删除" id="sub2" style="margin-bottom: 10px"
                           onclick="onDelete('${goods.g_id}')">
                    <input type="button" value="逻辑删除" id="sub5" style="margin-bottom: 10px"
                           onclick="removeStuBatch('${goods.g_id}')">
                </td>
                <c:if test="${s.index%2!=0}">
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
