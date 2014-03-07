<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户查询</title>
		<%@ include file="/WEB-INF/views/include.jsp"%>
		<script type="text/javascript">
      function updateCheck(){
      	oldPwd = document.getElementById('oldPwd').value;
        if (isEmpty(oldPwd)){
          msgAlert('信息提示','请输入旧密码','warning',null);
          document.getElementById('oldPwd').focus();
          return false;
        }
      	
      
        newPwd = document.getElementById('password').value;
        if (isEmpty(newPwd)){
          msgAlert('信息提示','请设置新密码','warning',null);
          document.getElementById('password').focus();
          return false;
        }
        if (!isNumOrLetter(newPwd)){
          msgAlert('信息提示','用户密码只能由数字或字母或数字和字母组成','warning',null);
          document.getElementById('password').focus();
          return false;
        }
        confirmPwd = document.getElementById('confirmPwd').value;
        if (isEmpty(confirmPwd)){
          msgAlert('信息提示','请确认新密码','warning',null);
          document.getElementById('confirmPwd').focus();
          return false;
        }
        
        if (confirmPwd != newPwd){
          msgAlert('信息提示','两次密码不一致','warning',null);
          document.getElementById('confirmPwd').focus();
          return false;
        }
        return true;
      }
      function save(){
    	  if(updateCheck()){
          	  formSubmit('updateForm', null, null,true);
    	  }
      }
    </script>
	</head>
	<body>
		<form id="updateForm" name="updateForm" method="post" 
		action="<%=request.getContextPath()%>/member/doChangePwd.json">
			<table border="1" cellpadding="0" cellspacing="0" class="subjoin"
				width="100%">
					<tr>
					<th>
					  旧密码 <label style="color:red"><em>*</em></label>：
					</th>
					<td class="auto-style1">
						<strong> <input id="oldPwd" class="easyui-validatebox"
								required="true" name="oldPwd" type="password" /> </strong>
					</td>
				</tr>
				<tr>
					<th>
						新密码<label style="color:red"><em>*</em></label>：
					</th>
					<td class="auto-style1">
						<strong> <input id="password" class="easyui-validatebox"
								required="true" name="password" type="password" /> </strong>
					</td>
				</tr>
				<tr>
					<th>
						确认密码<label style="color:red"><em>*</em></label>：
					</th>
					<td class="auto-style1">
						<strong> <input id="confirmPwd"
								class="easyui-validatebox" required="true" name="confirmPwd"
								type="password" /> </strong>
					</td>
				</tr>
				<tr>
					<td colspan="2" height="40" style="height: 50px; width: 100%"
						class="auto-style2">
						<input class="submitbtn" type="submit" value="保存"
							onClick="save();return false;" />
						&nbsp;&nbsp;
						<input class="submitbtn" type="button" value="关闭"
							onClick="self.parent.closeCurrTab();" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>