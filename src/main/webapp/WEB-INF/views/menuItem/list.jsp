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
			var title = $("#title").attr("value");
			var url = $("#url").attr("value");
			var status = $("#status").attr("value");
			if(title == '') {
				title = 'all';
			}
			if(url == '') {
				url = 'all';
			}
			
			
			var url = "${rootpath}menuItem/list/" + title + "/" + url + "/" + status + "/1.html";
			location.href=url;
		}
    </script>
</head>
<body>
	<div class="tools">
		<span class="date_btn"><i><input type="button" value="新增菜单"
						onclick="self.parent.addTab('新增菜单','${rootpath}menuItem/add.html','icon-add')" />
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
					<td width="10%" align="right" class="querytd">菜单标题：</td>
					<td width="15%" class="querytd">
					<input id="title" name="title"/>
					</td>
					<td width="10%" align="right" class="querytd">菜单URL：</td>
					<td width="15%" class="querytd">
					<input id="url" name="url"/>
					</td>
					<td width="10%" align="right" class="querytd">菜单状态：</td>
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
					<th align="middle">菜单编号</th>
					<th align="middle">菜单标题</th>
					<th align="middle">菜单链接</th>
					<th align="middle">创建时间</th>
					<th align="middle">创建人</th>
					<th align="middle">菜单状态</th>
					<th align="middle">编辑</th>
				</tr>
			</thead>
			<tbody>
				
					<input type="hidden" name="pageNo" value="${PAGE_BEAN.currentPage}"/>
					<c:forEach items="${PAGE_BEAN.dataList}" var="menuItem">
                            <tr>
                                <td height="22" align="center" valign="middle">
                                	${menuItem.menuId }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${menuItem.title }
                                </td>
                                 <td height="22" align="center" valign="middle">
                                	${menuItem.url }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<fmt:formatDate value="${menuItem.createDate}" />
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${menuItem.createName }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${menuItem.status }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<a href="#" onClick="self.parent.addTab('修改菜单信息','${rootpath}menuItem/edit/${menuItem.menuId}.html','icon-add')">修改</a>
                                	<a href="#" onClick="deleteFormSubmit('${rootpath}menuItem/remove/${menuItem.menuId}.json')">删除</a>
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