<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<p>&nbsp;</p>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="4">			
					<div align="center" >
							<a class="button_link" href="${pages.url}?pageNo=1" id="firstPage" title="First Page">&laquo; 首页</a>
							<a class="button_link" href="${pages.url}?pageNo=${pages.pageNo-1<1?1:pages.pageNo-1}" id="previousPage" title="Previous Page">&laquo; 前一页</a> 
							
							第 ${pages.pageNo} 页
							<a class="button_link" href="${pages.url}?pageNo=${pages.pageNo+1}" id="nextPage" title="Next Page"><c:if test="${pages.pageNo<pages.totalPage}">后一页 &raquo;</c:if></a>
							<a class="button_link" href="${pages.url}?pageNo=${pages.totalPage==0?1:pages.totalPage}" id="endPage" title="Last Page">末页 &raquo;</a>
							共${pages.totalRecord} 记录
							共${pages.totalPage}页
					</div>
				</td>
		</tr>
	</table>