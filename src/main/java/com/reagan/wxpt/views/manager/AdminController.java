package com.reagan.wxpt.views.manager;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.PageBean;
import com.reagan.util.components.Component;
import com.reagan.views.dto.ResultObject;
import com.reagan.views.dto.Tip;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.service.business.ICompanyService;
import com.reagan.wxpt.service.common.IAdminService;
import com.reagan.wxpt.service.common.IGroupService;
import com.reagan.wxpt.vo.business.CompanyVO;
import com.reagan.wxpt.vo.common.AdminVO;
import com.reagan.wxpt.vo.common.GroupVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends Component {
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private ICompanyService companyService;
	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, HttpServletRequest request) {
		Integer companyId = (int) request.getSession().getAttribute(SESSION_ADMIN_COMPANY_ID);
		if(companyId == 1) {
			CompanyVO companyVO = new CompanyVO();
			companyVO = companyService.viewCompanyList(companyVO);
			mav.addObject("COMPANY_LIST", companyVO.getCompanyList());
		} else {
			GroupVO groupVO = new GroupVO();
			groupVO.getGroup().setCompanyId(companyId);
			groupVO = groupService.viewGroupList(groupVO);
			mav.addObject("GROUP_LIST", groupVO.getGroupList());
		}
		mav.setViewName("admin/add");
		return mav;		
	}
	
	@RequestMapping(value = "add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav, AdminVO adminVO, HttpServletRequest request) {
		ResultObject<Object> result = new ResultObject<Object>();
		try {
			String adminName = (String) request.getSession().getAttribute(SESSION_ADMIN_NAME);
			adminVO.getAdmin().setCreatedate(new Date());
			adminVO.getAdmin().setCreatename(adminName);
			adminVO.getAdmin().setStatus(1);
			if(adminVO.getAdmin().getGroupId() == null) {
				adminVO.getAdmin().setGroupId(0);
			}
			adminService.addAdmin(adminVO);
			result = Tip.addSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			result = Tip.addFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "edit/{adminId}.html", method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mav,
			@PathVariable(value="adminId") int adminId,
			HttpServletRequest request) {
		Integer companyId = (int) request.getSession().getAttribute(SESSION_ADMIN_COMPANY_ID);
		
		AdminVO adminVO = new AdminVO();
		adminVO.getAdmin().setAdmid(adminId);
		adminVO = adminService.viewAdminDetail(adminVO);
	
		if(companyId == 1) {
			CompanyVO companyVO = new CompanyVO();
			companyVO = companyService.viewCompanyList(companyVO);
			mav.addObject("COMPANY_LIST", companyVO.getCompanyList());
		} else {
			GroupVO groupVO = new GroupVO();
			groupVO.getGroup().setCompanyId(companyId);
			groupVO = groupService.viewGroupList(groupVO);
			mav.addObject("GROUP_LIST", groupVO.getGroupList());
		}
		mav.addObject("ADMIN_EDIT_DETAIL", adminVO);
		mav.setViewName("admin/edit");
		return mav;
	}
	
	@RequestMapping(value = "edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, AdminVO adminVO) {
		ResultObject<Object> result = new ResultObject<Object>();
		if(adminService.modifiAdmin(adminVO)) {
			result = Tip.editSuccess();
		} else {
			result = Tip.editFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "editPassword.html", method = RequestMethod.GET)
	public ModelAndView editPassword(ModelAndView mav, HttpServletRequest request) {
		Integer adminId = (int) request.getSession().getAttribute(SESSION_ADMIN_ID);
		if(adminId != null) {
			mav.setViewName("admin/editPassword");
		} else {
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping(value = "editPassword.json", method = RequestMethod.POST)
	public ModelAndView editPassword(ModelAndView mav, AdminVO adminVO, HttpServletRequest request) {
		Integer adminId = (int) request.getSession().getAttribute(SESSION_ADMIN_ID);
		ResultObject<Object> result = new ResultObject<Object>();
		if(adminId != null) {
			adminVO.getAdmin().setAdmid(adminId);
			int code = adminService.modifiAdminPwd(adminVO);
			if(code == 1) {
				result = Tip.editSuccess();
			} else if(code == 0) {
				result = Tip.editFailure();
			} else {
				result = Tip.passwordError();
			}
		} else {
			result = Tip.loginOuttime();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	
	@RequestMapping(value = "list/{username}/{realname}/{status}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,
			@PathVariable(value="username") String username,  
			@PathVariable(value="realname") String realname,
			@PathVariable(value="status") int status,
			@PathVariable(value="pageNo") int pageNo,
			HttpServletRequest request) {
		AdminVO adminVO = new AdminVO();
		username = urlDecoder(username);
		if(!username.equals("all")) {
			adminVO.getAdmin().setUsername(username);
		}
		if(!realname.equals("all")) {
			adminVO.getAdmin().setRealname(realname);
		}
		adminVO.getAdmin().setStatus(status);
		adminVO.setPageNO(pageNo);
		adminVO.setPageRows(10);
		
		PageBean<CommonAdmin> pageBean = adminService.queryAdminList(adminVO);
		if(pageBean != null) {
			mav.addObject("PAGE_BEAN", pageBean);
		}
		mav.setViewName("admin/list");
		return mav;
	}
}
