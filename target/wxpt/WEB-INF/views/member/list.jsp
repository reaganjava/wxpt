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
    </script>
</head>
<body>
	<div class="tools">
		<span class="date_btn"><i><input type="button" value="新增用户"
						onclick="self.parent.addTab('新增用户','<%=request.getContextPath()%>/member/edit?path=save','icon-add')" />
			</i></span>
		<span class="date_btn"><i> <input type="button"
				value="条件查询" id="showSearchContainer" />
		</i> </span> <span class="date_btn"><i> <input type="button"
				value="刷新" onClick="refreshList();" />
		</i> </span> 
	</div>
	<div class="searchContainer" id="searchContainer">
		<form name="queryForm" id="queryForm" method="post"
			action="<%=request.getContextPath()%>/member/findUser">
			 <input type="hidden" name="ifExport" id="ifExport" />
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>

					<td width="10%" align="right" class="querytd">用户名：</td>
					<td width="15%" class="querytd"><input name="userName"/></td>
					<td width="10%" align="right" class="querytd">手机号：</td>
					<td width="15%" class="querytd"><input name="mobile"/></td>
					<td width="10%" align="right" class="querytd">手机状态：</td>
					<td width="15%" class="querytd">
						<select>
							<option>已验证</option>
							<option>未验证</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" align="right" class="querytd">注册日期：</td>
					<td width="28%" class="querytd">
						<input type="text" name="regDateStart" id="regDateStart"
								class="Wdate" onClick="WdatePicker({dateFmt:'yyyyMMdd'})"
								 />
							至
							<input type="text" name="regDateEnd" id="regDateEnd"
								class="Wdate" onClick="WdatePicker( {dateFmt : 'yyyyMMdd'})" />
	
					</td>
				</tr>
				<tr>
					<td colspan="8" class="querybt"><input type="submit"
						class="submitbtn" value="查询" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="scrollDiv" class="showScrollbarX">
		<table id="scrollTab" cellpadding="0" cellspacing="0" class="list"
			width="100%">
			<thead>
				<tr>
					<th align="middle">选择</th>
					<th align="middle">用户编号</th>
					<th align="middle">用户名</th>
					<th align="middle">手机号</th>
					<th align="middle">手机状态</th>
					<th align="middle">邮箱地址</th>
					<th align="middle">邮箱状态</th>
					<th align="middle">注册IP</th>
					<th align="middle">注册日期</th>
					<th align="middle">注册来源</th>
					<th align="middle">用户状态</th>
					<th align="middle">用户类型</th>
					<th align="middle">积分</th>
					<th align="middle">等级</th>
					<th align="middle">用户分组</th>
					<th align="middle">用户角色</th>
					<th align="middle">编辑</th>
				</tr>
			</thead>
			<tbody>
				<form id="deleteForm" name="deleteForm" method="post" action="<%=request.getContextPath()%>/member/delete.json">
					<input type="hidden" name="pageNum" value="${jsonData.currentPage}"/>
					<c:forEach items="${jsonData.dataList}" var="member">
                            <tr>
                            	 <td align="center" valign="middle">
                  					<input type="checkbox" name="listCheckbox" value="${member.uid}" />
                				 </td>
                                <td height="22" align="center" valign="middle">
                                	${member.uid }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.userName }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.mobile }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.mobileStatus }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.email }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.emailStatus }
                                </td>
                                 <td height="22" align="center" valign="middle">
                                 	${member.regIP }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<fmt:formatDate value="${member.regDate }"/>
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.regSrc }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.status }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.type }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.integral }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.level }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.group.groupName }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	${member.role.roleName }
                                </td>
                                <td height="22" align="center" valign="middle">
                                	<a href="#" onClick="self.parent.addTab('修改用户信息','<%=request.getContextPath()%>/member/edit?path=edit&uid=${member.uid}','icon-add')">修改</a>
                                </td>
                            </tr>
                        </c:forEach>
				</form>
			</tbody>
		</table>
	</div>
	<p>&nbsp;</p>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4">			
					<div align="center" >
							<a class="button_link" href="/member/findUser?pageNum=0" id="firstPage" title="First Page">&laquo; 首页</a>
							<a class="button_link" href="/member/findUser?pageNum=${jsonData.currentPage-1}" id="previousPage" title="Previous Page">&laquo; 前一页</a> 
							
							第 ${jsonData.currentPage} 页
							<a class="button_link" href="/member/findUser?pageNum=${jsonData.currentPage+1}" id="nextPage" title="Next Page"><c:if test="${jsonData.currentPage+1<=jsonData.pageCount}">后一页 &raquo;</c:if></a>
							<a class="button_link" href="/member/findUser?pageNum=${jsonData.pageCount}" id="endPage" title="Last Page">末页 &raquo;</a>
							共${jsonData.recordCount} 记录
							共${jsonData.pageCount}页
					</div>
				</td>
		</tr>
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