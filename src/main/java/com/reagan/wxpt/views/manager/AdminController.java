package com.reagan.wxpt.views.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		adminVO.getAdmin().setAdmid(1);
		adminVO = adminService.viewAdminDetail(adminVO);
		adminVO.getAdmin().setRealname("reading");
		adminService.modifiAdmin(adminVO);
	}
	
}
