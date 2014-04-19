<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
<%@ include file="/WEB-INF/views/include.jsp"%>
<script type="text/javascript">
	
	/*保存企业*/
	function doSave() {
		if ($('#updateForm').form('validate')) {
			formSubmit("updateForm", null, null, true);
		}
	}
	
	
	
</script>
</head>
<body>
	<div class="form-container">
		<form id="updateForm" name="updateForm" method="post"
			action="${rootpath}menuItem/add.json">
			
			<fieldset>
				<legend> 基本信息 </legend>
				<div>
					<label for="title"> 菜单标题名：<em>*</em>
					</label> <input name="menuItem.title" class="easyui-validatebox" type="text"
						required="true" />
				</div>
				<div>
					<label for="url">菜单URL：<em>*</em></label>
						 <select id="url" name="menuItem.url" >
						 	<c:forEach var="menuItem" items="${MENU_ITEM_URLS}">
						 		<option value="${menuItem.value }">${menuItem.key }</option>
						 	</c:forEach>
						 </select>
				</div>	
				<div>
					<label for="priority">菜单排序号：<em>*</em></label>
					<select id="priority" name="menuItem.priority">
							<option value="0">--请选择--</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
				    </select>
				</div>
				<div>
					<label for="group">菜单分组：<em>*</em></label>
					 	<c:forEach var="group" items="${GROUP_LIST}">
					 		<input type="checkbox" name="groupIds" value="${group.groupId}">${group.name} 
					 	</c:forEach>
				</div>	
				
				</fieldset>
				<div class="buttonrow">
					<input class="submitbtn" type="button" value="保存"
						onclick="doSave();" />
					&nbsp;&nbsp;
					<input class="submitbtn" type="button" value="关闭"
						onClick="self.parent.closeCurrTab();" />
				</div>
			</form>
		</div>
	</body>
</html>