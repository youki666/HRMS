package com.hrms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	/**/
    @RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}
    
    
    
    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(){
    	return new ModelAndView("main");
    }
    /**
     * 对登录页面输入的用户名和密码做简单的判断
     * @param request
     * @return
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView dologin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);
        if (!"admin1234".equals(username + password)){
        	
            return new ModelAndView("login");
        }
        
         return new ModelAndView("main");
    }
    /**
     * 退出登录：从主页面跳转到登录页面
     * @return
     */
    @RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout() {
		return new ModelAndView("login");
	}
    
}
