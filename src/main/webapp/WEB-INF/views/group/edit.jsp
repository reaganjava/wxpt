<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业管理</title>
<%@ include file="/WEB-INF/views/include.jsp"%>
<script type="text/javascript">
	
	/*保存用户*/
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
			action="${rootpath}group/edit.json">
			<input type="hidden" value="${GROUP_EDIT_DETAIL.group.groupId}" name="group.groupId">
			<fieldset>
				<legend> 基本信息 </legend>
				<div>
					<label for="name"> 分组名：<em>*</em>
					</label> <input name="group.name" class="easyui-validatebox" type="text"
						required="true" value="${GROUP_EDIT_DETAIL.group.name}" readonly="readonly"/>
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