<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
    <script src="https://cdn.bootcss.com/axios/0.19.0-beta.1/axios.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
</head>
<style>
    body{
        max-width: 1024px;
        margin: 0 auto;
        font-family: Arial;
        font-size: 14px;
    }
    table{
        padding: 30px;
        color: black;
    }
    table th{
        height: 50px;
        width: 200px;
    }
    table td{
        text-align: center;
    }


</style>
<body>
	<div id="app">
	
		<div>${ca}</div>
        <table>
            <thead>
            <tr>
                 <th>ID</th>
                <th>图片</th>
                <th>分类名称</th>
                <th>属性管理</th>
                <th>产品管理</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="c in categories">
              <td>{{c.id}}</td>
                <td><img height="40px"></td>
                <td>{{c.name}}</td>
                <td><a :href="'http://www.baidu.com'+c.id">属性</a></td>
                <td><a :href="'http://www.taobao.com'+c.id">产品</a></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.bootcss.com/vue/2.5.17-beta.0/vue.js"></script>
    <script type="text/javascript">
    var app=new Vue({
        el : '#app',
        data:{
            categories:[{id:1,name:"555"}]
        },
        mounted:function(){
            var self = this;
            axios.post("/getcategories").then(function(response) {
                console.log(response);
                self.categories= response.data; //此时还是字符串
                self.categories = eval("("+self.categories+")");  //字符串转换为数组对象
            })
        },
        methods:{


        }
    })
    </script>
</body>
</html>