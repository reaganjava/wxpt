package com.reagan.wxpt.views.file;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.reagan.support.image.CompressImage;
import com.reagan.util.PropertiesUtil;
import com.reagan.util.components.Component;
import com.reagan.views.dto.ResultObject;
import com.reagan.views.dto.Tip;
import com.reagan.wxpt.service.system.IAttachmentService;
import com.reagan.wxpt.vo.system.AttachmentVO;

@Controller
@RequestMapping(value = "/attachment")
public class UploadController extends Component {
	
	@Autowired
	private IAttachmentService attachmentService;
	
	@RequestMapping(value = "/upload/{id}/{srcType}.html", method = RequestMethod.GET)
	public ModelAndView upload(ModelAndView mav, @PathVariable(value="id") int id,
			@PathVariable(value="srcType") int srcType) {
		mav.addObject("UPLOAD_ID", id);
		mav.addObject("SRC_TYPE", srcType);
		mav.setViewName("attachment/upload");
		return mav;
	}

	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
	public ModelAndView upload(ModelAndView mav, 
			int id,
			int srcType,
			HttpServletRequest request) {
		boolean isError = false;
		
		String suffix = "";

		ResultObject<Object> result = new ResultObject<Object>();

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> multFiles = multiRequest.getFiles("files");
		for(MultipartFile multFile : multFiles) {
			String contentType = multFile.getContentType();
			switch (contentType) {
				case "image/jpeg": {
					suffix = ".jpg";
					break;
				}
				case "image/gif": {
					suffix = ".gif";
					break;
				}
				case "image/png": {
					suffix = ".png";
					break;
				}
				default: {
					result = Tip.uploadError("文件格式不对");
					isError = true;
				}
			}
			if(!isError) {
				AttachmentVO attachmentVO = new AttachmentVO();
				PropertiesUtil.init("sysconfig.properties");
				String tempath = PropertiesUtil.getProperty("sys.image.temp.path");
				String path = PropertiesUtil.getProperty("sys.image.path");
				String url = PropertiesUtil.getProperty("sys.image.url");
				String fileName = UUID.randomUUID().toString();
				
				File targetFile = new File(tempath, fileName + suffix);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				
				CompressImage compressImage = new CompressImage();
				
				System.out.println(tempath + ":" + path);
				
				// 保存
				try {
					multFile.transferTo(targetFile);
					compressImage.compressPic(tempath, path, fileName + suffix, fileName + suffix,
							640, 320, true);
					switch(srcType) {
					case 1: attachmentVO.getAttachment().setCompanyId(id); break;
					case 2: attachmentVO.getAttachment().setGoodsId(id); break;
					case 3: attachmentVO.getAttachment().setAdvertisementId(id); break;
					}
					attachmentVO.getAttachment().setFilename(fileName);
					attachmentVO.getAttachment().setMimetype(contentType);
					attachmentVO.getAttachment().setDate(new Date());
					String adminName = (String) request.getSession().getAttribute(Component.SESSION_ADMIN_NAME);
					attachmentVO.getAttachment().setCreatename(adminName);
					attachmentVO.getAttachment().setPath(url + fileName + suffix);
		
					attachmentService.addAttachement(attachmentVO);
				} catch (Exception e) {
					e.printStackTrace();
					result = Tip.uploadError("系统出现异常");
				}
			}
		}
		result = Tip.uploadSuccess();
		mav.addObject(JSONDATA, result);
		System.out.println(mav);
		return mav;
	}

}
