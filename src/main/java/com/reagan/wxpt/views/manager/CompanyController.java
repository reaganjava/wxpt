package com.reagan.wxpt.views.manager;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.util.PageBean;
import com.reagan.util.components.Component;
import com.reagan.views.dto.ResultObject;
import com.reagan.views.dto.Tip;
import com.reagan.wxpt.pojo.business.BusinessCompany;
import com.reagan.wxpt.service.business.ICompanyService;
import com.reagan.wxpt.service.system.ICategoryService;
import com.reagan.wxpt.vo.business.CompanyVO;
import com.reagan.wxpt.vo.system.CategoryVO;

@Controller
@RequestMapping(value = "/company")
public class CompanyController extends Component {
	
	@Autowired
	private ICompanyService companyService;

	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav) {
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.getCategory().setCategoryId(0);
		categoryVO = categoryService.viewCategoryList(categoryVO);
		mav.addObject("MAIN_CATEGORY", categoryVO.getCategoryList());
		mav.setViewName("company/add");
		return mav;
	}
	
	@RequestMapping(value = "add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav, CompanyVO companyVO, HttpServletRequest request) {
		ResultObject<Object> result = new ResultObject<Object>();
		try {
			String adminName = (String) request.getSession().getAttribute(SESSION_ADMIN_NAME);
			companyVO.getCompany().setCreateDate(new Date());
			companyVO.getCompany().setCreateName(adminName);
			companyVO.getCompany().setStatus(1);
			companyService.addCompany(companyVO);
			result = Tip.addSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			result = Tip.addFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "edit/{compnayId}.html", method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mav, @PathVariable(value="compnayId") int compnayId) {
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.getCategory().setCategoryId(0);
		categoryVO = categoryService.viewCategoryList(categoryVO);
		
		CompanyVO companyVO = new CompanyVO();
		companyVO.getCompany().setCoid(compnayId);
		companyVO = companyService.viewCompanyDetail(companyVO);
		
		mav.addObject("COMPNAY_EDIT_DETAIL", companyVO);
		mav.addObject("MAIN_CATEGORY", categoryVO.getCategoryList());
		mav.setViewName("company/edit");
		return mav;
	}
	
	@RequestMapping(value = "edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, CompanyVO companyVO) {
		ResultObject<Object> result = new ResultObject<Object>();
		if(companyService.modifiCompany(companyVO)) {
			result = Tip.editSuccess();
		} else {
			result = Tip.editFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "remove/{compnayId}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, @PathVariable(value="compnayId") int compnayId) {
		ResultObject<Object> result = new ResultObject<Object>();
		CompanyVO companyVO = new CompanyVO();
		companyVO.getCompany().setCoid(compnayId);
		if(companyService.removeCompany(companyVO)) {
			result = Tip.removeSuccess();
		} else {
			result = Tip.removeFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "list/{name}/{settleType}/{serviceType}/{categoryId}/{salesName}/{status}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, 
			@PathVariable(value="name") String name, 
			@PathVariable(value="settleType") int settleType,
			@PathVariable(value="serviceType") int serviceType,
			@PathVariable(value="categoryId") int categoryId,
			@PathVariable(value="salesName") String salesName,
			@PathVariable(value="status") int status, 
			@PathVariable(value="pageNo") int pageNo) {
		CompanyVO companyVO = new CompanyVO();
		name = urlDecoder(name);
		if(!name.equals("all")) {
			companyVO.getCompany().setName(name);
		}
		if(settleType != 0) {
			companyVO.getCompany().setSettleType(settleType);
		}
		if(serviceType != 0) {
			companyVO.getCompany().setServiceType(serviceType);
		}
		if(categoryId != 0) {
			companyVO.getCompany().setCategoryId(categoryId);
		}
		salesName = urlDecoder(salesName);
		if(!salesName.equals("all")) {
			companyVO.getCompany().setSalesName(salesName);
		}
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.getCategory().setCategoryId(0);
		categoryVO = categoryService.viewCategoryList(categoryVO);
		mav.addObject("MAIN_CATEGORY", categoryVO.getCategoryList());
		
		companyVO.getCompany().setStatus(status);
		companyVO.setPageNO(pageNo);
		companyVO.setPageRows(10);
		PageBean<BusinessCompany> pageBean = companyService.queryCompanyList(companyVO);
		if(pageBean != null) {
			mav.addObject("PAGE_BEAN", pageBean);
		}
		mav.setViewName("company/list");
		return mav;
	}

}
