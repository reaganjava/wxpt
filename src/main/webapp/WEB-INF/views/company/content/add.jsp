<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业管理</title>
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
	<div>
		<form id="updateForm" name="updateForm" method="post"
			action="${rootpath}company/content/add.json">
			
			<fieldset>
				<legend> 企业页面管理 </legend>
				<div>
					<label for="title"> 封面标题：<em>*</em>
					</label> </br>
					<input  id="title" name="companyContent.title" class="easyui-validatebox"
						required="true" size="30"/>
				</div>
				<div>
					<label for="pictures"> 封面标题：<em>*</em>
					</label> </br>
					<c:forEach items="${ATTACHMENT_LIST}" var="attachment">
					<div>
                   	  <table width="463" border="1">
  						<tr>
    					<td width="92" rowspan="2"><img alt="" src="${attachment.path}" width="60px" height="60px"/></td>
   						<td width="355">${attachment.path}</td>
                        </tr>
                          <tr>
                            <td><label for="frontConverPic"> 设置封面：<em>*</em><input name="companyContent.frontConverPic" type="radio" value="${attachment.path}" /></label></td>
                          </tr>
                        </table>
					</div>
					</c:forEach>
				</div>
				
				<div>
					<label for="description"> 封面简介：<em>*</em>
					</label> </br>
					<textarea rows="10" cols="80" id="description" name="companyContent.description" class="easyui-validatebox"
						></textarea>
				</div>
				
				<div>
					<label for="content"> 详细内容：<em>*</em>
					</label> </br>
					<textarea rows="15" cols="80" id="content" name="companyContent.content"  
						 ></textarea>
				</div>
				<ckeditor:replace replace="content" basePath="${rootpath}ckeditor/" />
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