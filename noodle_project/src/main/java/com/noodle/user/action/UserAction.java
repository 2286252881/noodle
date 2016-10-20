package com.noodle.user.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.noodle.pojo.po.TUser;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.process.result.ResultInfo;
import com.noodle.service.IUserService;

/**
 * 如果使用shiro权限注解需要手动捕获
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private IUserService userService;
	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 * @throws ExceptionResultInfo 
	 */
	@RequestMapping("/user")
	@RequiresPermissions("user:search")
	public ModelAndView getAllUsers() throws ExceptionResultInfo {
			List<TUser> user=null;
			try {
				user = userService.getAllUsers();
			} catch (ExceptionResultInfo e) {
				throw new ExceptionResultInfo(new ResultInfo(ResultInfo.TYPE_RESULT_FAIL,0001,"无权访问"));
			}
			ModelAndView mv=new ModelAndView("/base/user/searchUser");
			mv.addObject("users", user);
			return mv;
	};
}
