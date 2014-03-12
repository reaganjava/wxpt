package com.reagan.wxpt.views.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reagan.util.components.Component;
import com.reagan.wxpt.util.SignUtil;

@Controller
@RequestMapping(value = "/auth")
public class AuthController extends Component {

	@RequestMapping(value = "/verifi", method = RequestMethod.GET)
	public void verification(@RequestParam("signature") String signature,
							 @RequestParam("timestamp") String timestamp,
							 @RequestParam("nonce") String nonce,
							 @RequestParam("echostr") String echostr,
							 HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				out.print(echostr);
			} else {
				out.print("Verifi Failure...");
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			out = null;
		}
	}
	
}
