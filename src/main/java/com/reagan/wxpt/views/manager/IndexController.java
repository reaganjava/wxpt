package com.reagan.wxpt.views.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.components.Component;

public class IndexController extends Component {
	
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv ,HttpServletRequest request,HttpServletResponse response){
		return center(mv,request,response);
	}
	
	@RequestMapping(value="center")
	public ModelAndView center(ModelAndView mav,HttpServletRequest request,HttpServletResponse response){
		String uid = cookieManager.readCookie("uid", request);
		if(uid ==  null || uid ==""){
			mav.setViewName("signIn");
		}else{
			mav.setViewName("index");
		}
		return mav;
	}

}
