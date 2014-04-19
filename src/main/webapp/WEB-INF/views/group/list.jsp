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
			var name = $("#name").attr("value");
			var companyId = $("companyId").attr("value");
			if(name == '') {
				name = 'all';
			}
			
			
			var url = "${rootpath}group/list/" + name + "/1.html";
			location.href=url;
		}
    </script>
</head>
<body>
	<div class="tools">
		<span class="date_btn"><i><input type="button" value="新增分组"
						onclick="self.parent.addTab('新增分组','${rootpath}group/add.html','icon-add')" />
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

					<td width="10%" align="right" class="querytd">分组名：</td>
					<td width="15%" class="querytd">
					<input id="name" name="name"/>
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
					<th align="middle">分组编号</th>
					<th align="middle">分组名</th>
					<th align="middle">创建日期</th>
					<th align="middle">创建人</th>
					<th align="middle">编辑</th>
				</tr>
			</thead>
			<tbody>
				
					<input type="hidden" name="pageNo" value="${PAGE_BEAN.currentPage}"/>
					<c:forEach items="${PAGE_BEAN.dataList}" var="group">
                            <tr>
                                <td height="22" align="center" valign="middle">
                                	${group.groupId }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${group.name }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<fmt:formatDate value="${group.createDate}" />
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${group.createName }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<a href="#" onClick="self.parent.addTab('修改分组信息','${rootpath}group/edit/${group.groupId}.html','icon-add')">修改</a>
                                	<a href="#" onClick="deleteFormSubmit('${rootpath}group/remove/${group.groupId}.json')">删除</a>
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