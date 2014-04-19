<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%@ include file="/WEB-INF/views/include.jsp"%>
<script type="text/javascript">
	
	/*保存用户*/
	function doSave() {
		if ($('#updateForm').form('validate')) {
			formSubmit("updateForm", null, null, true);
		}
	}
	
	
	function init() {
		 document.updateForm.settleType.value=${COMPNAY_EDIT_DETAIL.company.settleType};
		 document.updateForm.status.value=${COMPNAY_EDIT_DETAIL.company.status};
		 document.updateForm.serviceType.value=${COMPNAY_EDIT_DETAIL.company.serviceType};
		 document.updateForm.category.value=${COMPNAY_EDIT_DETAIL.company.categoryId};
	}
		
	
	
</script>
</head>
<body onload="init()">
	<div class="form-container">
		<form id="updateForm" name="updateForm" method="post"
			action="${rootpath}company/edit.json">
			<input type="hidden" value="${COMPNAY_EDIT_DETAIL.company.coid}" name="company.coid">
			<fieldset>
				<legend> 基本信息 </legend>
				<div>
					<label for="name"> 公司名：<em>*</em>
					</label> <input name="company.name" class="easyui-validatebox" type="text"
						required="true" value="${COMPNAY_EDIT_DETAIL.company.name}" readonly="readonly"/>
				</div>

				<div>
					<label for="address"> 地址：<em>*</em>
					</label> <input name="company.address" class="easyui-validatebox" type="text"
						required="true" value="${COMPNAY_EDIT_DETAIL.company.address}">
				</div>

				<div>
					<label for="description"> 简介：<em>*</em>
					</label> <textarea rows="5" cols="20" name="company.description" class="easyui-validatebox" type="text"
						required="true" >${COMPNAY_EDIT_DETAIL.company.description}</textarea>
				</div>
				
				<div>
					<label for="contact"> 联系人：<em>*</em>
					</label> <input name="company.contact" class="easyui-validatebox" type="text"
						required="true" value="${COMPNAY_EDIT_DETAIL.company.contact}"/>
				</div>
				
				<div>
					<label for="tel"> 电话号码：<em>*</em>
					</label> <input name="company.tel" class="easyui-validatebox" type="text"
						required="true" value="${COMPNAY_EDIT_DETAIL.company.tel}" validType="tel">
				</div>

				<div>
					<label for="fax"> 传真号码：<em>*</em>
					</label> <input name="company.fax" class="easyui-validatebox" type="text"
						required="true" value="${COMPNAY_EDIT_DETAIL.company.fax}" validType="tel">
				</div>
				
				<div>
					<label for="settleType"> 结算类型：<em>*</em>
					</label> <select name="company.settleType"  id="settleType">
						<option value="0">周结</option>
						<option value="1">月结</option>
						<option value="2">季度结</option>
						<option value="3">半年结</option>
						<option value="4">年结</option>
					</select>
				</div>
				
				<div>
					<label for="salesName"> 业务员：<em>*</em>
					</label> <input name="company.salesName" class="easyui-validatebox" type="text"
						required="true" value="${COMPNAY_EDIT_DETAIL.company.salesName}"/>
				</div>
				
				<div>
					<label for="scale"> 分成比例：<em>*</em>
					</label> <input name="company.scale" class="easyui-validatebox" type="text" value="${COMPNAY_EDIT_DETAIL.company.scale}" >%
				</div>
				
				<div>
					<label for="status"> 公司状态：<em>*</em>
					</label> <select name="company.status" id="status">
						<option value="1">正常</option>
						<option value="0">停用</option>
					</select>
				</div>

				<div>
					<label for="serviceType"> 服务类型：<em>*</em></label> 
					<select name="company.serviceType" id="serviceType">
						<option value="0">贩卖</option>
						<option value="1">咨询</option>
						<option value="2">广告</option>
			  		</select>
			  </div>
			  
			  
			  <div>
					<label for="category">行业类型：<em>*</em></label>
						 <select id="category" name="company.categoryId" id="category">
						 	<option value="-1">--请选择--</option>
						 	<c:forEach var="category" items="${MAIN_CATEGORY}">
						 		<option value="${category.cateid }">${category.name }</option>
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