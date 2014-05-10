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
			var settleType = $("#settleType").attr("value");
			var serviceType = $("#serviceType").attr("value");
			var categoryId = $("#category").attr("value");
			var salesName = $("#salesName").attr("value");
			var status = $("#status").attr("value");
			if(name == '') {
				name = 'all';
			}
			if(salesName == '') {
				salesName = 'all';
			}
			
			var url = "${rootpath}company/list/" + name + "/" + settleType + "/" + serviceType + "/" + categoryId + "/" + salesName + "/"  + status + "/1.html";
			location.href=url;
		}
    </script>
</head>
<body>
	<div class="tools">
		<span class="date_btn"><i><input type="button" value="新增企业"
						onclick="self.parent.addTab('新增企业','${rootpath}company/add.html','icon-add')" />
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

					<td width="10%" align="right" class="querytd">企业名：</td>
					<td width="15%" class="querytd">
					<input id="name" name="name"/>
					</td>
					<td width="10%" align="right" class="querytd">业务员：</td>
					<td width="15%" class="querytd">
					<input id="salesName" name="salesName"/>
					</td>
					
					<td width="10%" align="right" class="querytd">企业状态：</td>
					<td width="15%" class="querytd">
						<select id="status" name="status">
							<option value="1">正常</option>
							<option value="0">停用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" align="right" class="querytd">服务类型：</td>
					<td width="15%" class="querytd">
						<select id="serviceType" name="serviceType">
							<option value="0">全部</option>
							<option value="1">贩卖</option>
							<option value="2">咨询</option>
							<option value="3">广告</option>
			  			</select>
					</td>
					<td width="10%" align="right" class="querytd">服务类型：</td>
					<td width="15%" class="querytd">
						<select id="settleType" name="settleType">
							<option value="0">全部</option>
							<option value="1">周结</option>
							<option value="2">月结</option>
							<option value="3">季度结</option>
							<option value="4">半年结</option>
							<option value="5">年结</option>
						</select>
					</td>
					<td width="10%" align="right" class="querytd">服务类型：</td>
					<td width="15%" class="querytd">
						<select id="category" name="categoryId">
							<option value="0">全部</option>
						 	<c:forEach var="category" items="${MAIN_CATEGORY}">
						 		<option value="${category.cateid }">${category.name }</option>
						 	</c:forEach>
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
					<th align="middle">企业编号</th>
					<th align="middle">企业名</th>
					<th align="middle">联系人</th>
					<th align="middle">结算方式</th>
					<th align="middle">服务方式</th>
					<th align="middle">注册日期</th>
					<th align="middle">企业状态</th>
					<th align="middle">业务员</th>
					<th align="middle">创建人</th>
					<th align="middle">编辑</th>
				</tr>
			</thead>
			<tbody>
				
					<input type="hidden" name="pageNo" value="${PAGE_BEAN.currentPage}"/>
					<c:forEach items="${PAGE_BEAN.dataList}" var="company">
                            <tr>
                                <td height="22" align="center" valign="middle">
                                	${company.coid }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${company.name }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${company.contact }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${company.settleType }
                                </td>
                                 <td height="22" align="center" valign="middle">
                                 	${company.serviceType }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<fmt:formatDate value="${company.createDate }"/>
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${company.status }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${company.salesName }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${company.createName }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<a href="#" onClick="self.parent.addTab('修改企业信息','${rootpath}company/edit/${company.coid}.html','icon-add')">修改</a>
                                	<a href="#" onClick="deleteFormSubmit('${rootpath}company/remove/${company.coid}.json')">删除</a>
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