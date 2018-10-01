package p.minn.dubbo.web;



import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import p.minn.common.annotation.MyParam;
import p.minn.common.exception.WebPrivilegeException;
import p.minn.dubbo.api.IDemoService;
import p.minn.privilege.utils.Constant;

/**
 * 
 * @author minn 
 * @QQ:3942986006
 * 
 */
@Controller
@RequestMapping("/consumer")
@SessionAttributes(Constant.LOGINUSER)
public class ConsumerController {

	@Autowired
	private IDemoService demoService;
	
	@RequestMapping(params="method=getMsg")
	public Object getMsg(@RequestParam("messageBody") String messageBody,@MyParam("language") String lang){
		Object entity = null;
		try {
			entity=demoService.getMsg(messageBody,lang);
		 } catch (Exception e) {
			entity = new WebPrivilegeException(e.getMessage());
		 }
		return entity;
	}
}
