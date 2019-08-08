<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showBooks.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script> 

<style type="text/css">
td{text-align:center;}
#fy{text-align:center;}
</style>
<script type="text/javascript">
   function del(){
        return confirm("您确定要删除此条记录？");
    }

</script>
  </head>
  <body>
     <div class="container">
    <h2>书籍管理</h2>
    <form action="books/queryDynamic.do"  method="post">
       <span>书籍名称:</span><input type="text"  name="name"  value="${name}"/>
       <span>书籍类型:</span><input type="text"  name="types"  value="${types}"/>
       <button  class="btn btn-primary"  type="submit" >查询</button>
       <a href=""><button  class="btn btn-primary"  style="margin-left:300px;">添加书籍</button></a>
    </form>
     <table class="table table-striped table-bordered table-hover table-condensed"  style="margin-top: 10px;">
        <thead>
          <tr>
            <td>书籍序号</td>
            <td>书籍名称</td>
            <td>书籍类型</td>
            <td>书籍价格</td>
            <td>书籍数量</td>
            <td colspan="2">操作</td>
          </tr>
        </thead>
        <tbody>
            <c:forEach  items="${page.pageData}"  var="list">
               <tr>
                   <td>${list.bid}</td>
                   <td>${list.name}</td>
                   <td>${list.types}</td>
                   <td>${list.price}</td>
                   <td>${list.count}</td>  
                   <td><a href="books/delete.do?pageNo=${page.pageNo}&bid=${list.bid}" onclick=" return del()">删除</a></td>
                   <td><a>修改</a></td>             
               </tr>
            </c:forEach>
        </tbody>
     </table>
   </div>
   	
	<div  id="fy">
		<ul   class="pagination" >
		<c:if test="${page.pageNo>1}">
		   <li><a href="books/queryDynamic.do?pageNo=1">首页</a></li>
		   <li><a href="books/queryDynamic.do?pageNo=${pageBack}">上一页</a></li>
		</c:if>
		<c:if test="${page.pageNo<page.pageCount}">
		   <li><a href="books/queryDynamic.do?pageNo=${pageNext}">下一页</a></li>
		   <li><a href="books/queryDynamic.do?pageNo=${page.pageCount}">末页</a></li>
		</c:if>
		</ul>
	</div>
 
  
  </body>
</html>
