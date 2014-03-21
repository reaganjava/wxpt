<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<body>







	<!--修改密码窗口-->
	<div class="easyui-window" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>用户名</td>
						<td><input id="username" type="text" class="txt01" /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input id="password" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)" onclick="login()"> 确定</a> <a class="easyui-linkbutton"
					icon="icon-cancel" href="javascript:void(0)" onclick="cleanLogin()">清除</a>
			</div>
		</div>
	</div>
</body>
</html>