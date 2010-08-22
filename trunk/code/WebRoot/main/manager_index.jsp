<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>角色权限管理系统 V1.0</title>
		<style type="text/css">
			#loading{
		        position:absolute;
		        left:40%;
		        top:40%;
		        padding:2px;
		        z-index:20001;
		        height:auto;
		    }
		    #loading a {
		        color:#225588;
		    }
		    #loading .loading-indicator{
		        background:white;
		        color:#444;
		        font:bold 13px tahoma,arial,helvetica;
		        padding:10px;
		        margin:0;
		        height:auto;
		    }
		    #loading-msg {
		        font: normal 10px arial,tahoma,sans-serif;
		    }
		</style>
		<script type="text/javascript">
			var currentUser = '当前用户:<s:property value="#session.user.emplName"/>';
			var nav = '<s:property value="tip"/>';
			if(nav == '' || nav.length <= 0){
				location = '/rbac/index.jsp';
			}
		</script>
	</head>
	<body>
		<div id="loading">
			<div class="loading-indicator">
				<img src="/rbac/images/loading32.gif" width="31" height="31" style="margin-right:8px;float:left;vertical-align:top;" />
				角色权限管理系统 V1.0
				<br />
				<span id="loading-msg">加载样式和图片...</span>
			</div>
		</div>
		<div id="bd">
			<link rel="stylesheet" type="text/css" media="all" href="/rbac/resources/css/ext-all.css" />
			<link rel="stylesheet" type="text/css" media="all" href="/rbac/css/index.css" />
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '加载核心...';</script>
			<script type="text/javascript" src="/rbac/adapter/ext/ext-base.js"></script>
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '加载UI组件...';</script>
			<script type="text/javascript" src="/rbac/ext-all.js"></script>
			<script type="text/javascript">document.getElementById('loading-msg').innerHTML = '模块初始化...';</script>
			<script type="text/javascript" src="/rbac/js/RowExpander.js"></script>
			<script type="text/javascript" src="/rbac/locale/ext-lang-zh_CN.js"></script>
			<script type="text/javascript" src="/rbac/js/my_user.js"></script>
			<script type="text/javascript" src="/rbac/js/permission.js"></script>
			<script type="text/javascript" src="/rbac/js/role.js"></script>
			<script type="text/javascript" src="/rbac/js/main.js"></script>
		</div>
		<div id="header">
			<h1> 
				角色权限管理系统 V1.0 
			</h1>
		</div>
	</body>
</html>
