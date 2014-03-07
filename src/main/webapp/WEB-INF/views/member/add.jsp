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
			if($("#group").val()==-1){
				msgAlert('提示',"用户分组不能为空！",'info', null);
				return false;
			}
			if($("#role").val()==-1){
				msgAlert('提示',"用户角色不能为空！",'info', null);
				return false;
			}
			formSubmit("updateForm", null, null, true);
		}
	}
	
	/*查询分组*/
	function selectGroup(){
		ajaxPost("<%=request.getContextPath()%>/member/findGroup.json",null,callBackGroup);
	}
	
	/*查询分组回调方法*/
	function callBackGroup(data){
		var selector=$('#group');  
		for(var i=0;i<data.length;i++){
			 selector.append("<option value="+data[i].groupId+">"+data[i].groupName+"</option>");  			
		}
	}
	
	/*查询分组下角色*/
	function selectRole(groupId){
		if(groupId!=-1){
			var params={"groupId":groupId};
			ajaxPost("<%=request.getContextPath()%>/member/findRoleByGroupId.json",params,callBackRole);
		}
	}
	
	/*查询分组下角色回调方法*/
	function callBackRole(data){
		var selector=$('#role');
		selector.empty();
		if(data.success==false){
			msgAlert('提示',data.msg,'info', null);
			return;
		}
		selector.append("<option value='-1'>--请选择--</option>");
		for(var i=0;i<data.length;i++){
			if(data[i].roleName!=null){
				selector.append("<option value="+data[i].roleId+">"+data[i].roleName+"</option>");
			}
		}
	}
	
</script>
</head>
<body onload="selectGroup()">
	<div class="form-container">
		<form id="updateForm" name="updateForm" method="post"
			action="<%=request.getContextPath()%>/member/save.json">
			
			<fieldset>
				<legend> 基本信息 </legend>
				<div>
					<label for="userName"> 用户名：<em>*</em>
					</label> <input name="userName" class="easyui-validatebox" type="text"
						required="true" />
				</div>
				
				<div>
					<label for="userName"> 密码：<em>*</em>
					</label> <input name="password" class="easyui-validatebox" type="password"
						required="true" />
				</div>

				<div>
					<label for="mobile"> 手机号：<em>*</em>
					</label> <input name="mobile" class="easyui-validatebox" type="text"
						required="true" validType="mobile">
				</div>

				<div>
					<label for="email"> 邮箱地址：<em>*</em>
					</label> <input name="email" class="easyui-validatebox" type="text"
						required="true" validType="email">
				</div>

				<div>
					<label for="status"> 用户状态：<em>*</em>
					</label> <select name="status">
						<option value="1">正常</option>
						<option value="2">停用</option>
					</select>
				</div>

				<div>
					<label for="type"> 用户类型：<em>*</em></label> <select name="type">
						<option value="1">普通用户</option>
						<option value="2">管理员</option>
			  		</select>
			  </div>
			  
			  <div >
					<label for="groupId">用户分组：<em>*</em></label>
					<span id="groupContext">
						<select id="group" name="group.groupId" onchange='selectRole(this.value)'>
							<option value="-1">--请选择--</option>
						</select>
					</span>
			  </div>
			  
			  <div>
					<label for="roleId">用户角色：<em>*</em></label>
					<span id="roleContext">
						 <select id="role" name="role.roleId">
						 	<option value="-1">--请选择--</option>
						 </select>
					</span>
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