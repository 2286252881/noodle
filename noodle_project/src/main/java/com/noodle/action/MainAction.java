package com.noodle.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noodle.pojo.po.ActiveUser;
import com.noodle.pojo.po.TUser;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.shiro.CustomRealm;

@Controller
public class MainAction {
	
//	@Autowired
//	private CustomRealm customRealm;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		// 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				request.setAttribute("error", "用户名或密码不正确!");
				return "/base/login";
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				return "/base/login";
			} else {
				return "/base/login";
			}
		}
		// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		// 登陆失败还到login页面
		return "/base/login";
	}

	// 用户退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// session失效
		session.invalidate();
		// 重定向到商品查询页面
		return "redirect:/first.action";
	}
	@RequestMapping("/clearCache")
	public void clearCache(){
//		customRealm.clearCached();
	}

	@RequestMapping("/first")
	public String first(Model model) {
		Subject subject = SecurityUtils.getSubject();
		// 取出身份信息
		ActiveUser user = (ActiveUser) subject.getPrincipal();
		model.addAttribute("adminUser", user);
		return "/base/first";
	}
}
