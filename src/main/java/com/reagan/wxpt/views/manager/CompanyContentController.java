package com.reagan.wxpt.views.manager;

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
import com.reagan.wxpt.pojo.business.BusinessCompanyContent;
import com.reagan.wxpt.service.business.ICompanyContentService;
import com.reagan.wxpt.service.business.ICompanyService;
import com.reagan.wxpt.service.system.IAttachmentService;
import com.reagan.wxpt.vo.business.CompanyContentVO;
import com.reagan.wxpt.vo.business.CompanyVO;
import com.reagan.wxpt.vo.system.AttachmentVO;

@Controller
@RequestMapping(value = "/company/content")
public class CompanyContentController extends Component {
	
	@Autowired
	private ICompanyContentService companyContentService;
	
	@Autowired
	private ICompanyService companyService;
	
	@Autowired
	private IAttachmentService attachmentService;
	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav, HttpServletRequest request) {
		Integer companyId = (Integer) request.getSession().getAttribute(SESSION_ADMIN_COMPANY_ID);
		
		AttachmentVO attachmentVO = new AttachmentVO();
		attachmentVO.getAttachment().setCompanyId(companyId);
		attachmentVO = attachmentService.viewAttachmentList(attachmentVO);
		
		CompanyContentVO companyContentVO = new CompanyContentVO();
		companyContentVO.getCompanyContent().setCoid(companyId);
		companyContentVO = companyContentService.viewCompanyContentDetail(companyContentVO);
		
		mav.addObject("COMPANY_ID", companyId);
		
		mav.addObject("ATTACHMENT_LIST", attachmentVO.getAttachmentList());
		
		if(companyContentVO.getCompanyContent() == null) {
			mav.setViewName("company/content/add");
		} else {
			mav = new ModelAndView("redirect:/company/content/view/" + companyId + ".html");
		}
		return mav;
	}
	
	@RequestMapping(value = "add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav, CompanyContentVO companyContentVO, HttpServletRequest request) {
		ResultObject<Object> result = new ResultObject<Object>();
		try {
			Integer companyId = (Integer) request.getSession().getAttribute(SESSION_ADMIN_COMPANY_ID);
			companyContentVO.getCompanyContent().setCoid(companyId);
			companyContentVO.getCompanyContent().setStatus(2);
			companyContentService.addCompanyContent(companyContentVO);
			result = Tip.addSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			result = Tip.addFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "edit/{companyId}.html", method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mav, @PathVariable(value="companyId") int companyId) {
		CompanyContentVO companyContentVO = new CompanyContentVO();
		companyContentVO.getCompanyContent().setCoid(companyId);
		companyContentVO = companyContentService.viewCompanyContentDetail(companyContentVO);
		mav.addObject("COMPANY_EDIT_DETAIL", companyContentVO);
		return mav;
	}
	
	@RequestMapping(value = "edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, CompanyContentVO companyContentVO) {
		ResultObject<Object> result = new ResultObject<Object>();
		if(companyContentService.modifiCompanyContent(companyContentVO)) {
			result = Tip.editSuccess();
		} else {
			result = Tip.editFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "check/{companyId}.json", method = RequestMethod.GET)
	public ModelAndView check(ModelAndView mav, @PathVariable(value="companyId") int companyId) {
		ResultObject<Object> result = new ResultObject<Object>();
		CompanyContentVO companyContentVO = new CompanyContentVO();
		companyContentVO.getCompanyContent().setCoid(companyId);
		companyContentVO.getCompanyContent().setStatus(1);
		if(companyContentService.modifiCompanyContent(companyContentVO)) {
			result = Tip.editSuccess();
		} else {
			result = Tip.editFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "remove/{companyId}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, @PathVariable(value="companyId") int companyId) {
		ResultObject<Object> result = new ResultObject<Object>();
		CompanyContentVO companyContentVO = new CompanyContentVO();
		companyContentVO.getCompanyContent().setCoid(companyId);
		if(companyContentService.removeCompanyContent(companyContentVO)) {
			result = Tip.removeSuccess();
		} else {
			result = Tip.removeFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "view/{companyId}.html", method = RequestMethod.GET)
	public ModelAndView view(ModelAndView mav, @PathVariable(value="companyId") int companyId) {
		CompanyContentVO companyContentVO = new CompanyContentVO();
		companyContentVO.getCompanyContent().setCoid(companyId);
		companyContentVO = companyContentService.viewCompanyContentDetail(companyContentVO);
		mav.addObject("COMPANY_VIEW_CONTENT", companyContentVO);
		mav.setViewName("company/content/view");
		return mav;
	}
	
	@RequestMapping(value = "list/{companyId}/{status}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, 
			@PathVariable(value="companyId") int companyId,
			@PathVariable(value="status") int status, 
			@PathVariable(value="pageNo") int pageNo,
			HttpServletRequest request) {
		CompanyContentVO companyContentVO = new CompanyContentVO();
		if(companyId != 0) {
			companyContentVO.getCompanyContent().setCoid(companyId);
		}
		companyContentVO.getCompanyContent().setStatus(status);
		companyContentVO.setPageNO(pageNo);
		companyContentVO.setPageRows(10);
		
		CompanyVO companyVO = new CompanyVO();
		companyVO = companyService.viewCompanyList(companyVO);
		mav.addObject("COMPANY_LIST", companyVO.getCompanyList());
		PageBean<BusinessCompanyContent> pageBean = companyContentService.queryCompanyContentList(companyContentVO);
		if(pageBean != null) {
			mav.addObject("PAGE_BEAN", pageBean);
		}
		mav.setViewName("company/content/list");
		return mav;
	}

}
