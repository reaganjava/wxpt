package com.reagan.wxpt.views.manager;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.components.Component;
import com.reagan.views.dto.ResultObject;
import com.reagan.wxpt.service.business.IShopService;
import com.reagan.wxpt.vo.business.ShopVO;

@Controller
@RequestMapping(value = "/shop")
public class ShopController extends Component {

	private IShopService shopService;
	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("shop/add");
		return mav;
	}
	
	@RequestMapping(value = "add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav, ShopVO shopVO, HttpServletRequest request) {
		ResultObject<Object> result = new ResultObject<Object>();
		try {
		String adminName = (String) request.getSession().getAttribute(SESSION_ADMIN_NAME);
		Integer companyId = (int) request.getSession().getAttribute(SESSION_ADMIN_COMPANY_ID);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
