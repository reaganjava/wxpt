package com.reagan.wxpt.views.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.CookieManager;
import com.reagan.util.components.Component;
import com.reagan.wxpt.service.common.IAdminService;
import com.reagan.wxpt.vo.common.AdminVO;

@Controller
@RequestMapping(value = "/manager")
public class IndexController extends Component {
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav ,HttpServletRequest request,HttpServletResponse response){
		return center(mav,request,response);
	}
	
	@RequestMapping(value="center")
	public ModelAndView center(ModelAndView mav,HttpServletRequest request,HttpServletResponse response){
		String uid = cookieManager.readCookie("uid", request);
		if(uid ==  null || uid ==""){
			mav.setViewName("login");
		}else{
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping(value = "login.html", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav, String username, String password, HttpServletRequest request, HttpServletResponse response) {
		AdminVO adminVO = new AdminVO();
		adminVO.getAdmin().setUsername(username);
		adminVO.getAdmin().setPassword(password);
		adminVO = adminService.verifiAdmin(adminVO);
		if(adminVO.getAdmin() != null) {
			cookieManager.writeCookie("uid", adminVO.getAdmin().getAdmid() + "", CookieManager.WEEK, response);
		}
		return center(mav, request, response);
	}

}
