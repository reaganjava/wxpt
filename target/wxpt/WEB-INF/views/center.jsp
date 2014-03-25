<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>POSP后台管理平台</title>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/man/js/jquery/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/man/js/jquery/themes/icon.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/man/css/default.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/man/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/man/js/jquery/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/man/js/jquery/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/man/js/easyui/outlook2.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/man/js/easyui/dialog.js"></script>
	</head>
	<body class="easyui-layout">
		<div region="north" split="true"
			style="height: 30px; background: #D2E0F2;">
			<span style="float: right; padding-right: 20px;" class="footer">欢迎，${user.userName}&nbsp;
      <a href="javascript:void(0)"
				onclick="addTab('修改密码','<%=request.getContextPath()%>/system/changePwd', '');return false;">修改密码</a>&nbsp;
				<c:choose>
					<c:when test="${ctx.user.USER_LOGIN_OTHER=='loginOther'}">
						<a href="javascript:void(0)" onclick="window.opener=null;window.close();">安全退出</a> 
					</c:when>
					<c:otherwise>
						<a href="javascript:void(0)" onclick='msgConfirm("温馨提示","是否确认退出系统?", function confirmExit(b){if (b){document.location.href="<%=request.getContextPath()%>/system/loginOut";}});return false';
						id="loginOut">安全退出</a>
					</c:otherwise>
				</c:choose> </span>
			<span style="padding-left: 10px;" class="footer">POSP后台管理平台</span>
		</div>
		<div region="south" split="true"
			style="height: 30px; background: #D2E0F2;">
			<div class="footer">
				(c)2005-2014版权所有 深圳市泰久信息系统有限公司
			</div>
		</div>

		<div region="west" split="true" title="系统菜单" style="width: 180px;"
			id="west">
			<div class="easyui-accordion" border="false" style="overflow: auto;">
				<c:forEach items="${menu.menus}" var="level1Menu">
					<div title="${level1Menu.menuName}" icon="icon-sys" style="height:50px;overflow: auto;">
						<ul >
							<c:if test="${fn:length(level1Menu.menus)>0}">
								<c:forEach items="${level1Menu.menus}" var="level2Menu">
									<li>
										<div>
											<a href="javascript:void(0)"
												onclick="addTab('${level2Menu.menuName}','<%=request.getContextPath()%>${level2Menu.menuUrl}', '');return false;">${level2Menu.menuName}</a>
										</div>
									</li>
								</c:forEach>
							</c:if>
							
						
						</ul>
					</div>
				</c:forEach>

			</div>
		</div>

		<div id="mainPanle" region="center" 
			style="background: #eee; overflow-y: hidden;">
			<div id="tabs" class="easyui-tabs" fit="true" border="false"  >
			</div>
		</div>

		<div id="mm" class="easyui-menu" style="width: 150px;" >
			<div id="mm-tabupdate">
				刷新
			</div>
			<div class="menu-sep"></div>
			<div id="mm-tabclose">
				关闭
			</div>
			<div id="mm-tabcloseall">
				全部关闭
			</div>
			<div id="mm-tabcloseother">
				除此之外全部关闭
			</div>
			<div class="menu-sep"></div>
			<div id="mm-tabcloseright">
				当前页右侧全部关闭
			</div>
			<div id="mm-tabcloseleft">
				当前页左侧全部关闭
			</div>
			<div class="menu-sep"></div>
			<div id="mm-exit">
				退出
			</div>
		</div>

	</body>
</html>
<script type="text/javascript">
function exitDialog(){
  msgConfirm("温馨提示","是否确认退出系统?",confirmExit);  
}

function confirmExit(b){
  if (b){
     document.location.href="<%=request.getContextPath()%>/manager/index.do?tradeId=manLogout";
  }
}

</script>
