<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理</title>
<%@ include file="/WEB-INF/views/include.jsp"%>
<script type="text/javascript">
	
	/*保存企业*/
	function doSave() {
		if ($('#updateForm').form('validate')) {
			formSubmit("updateForm", null, null, true);
		}
	}
	
	$(document).ready(function(){
		 $(groupDIV).hide();
		 $(companyId).change(function() {
			 var cid = $(companyId).val();
			 $.ajax({
				 type: "get",//使用get方法访问后台
				 dataType: "json",//返回json格式的数据
				 url: "${rootpath}group/ajaxList/" + cid + ".json",//要访问的后台地址
				 success: function(data){
					 if(data.resultList.length != 0) {
						 $(groupDIV).show();
						 $(groupId).empty();
						 for(var i = 0; i < data.resultList.length; i++) {
							$(groupId).append(data.resultList[i]);
						 }
					 } else {
						 $(groupDIV).hide();
					 }
				 }
			 })
		 });
	});
</script>
</head>
<body>
	<div class="form-container">
		<form id="updateForm" name="updateForm" method="post"
			action="${rootpath}admin/add.json">
			
			<fieldset>
				<legend> 基本信息 </legend>
				<div>
					<label for="username"> 管理员名：<em>*</em>
					</label> <input name="admin.username" class="easyui-validatebox" type="text"
						required="true" />
				</div>
				
				<div>
					<label for="password"> 密码：<em>*</em>
					</label> <input name="admin.password" class="easyui-validatebox" type="text"
						required="true" />
				</div>
				
				<div>
					<label for="realname"> 真实姓名：<em>*</em>
					</label> <input name="admin.realname" class="easyui-validatebox" type="text"
						required="true" />
				</div>
				
				<div>
					<label for="email"> 邮件地址：
					</label> <input name="admin.email" class="easyui-validatebox" type="text"/>
				</div>
				
				<div>
					<label for="tel"> 电话号码：
					</label> <input name="admin.tel" class="easyui-validatebox" type="text"/>
				</div>
				
				<div>
					<label for="mobile"> 手机号码：
					</label> <input name="admin.mobile" class="easyui-validatebox" type="text"/>
				</div>
				<c:if test="${COMPANY_LIST != null}">
			  	<div>
					<label for="company">所属公司：<em>*</em></label>
					
						 <select id="companyId" name="admin.companyId">
						 <option value="0">请选择</option>
						 	<c:forEach var="company" items="${COMPANY_LIST}">
						 		<option value="${company.coid }">${company.name }</option>
						 	</c:forEach>
						 </select>
					
				</div>	、
				</c:if>
				<div id="groupDIV">
					<label for="group">所属分组：<em>*</em></label>
					
						 <select id="groupId" name="admin.groupId">
						 	<c:forEach var="group" items="${GROUP_LIST}">
						 		<option value="${group.groupId}">${group.name }</option>
						 	</c:forEach>
						 </select>
					
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