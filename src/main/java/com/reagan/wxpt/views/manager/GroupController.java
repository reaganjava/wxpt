package com.reagan.wxpt.views.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.PageBean;
import com.reagan.util.components.Component;
import com.reagan.views.dto.ResultList;
import com.reagan.views.dto.ResultObject;
import com.reagan.views.dto.Tip;
import com.reagan.wxpt.pojo.common.CommonGroup;
import com.reagan.wxpt.service.common.IGroupService;
import com.reagan.wxpt.vo.common.GroupVO;

@Controller
@RequestMapping(value = "/group")
public class GroupController extends Component {

	@Autowired
	private IGroupService groupService;

	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav) {
		mav.setViewName("group/add");
		return mav;
	}
	
	@RequestMapping(value = "add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav, GroupVO groupVO, HttpServletRequest request) {
		ResultObject<Object> result = new ResultObject<Object>();
		try {
			String adminName = (String) request.getSession().getAttribute(SESSION_ADMIN_NAME);
			Integer companyId = (int) request.getSession().getAttribute(SESSION_ADMIN_COMPANY_ID);
			groupVO.getGroup().setCompanyId(companyId);
			groupVO.getGroup().setCreateDate(new Date());
			groupVO.getGroup().setCreateName(adminName);
			groupService.addGroup(groupVO);
			result = Tip.addSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			result = Tip.addFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "edit/{groupId}.html", method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mav, 
			@PathVariable(value="groupId") int groupId) {
		GroupVO groupVO = new GroupVO();
		groupVO.getGroup().setGroupId(groupId);
		groupVO = groupService.viewGroupDetail(groupVO);
		
		mav.addObject("GROUP_EDIT_DETAIL", groupVO);
		mav.setViewName("group/edit");
		return mav;
		
	}
	
	@RequestMapping(value = "edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, GroupVO groupVO) {
		ResultObject<Object> result = new ResultObject<Object>();
		if(groupService.modifiGroup(groupVO)) {
			result = Tip.editSuccess();
		} else {
			result = Tip.editFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "remove/{groupId}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, 
			@PathVariable(value="groupId") int groupId) {
		ResultObject<Object> result = new ResultObject<Object>();
		GroupVO groupVO = new GroupVO();
		groupVO.getGroup().setGroupId(groupId);
		if(groupService.removeGroup(groupVO)) {
			result = Tip.removeSuccess();
		} else {
			result = Tip.removeFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "ajaxList/{companyId}.json", method = RequestMethod.GET)
	public ModelAndView ajaxList(ModelAndView mav, 
			@PathVariable(value="companyId") int companyId) {
		ResultList<String> resultList = new ResultList<String>();
		GroupVO groupVO = new GroupVO();
		groupVO.getGroup().setCompanyId(companyId);
		groupVO = groupService.viewGroupList(groupVO);
		List<String> optionList = new ArrayList<String>();
		for(CommonGroup group : groupVO.getGroupList()) {
			String option = "<option value=\"" + group.getGroupId() + "\">" + group.getName() + "</option>";
			optionList.add(option);
		}
		resultList.setSuccess(true);
		resultList.setResultList(optionList);
		mav.addObject(JSONDATA, resultList);
		return mav;		
	}
	
	@RequestMapping(value = "list/{name}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, 
			@PathVariable(value="name") String name,  
			@PathVariable(value="pageNo") int pageNo,
			HttpServletRequest request) {
		GroupVO groupVO = new GroupVO();
		name = urlDecoder(name);
		if(!name.equals("all")) {
			groupVO.getGroup().setName(name);
		}
		Integer companyId = (int) request.getSession().getAttribute(SESSION_ADMIN_COMPANY_ID);
		if(companyId != null) {
			groupVO.getGroup().setCompanyId(companyId);
			groupVO.setPageNO(pageNo);
			groupVO.setPageRows(10);
			PageBean<CommonGroup> pageBean = groupService.queryGroupList(groupVO);
			if(pageBean != null) {
				mav.addObject("PAGE_BEAN", pageBean);
			}
			mav.setViewName("group/list");
		}
		return mav;
	}
}
