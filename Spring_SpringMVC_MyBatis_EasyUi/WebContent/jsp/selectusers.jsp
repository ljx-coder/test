<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/demo.css">
	<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/sysutil.js"></script>
    
<script type="text/javascript">

	//初始化datagrid
	$(function() {
		$('#Users_datagrade').datagrid({
			url :'UsersCon/selectall.do',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			nowrap : true,
			pageSize : 10,
			pageList : [ 10, 15 ],
			sortName: 'uid',
			sortOrder: 'desc',
			idField : 'uid',
			columns : [[{
				title : '编号',
				field : 'uid',
				width : 100,
				align : 'center'
				},{
				title : '名称',
				field : 'name',
				width : 100
			},{
				title :'密码',
				field :'pwd',
				width : 100
			},{
				title :'操作',
				field :'operation',
				width : 100,
				align : 'center',
				formatter : function(value,row,index) {
					return '<img src="${ctx}/images/frame_pencil.png" title="修改" style="cursor:pointer;" onclick="usersupdate('+index+')"/>&nbsp;&nbsp'+
					'<img src="${ctx}/images/frame_remove.png" title="删除" style="cursor:pointer;" onclick="usersdelete('+row.uid+')"/>';
				}
			}]],
			toolbar:[{
					id:'btn_add',
					text:'添加',
					iconCls:'icon-add',
					handler:function(){
						Usersadd();
					}
				}]		
		});
	});
	
	
	//添加
	function Usersadd(){
	$('<div id="usersadd"/>').dialog({
			title: '<span style="color:#157FCC;">添加用户</span>',
			width: 300,
		    height:150, 
		    closed: false,
		    href: 'addUser.jsp',  
		    modal: true,
		    buttons:[{
		    	text:'确认',
		    	iconCls:'icon-ok',
		    	handler:function() {
		    		$('#addusers_form').form('submit',{
			    		url:'UsersCon/addUsers.do',
		    			success:function(data) {
		    			//防止json转换失败
		    			 var data = $.parseJSON(data);
				    			if (data.success) {
				    				$('#Users_datagrade').datagrid('reload');
					    			$('#usersadd').dialog('destroy');
					    			$.messager.show({
										title : '提示',
										msg : data.msg
									});
					    		} else {
					    			$('#usersadd').dialog('destroy');
					    			$.messager.alert('提示', data.msg);
						    	}
					    	
			    		}
			    	});
		    	}			    
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function() {
					$('#usersadd').dialog('destroy');
				}
			}],
			onClose:function() {
				$(this).dialog('destroy');
			}
		});
	}
	
	//删除
	function usersdelete(id){
	$.messager.confirm('确认','您确认要删除所选记录吗?',function(result) {
			if (result) {
				$.ajax({
					url:"UsersCon/deletes.do",
					type:'post',
					data:{"uid":id},
					dataType:'json',
					success:function(data) {
						if (data.success) {
							$.messager.show({
								title : '提示',
								msg : data.msg
							});
							$('#Users_datagrade').datagrid('reload');
						} else {
							$.messager.alert('提示', data.msg);
							$('#Users_datagrade').datagrid('unselectAll');
						}
					},
					error:function() {
						$.messager.alert('提示', '删除记录出错！');
						$('#Users_datagrade').datagrid('unselectAll');
					}
				});
			} else {
				$('#sysAdmin_agentunit_datagrid').datagrid('unselectAll');
			}
		});
	}
	
	//修改
	function usersupdate(index){
	$('<div id="userupdate"/>').dialog({
			title: '<span style="color:#157FCC;">修改用户信息</span>',
			width: 300,
		    height:250, 
		    closed: false,
		    href: 'updateUser.jsp',  
		    modal: true,
		    onLoad:function() {
		    	var rows = $('#Users_datagrade').datagrid('getRows');
				var row = rows[index];
		    	$('#updateusers_form').form('load', row);
			},
			buttons:[{
				text:'确认',
				iconCls:'icon-ok',
				handler:function() {
					$('#updateusers_form').form('submit', {
						url:'UsersCon/updates.do',
						success:function(data) {
						var data = $.parseJSON(data);
				    			if (data.success) {
				    				$('#Users_datagrade').datagrid('unselectAll');
				    				$('#Users_datagrade').datagrid('reload');
					    			$('#userupdate').dialog('destroy');
					    			$.messager.show({
										title : '提示',
										msg : data.msg
									});
					    		} else {
					    			$('#userupdate').dialog('destroy');
					    			$('#Users_datagrade').datagrid('unselectAll');
					    			$.messager.alert('提示', data.msg);
						    	}
						}
					});
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function() {
					$('#userupdate').dialog('destroy');
					$('#Users_datagrade').datagrid('unselectAll');
				}
			}],
			onClose:function() {
				$(this).dialog('destroy');
				$('#Users_datagrade').datagrid('unselectAll');
			}
		});
	}
	
</script>
<div class="easyui-layout" data-options="fit:true, border:false">
    <div data-options="region:'center', border:false" style="overflow: hidden;">  
        <table id="Users_datagrade"></table>
    </div> 
</div>

