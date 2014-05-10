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
			action="${rootpath}attachment/upload.json" enctype="multipart/form-data">
			
			<fieldset>
				<legend> 上传附件 </legend>
				<input type="hidden" value=${UPLOAD_ID} name="id"/>
				<input type="hidden" value=${SRC_TYPE} name="srcType"/>
				<div>
					<label for="file"> 图片(支持 jpg/png)：<em>*</em>
					</label> <input name="files" class="easyui-validatebox" type="file"
						/>
				</div>
				<div>
					<label for="file"> 图片(支持 jpg/png)：<em>*</em>
					</label> <input name="files" class="easyui-validatebox" type="file"
						/>
				</div>
				<div>
					<label for="file"> 图片(支持 jpg/png)：<em>*</em>
					</label> <input name="files" class="easyui-validatebox" type="file"
						/>
				</div>
				<div>
					<label for="file"> 图片(支持 jpg/png)：<em>*</em>
					</label> <input name="files" class="easyui-validatebox" type="file"
						/>
				</div>
				<div>
					<label for="file"> 图片(支持 jpg/png)：<em>*</em>
					</label> <input name="files" class="easyui-validatebox" type="file"
						/>
				</div>
				
				
			</fieldset>
				<div class="buttonrow">
					<input class="submitbtn" type="button" value="上传"
						onclick="doSave();" />
					&nbsp;&nbsp;
					<input class="submitbtn" type="button" value="关闭"
						onClick="self.parent.closeCurrTab();" />
				</div>
			</form>
		</div>
	</body>
</html>