<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/WEB-INF/views/include.jsp"%>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#search").click(function(){
				queryClick();
			}); 
			$("#refresh").click(function(){
				queryClick();
			}); 
		});
		function queryClick() {
			var username = $("#username").attr("value");
			var realname = $("#realname").attr("value");
			var status = $("#status").attr("value");
			if(username == '') {
				username = 'all';
			}
			if(realname == '') {
				realname = 'all';
			}
			
			var url = "${rootpath}admin/list/" + username + "/" + realname + "/"  + status + "/1.html";
			location.href=url;
		}
    </script>
</head>
<body>
	<div class="tools">
		<span class="date_btn"><i><input type="button" value="新增管理员"
						onclick="self.parent.addTab('新增管理员','${rootpath}admin/add.html','icon-add')" />
			</i></span>
		<span class="date_btn"><i> <input type="button"
				value="条件查询" id="showSearchContainer" />
		</i> </span> <span class="date_btn"><i> <input type="button"
				value="刷新" id ="refresh" />
		</i> </span> 
	</div>
	<div class="searchContainer" id="searchContainer">
			<input type="hidden" name="ifExport" id="ifExport" />
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>

					<td width="10%" align="right" class="querytd">管理员名：</td>
					<td width="15%" class="querytd">
					<input id="username" name="username"/>
					</td>
					<td width="10%" align="right" class="querytd">真实姓名：</td>
					<td width="15%" class="querytd">
					<input id="realname" name="realname"/>
					</td>
					
					<td width="10%" align="right" class="querytd">管理员状态：</td>
					<td width="15%" class="querytd">
						<select id="status" name="status">
							<option value="1">正常</option>
							<option value="0">停用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="8" class="querybt">
					<input type="submit" class="submitbtn" value="查询" id ="search"/>
					</td>
				</tr>
			</table>
		
	</div>
	<div id="scrollDiv" class="showScrollbarX">
		<table id="scrollTab" cellpadding="0" cellspacing="0" class="list"
			width="100%">
			<thead>
				<tr>
					<th align="middle">管理员编号</th>
					<th align="middle">管理员名</th>
					<th align="middle">真实姓名</th>
					<th align="middle">邮箱</th>
					<th align="middle">电话号码</th>
					<th align="middle">手机号码</th>
					<th align="middle">创建时间</th>
					<th align="middle">创建人</th>
					<th align="middle">状态</th>
					<th align="middle">编辑</th>
				</tr>
			</thead>
			<tbody>
				
					<input type="hidden" name="pageNo" value="${PAGE_BEAN.currentPage}"/>
					<c:forEach items="${PAGE_BEAN.dataList}" var="admin">
                            <tr>
                                <td height="22" align="center" valign="middle">
                                	${admin.admid }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${admin.username }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${admin.realname }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${admin.email }
                                </td>
                                 <td height="22" align="center" valign="middle">
                                 	${admin.tel }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${admin.mobile }
                                </td>
                                 <td height="22" align="center" valign="middle">
                                	<fmt:formatDate value="${admin.createdate }"/>
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${admin.createname }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${admin.status }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<a href="#" onClick="self.parent.addTab('修改管理员信息','${rootpath}admin/edit/${admin.admid}.html','icon-add')">修改</a>
                                	<a href="#" onClick="deleteFormSubmit('${rootpath}admin/remove/${admin.admid}.json')">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
				
			</tbody>
		</table>
	</div>
	<%@ include file="/WEB-INF/views/page.jsp"%>
	<table>
		<tr>
			<td width="20%">
        	</td>
			<td width="17">&nbsp;</td>
			<td width="80%" align="center">
				<ul>
				</ul>
			</td>
	 </tr>
	</table>
</body>
</html>