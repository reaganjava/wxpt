package com.reagan.wxpt.views.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.components.Component;
import com.reagan.wxpt.pojo.common.CommonMenuItem;
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
	
	public ModelAndView center(ModelAndView mav,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String adminID = (String) session.getAttribute(Component.SESSION_ADMIN_ID);
		if(adminID == null || adminID == ""){
			mav.setViewName("index");
		}else{
			mav.setViewName("center");
		}
		return mav;
	}
	
	@RequestMapping(value = "center.html", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav, String username, String password, HttpServletRequest request, HttpServletResponse response) {
		AdminVO adminVO = new AdminVO();
		adminVO.getAdmin().setUsername(username);
		adminVO.getAdmin().setPassword(password);
		adminVO = adminService.verifiAdmin(adminVO);
		if(adminVO.getAdmin() != null) {
			request.getSession().setAttribute(Component.SESSION_ADMIN_ID, adminVO.getAdmin().getAdmid().toString());
			request.getSession().setAttribute(Component.SESSION_ADMIN_NAME, adminVO.getAdmin().getUsername());
			request.getSession().setAttribute(Component.SESSION_ADMIN_MENU_ITEM_LIST, adminVO.getMenuItemList());
		}
		return center(mav,request,response);
	}
	
	@RequestMapping(value = "loginOut.html", method = RequestMethod.GET)
	public ModelAndView loginOut(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute(Component.SESSION_ADMIN_ID);
		request.getSession().removeAttribute(Component.SESSION_ADMIN_NAME);
		request.getSession().removeAttribute(Component.SESSION_ADMIN_MENU_ITEM_LIST);
		return center(mav,request, response);
	}

}
