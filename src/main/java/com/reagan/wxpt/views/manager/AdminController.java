package com.reagan.wxpt.views.manager;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.components.Component;
import com.reagan.wxpt.service.common.IAdminService;
import com.reagan.wxpt.vo.common.AdminVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends Component {
	
	@Autowired
	IAdminService adminService;
	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public void add() {
		AdminVO adminVO = new AdminVO();
		adminVO.getAdmin().setUsername("kokomi");
		adminVO.getAdmin().setPassword("123456");
		adminVO.getAdmin().setCompanyId(1);
		adminVO.getAdmin().setGroupId(1);
		adminVO.getAdmin().setRealname("Reaganjava");
		adminVO.getAdmin().setCreatedate(new Date());
		adminVO.getAdmin().setCreatename("admin");
		adminVO.getAdmin().setEmail("reaganjava@gmail.com");
		adminVO.getAdmin().setMobile("13590325680");
		adminVO.getAdmin().setTel("62306306");
		adminVO.getAdmin().setStatus(0);
		adminService.addAdmin(adminVO);
		
	}
	
	@RequestMapping(value = "modifi.html", method = RequestMethod.GET)
	public void modifi() {
		
	}
	
	@RequestMapping(value = "modifiPwd.html", method = RequestMethod.GET)
	public void modifiPassword() {
		
	}
	
	@RequestMapping(value = "/detail/{adminId}.html", method = RequestMethod.GET)
	public ModelAndView viewDetail(ModelAndView mav, @PathVariable int adminId) {
		AdminVO adminVO = new AdminVO();
		adminVO.getAdmin().setAdmid(adminId);
		adminVO = adminService.viewAdminDetail(adminVO);
		mav.addObject("ADMIN_DETAIL", adminVO);
		mav.setViewName("detail");
		System.out.println(adminVO.getGroup().getName());
		return mav;
	}
	
	@RequestMapping(value = "suspend.html", method = RequestMethod.GET)
	public void suspend() {
		
	}
	
	@RequestMapping(value = "list.html", method = RequestMethod.GET)
	public ModelAndView viewAdminList(ModelAndView mav) {
		return mav;
	}
}
