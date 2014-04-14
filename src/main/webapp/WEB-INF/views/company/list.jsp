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
			if(name == '') {
				name = 'all';
			}
			var status = $("#status").attr("value");
			var url = "${rootpath}company/list/"+ name + "/" + status + "/1.html";
			location.href=url;
		}
    </script>
</head>
<body>
	<div class="tools">
		<span class="date_btn"><i><input type="button" value="新增企业"
						onclick="self.parent.addTab('新增企业','${rootpath}company/add.html?flag=true','icon-add')" />
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
					<td width="10%" align="right" class="querytd">手机号：</td>
					<td width="15%" class="querytd"><input name="mobile"/></td>
					<td width="10%" align="right" class="querytd">企业状态：</td>
					<td width="15%" class="querytd">
						<select id="status" name="status">
							<option value="1">正常</option>
							<option value="0">停用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" align="right" class="querytd">注册日期：</td>
					<td width="28%" class="querytd">
						<input type="text" name="beginTime" id="beginTime"
								class="Wdate" onClick="WdatePicker({dateFmt:'yyyyMMdd'})"
								 />
							至
							<input type="text" name="endTime" id="endTime"
								class="Wdate" onClick="WdatePicker( {dateFmt : 'yyyyMMdd'})" />
	
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
					<th align="middle">选择</th>
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
				<form id="deleteForm" name="deleteForm" method="post" action="${rootpath}/company/list.html">
					<input type="hidden" name="pageNo" value="${PAGE_BEAN.currentPage}"/>
					<c:forEach items="${PAGE_BEAN.dataList}" var="company">
                            <tr>
                            	 <td align="center" valign="middle">
                  					<input type="checkbox" name="listCheckbox" value="${user.uid}" />
                				 </td>
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
                                </td>
                            </tr>
                        </c:forEach>
				</form>
			</tbody>
		</table>
	</div>
	<%@ include file="/WEB-INF/views/page.jsp"%>
	<table>
		<tr>
			<td width="20%">
	          <input type="checkbox" onclick="checkAll()" id="headerListCheckbox" />
	         	 全选 &nbsp;
	          <input type="submit" class="delsubmit" value="删除" onClick="deleteFormSubmit();return false;" />
	          &nbsp;
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