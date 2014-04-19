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
import com.reagan.wxpt.pojo.common.CommonMenuItem;
import com.reagan.wxpt.service.common.IGroupService;
import com.reagan.wxpt.service.common.IAdminMenuService;
import com.reagan.wxpt.util.Constant;
import com.reagan.wxpt.vo.common.GroupVO;
import com.reagan.wxpt.vo.common.MenuItemVO;

@Controller
@RequestMapping(value = "/menuItem")
public class MenuItemController extends Component {
	
	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private IAdminMenuService adminMenuService;

	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mav) {
		GroupVO groupVO = new GroupVO();
		groupVO = groupService.viewGroupList(groupVO);
		mav.addObject("MENU_ITEM_URLS", Constant.MENU_ITEM_URLS);
		mav.addObject("GROUP_LIST", groupVO.getGroupList());
		mav.setViewName("menuItem/add");
		return mav;
	}
	
	@RequestMapping(value = "add.json", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView mav, MenuItemVO menuItemVO, HttpServletRequest request) {
		ResultObject<Object> result = new ResultObject<Object>();
		try {
			String adminName = (String) request.getSession().getAttribute(SESSION_ADMIN_NAME);
			menuItemVO.getMenuItem().setCreateDate(new Date());
			menuItemVO.getMenuItem().setCreateName(adminName);
			menuItemVO.getMenuItem().setIcon("/" + menuItemVO.getMenuItem().getTitle());
			menuItemVO.getMenuItem().setStatus(1);
			adminMenuService.addMenuItem(menuItemVO);
			result = Tip.addSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			result = Tip.addFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "edit/{menuId}.html", method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mav, @PathVariable(value="menuId") int menuId) {
		MenuItemVO menuItemVO = new MenuItemVO();
		menuItemVO.getMenuItem().setMenuId(menuId);
		menuItemVO = adminMenuService.viewMenuItemDetail(menuItemVO);
		
		GroupVO groupVO = new GroupVO();
		groupVO = groupService.viewGroupList(groupVO);
		
		mav.addObject("GROUP_LIST", groupVO.getGroupList());
		mav.addObject("MENU_ITEM_URLS", Constant.MENU_ITEM_URLS);
		mav.addObject("MENUITEM_EDIT_DATEIL", menuItemVO);
		mav.setViewName("menuItem/edit");
		return mav;
	}
	
	@RequestMapping(value = "edit.json", method = RequestMethod.POST)
	public ModelAndView edit(ModelAndView mav, MenuItemVO menuItemVO) { 
		ResultObject<Object> result = new ResultObject<Object>();
		menuItemVO.getGroupMenuItem().setMenuItemId(menuItemVO.getMenuItem().getMenuId());
		if(adminMenuService.modifiMenuItem(menuItemVO)) {
			result = Tip.editSuccess();
		} else {
			result = Tip.editFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "remove/{menuId}.json", method = RequestMethod.GET)
	public ModelAndView remove(ModelAndView mav, @PathVariable(value="menuId") int menuId) {
		ResultObject<Object> result = new ResultObject<Object>();
		MenuItemVO menuItemVO = new MenuItemVO();
		menuItemVO.getMenuItem().setMenuId(menuId);
		if(adminMenuService.removeMenuItem(menuItemVO)) {
			result = Tip.removeSuccess();
		} else {
			result = Tip.removeFailure();
		}
		mav.addObject(JSONDATA, result);
		return mav;
	}
	
	@RequestMapping(value = "list/{title}/{url}/{status}/{pageNo}.html", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, 
			@PathVariable(value="title") String title,
			@PathVariable(value="status") int status,
			@PathVariable(value="pageNo") int pageNo) {
		MenuItemVO menuItemVO = new MenuItemVO();
		
		title = urlDecoder(title);
		if(!title.equals("all")) {
			menuItemVO.getMenuItem().setTitle(title);
		}
		menuItemVO.getMenuItem().setStatus(status);
		menuItemVO.setPageNO(pageNo);
		menuItemVO.setPageRows(10);
		PageBean<CommonMenuItem> pageBean = adminMenuService.queryMenuItemList(menuItemVO);
		if(pageBean != null) {
			mav.addObject("PAGE_BEAN", pageBean);
		}
		mav.setViewName("menuItem/list");
		return mav;
	}
}
