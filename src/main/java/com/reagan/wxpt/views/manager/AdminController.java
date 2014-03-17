package com.reagan.wxpt.views.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reagan.util.components.Component;
import com.reagan.wxpt.pojo.common.CommonAdmin;
import com.reagan.wxpt.service.common.IAdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends Component {
	
	@Autowired
	IAdminService adminService;
	
	@RequestMapping(value = "add.html", method = RequestMethod.GET)
	public void add() {
		CommonAdmin admin = new CommonAdmin();
		admin.setUsername("kokomi");
		admin.setPassword("123456");
		admin.setGroupId(1);
		admin.setCompanyId(1);
		admin.setRealname("reagan");
		admin.setStatus(0);
		admin.setCreatename("admin");
		admin.setCreatedate(new Date());
		adminService.addAdmin(admin);
	}
}
