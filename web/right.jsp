<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/10
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<script type="application/javascript" src="js/jquery-1.11.1-min.js"></script>
<script type="text/javascript">
    $(function (){
       /* setInterval(function (){
            $.ajax({
                url:"HT",
                dataType:"json",
                success:function (resp){
                    $.each(resp, function(index, element){
                        $("#div_1").html("湿度：" + element.humidity);
                        $("#div_2").html("温度：" + element.temperature);
                    })
                }
            })
        }, 1000 * 3)*/
        $("#bt").click(function (){
            $.ajax({
                url:"HT",
                dataType:"json",
                success:function (resp){
                    $.each(resp, function(index, element){
                        $("#div_1").html("湿度：" + element.humidity);
                        $("#div_2").html("温度：" + element.temperature);
                    })
                }
            })
        })
    })
</script>
</head>
<body>
    <center>
        <div ><font style="font-size: 60px;color: aqua">DHT11温湿度实时查看</font></div><br>
        <div style="font-size: 30px;color: blue" id="div_1">温度：</div><br>
        <div style="font-size: 30px;color: blue" id="div_2">湿度：</div><br>
        <div><input type="button" value="获取" id="bt"></div>

    </center>
</body>
</html>
