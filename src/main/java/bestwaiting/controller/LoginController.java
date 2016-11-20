package bestwaiting.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bestwaiting.model.UserBean;
import bestwaiting.service.ILoginService;

@Controller
public class LoginController {
	private Logger logger=Logger.getLogger(this.getClass());
	@Autowired(required=true)
	private ILoginService loginService;
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,UserBean user) {
		logger.info(user);
		ModelAndView mv=new ModelAndView();
		System.out.println(user.toString());
		UserBean userBean=loginService.Login(user.getUser_name(), user.getUser_pwd());
		if(userBean!=null){
			request.getSession().setAttribute("user", userBean);
			mv.addObject("id", userBean.getId());
			mv.addObject("name", userBean.getUser_name());
			mv.addObject("pwd", userBean.getUser_pwd());
			mv.addObject("phone", userBean.getUser_phone());
			mv.addObject("email", userBean.getUser_email());
			mv.addObject("note", userBean.getUser_note());
			System.out.println(userBean.toString());
		}
		mv.setViewName("index");
		return mv;
	}
}
