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
			var categoryId = $("#category").attr("value");
			var status = $("#status").attr("value");
			var url = "${rootpath}company/content/list/" + categoryId + "/" + status + "/1.html";
			location.href=url;
		}
		
		function checkFormSubmit(url) {
			checkUrl = url;
			msgConfirm("审核记录", "您确定要审核选中的记录吗？", doCheck);
		}

		/**
		 * msgConfirm确认信息框回调删除操作
		 * @param b 回调参数，true:选择确认 false：选择取消
		 * @return
		 */
		function doCheck(b){
			if(!b) {
				return;
			}
			$.ajax({
		        type: "GET",
		        url: checkUrl,
		        dataType: "json",
		        success: function(data){
		        	if(data != null) {
		        		msgAlert('消息提示',data.message,'info',null);
		        	} else {
		        		msgAlert('消息提示',"操作失败！ SESSION已过期，请重新登录！",'error',null);
		        	}
		        }
		    });
		}
    </script>
</head>
<body>
	<div class="tools">
		
		<span class="date_btn"><i> <input type="button"
				value="条件查询" id="showSearchContainer" />
		</i> </span> <span class="date_btn"><i> <input type="button"
				value="刷新" id ="refresh" />
		</i> </span> 
	</div>
	<div class="searchContainer" id="searchContainer">
			<input type="hidden" name="ifExport" id="ifExport" />
			<table width="100%" cellpadding="0" cellspacing="0">
				<td width="10%" align="right" class="querytd">企业状态：</td>
					<td width="15%" class="querytd">
						<select id="status" name="status">
							<option value="1">正常</option>
							<option value="2">待审核</option>
							<option value="0">停用</option>
						</select>
					</td>
				<tr>
					<td width="10%" align="right" class="querytd">选择公司：</td>
					<td width="15%" class="querytd">
						<select id="category" name="categoryId">
							<option value="0">全部</option>
						 	<c:forEach var="category" items="${COMPANY_LIST}">
						 		<option value="${category.coid }">${category.name }</option>
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
					<th align="middle">标题</th>
					<th align="middle">简介</th>
					<th align="middle">内容</th>
					<th align="middle">简介图片</th>
					<th align="middle">状态</th>
					<th align="middle">编辑</th>
				</tr>
			</thead>
			<tbody>
				
					<input type="hidden" name="pageNo" value="${PAGE_BEAN.currentPage}"/>
					<c:forEach items="${PAGE_BEAN.dataList}" var="companyContent">
                            <tr>
                                <td height="22" align="center" valign="middle">
                                	${companyContent.coid }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${companyContent.title }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${companyContent.description }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<a href="${companyContent.url}">内容</a>
                                </td>
                                 <td height="22" align="center" valign="middle">
                                 	<img width="60px" height="60px" src="${companyContent.frontConverPic}"/>
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${companyContent.status }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<c:if test="companyContent.status==2">
                                	<a href="#" onClick="checkFormSubmit('${rootpath}company/content/check/${companyContent.coid}.json')">审核</a>
                                	</c:if>
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