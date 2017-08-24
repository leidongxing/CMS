package com.hollysys.malor.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.malor.entity.User;
import com.hollysys.malor.service.UserService;

@Controller
@RequestMapping("/") 
public class BaseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/username", method = {RequestMethod.GET,RequestMethod.POST})
	private String list(Model model) {
		List<User> list = userService.queryAll();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/{username}/detail", method = {RequestMethod.GET,RequestMethod.POST})
	private String detail(@PathVariable("username") String username, Model model) {
		if (username == null) {
			return "redirect:/user/list";
		}
		User user = userService.queryByUserName(username);
		if (user == null) {
			return "forward:/user/list";
		}
		model.addAttribute("user", user);
		return "detail";
	}

//	// ajax json
//	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
//			"application/json; charset=utf-8" })
//	@ResponseBody
//	private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
//		if (studentId == null || studentId.equals("")) {
//			return new Result<>(false, "学号不能为空");
//		}
//		AppointExecution execution = null;
//		try {
//			execution = bookService.appoint(bookId, studentId);
//		} catch (NoNumberException e1) {
//			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
//		} catch (RepeatAppointException e2) {
//			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
//		} catch (Exception e) {
//			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
//		}
//		return new Result<AppointExecution>(true, execution);
//	}

}
