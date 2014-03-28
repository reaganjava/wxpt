package com.reagan.wxpt.views.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.PageBean;
import com.reagan.util.components.Component;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.service.business.ICompanyService;
import com.reagan.wxpt.vo.business.CompanyVO;

@Controller
@RequestMapping(value = "/compnay")
public class CompanyController extends Component {
	
	@Autowired
	private ICompanyService companyService;
	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav) {
		mav.setViewName("add");
		return mav;
	}
	
	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav, CompanyVO companyVO, HttpServletRequest request) {
		try {
			companyService.addCompany(companyVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "list/{name}/{status}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, @PathVariable String name, @PathVariable int status) {
		CompanyVO companyVO = new CompanyVO();
		if(name != "all") {
			companyVO.getCompany().setName(name);
		}
		companyVO.getCompany().setStatus(status);
		PageBean<BusinessCompany> pageBean = companyService.queryCompanyList(companyVO);
		if(pageBean != null) {
			mav.addObject("PAGE_BEAN", pageBean);
		}
		mav.setViewName("company/list");
		return mav;
	}

}
