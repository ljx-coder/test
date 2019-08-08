<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8">
	<title>Full Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>easyui/css/demo.css">
	<script type="text/javascript" src="<%=basePath %>easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>easyui/jquery.easyui.min.js"></script>

<script type="text/javascript">
 function addPanel(url,title){  
                if(!$('#tt').tabs('exists', title)){
                    $('#tt').tabs('add',{  
                        title: title,  
                        content: '<iframe src="'+url+'" frameBorder="0" border="0"  style="width: 100%; height: 100%;"/>',  
                        closable: true  
                    });  
                }else{  
				//点击谁选中谁
				$('#tt').tabs('select',title);
                }  
            }  
            function removePanel(){  
                var tab = $('#tt').tabs('getSelected');  
                if (tab){  
                    var index = $('#tt').tabs('getTabIndex', tab);  
                    $('#tt').tabs('close', index);  
                }  
            }  
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:200px;padding:10px;">
	 
	   <div class="easyui-panel" style="padding:5px; height:100%; width: 180px; border: 0px;">
		<ul class="easyui-tree">
			<li>
				<span>My Documents</span>
				<ul>
					<li>
						<span>用户管理</span>
						<ul>
							<li><span><a href="javascript:void(0)" onclick="addPanel('selectusers.jsp','查询用户')">查询用户</a></span></li>
						</ul>
					</li>
					<li>
						<span>员工管理</span>
						<ul>
							<li><span><a href="javascript:void(0)" onclick="addPanel('addusers.jsp','查询用户')">查询用户</a></span></li>
						</ul>
					</li>
					<li>
						<span>客户管理</span>
						<ul>
							<li><span><a href="javascript:void(0)" onclick="addPanel('addusers.jsp','查询用户')">查询用户</a></span></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</div>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'" class="easyui-tabs" id="tt"></div>
</body>
</html>