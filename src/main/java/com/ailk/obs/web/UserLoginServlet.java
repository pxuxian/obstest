package com.ailk.obs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ailk.obs.dao.impl.UserDaoImpl;
import com.ailk.obs.model.User;
import com.ailk.obs.service.UserService;
import com.ailk.obs.service.imp.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(UserLoginServlet.class);
	private static final long serialVersionUID = 1367941784575108588L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	// @Override
	// protected void service(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// String userName = request.getParameter("userName");
	// String passWord = request.getParameter("passWord");
	// User user = new User(userName, passWord);
	// boolean loginResult = false;
	// try {
	// loginResult = userService.login(user);
	// response.getWriter().write("登入成功");
	// response.flushBuffer();
	// return;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// if (!loginResult) {
	// response.getWriter().write("登入失败");
	// response.flushBuffer();
	// }
	// }

	/**
	 * 内部跳转
	 */
	// @Override
	// protected void service(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// String userName = request.getParameter("userName");
	// String passWord = request.getParameter("passWord");
	// User user = new User(userName, passWord);
	// RequestDispatcher dispatcher =
	// request.getRequestDispatcher("/result.jsp");
	// boolean loginResult = false;
	// try {
	// loginResult = userService.login(user);
	// request.setAttribute("info", "登入成功");
	// dispatcher.forward(request, response);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// if (!loginResult) {
	// request.setAttribute("info", "登入失败");
	// dispatcher.forward(request, response);
	// }
	// }

	/**
	 * 重定向
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWd");
		LOG.info("userName = " + userName + "; passWord = " + passWord);
		User user = new User(userName, passWord);
		try {
			if (userService.login(user)) {
				request.getSession().setAttribute("info", "欢迎" + userName);
			} else {
				request.getSession().setAttribute("info", "用户名、密码错误！");
			}

			// 重定向方式，跳转后request和response内容清空，因此要将值放入session中
			// request.getSession().setAttribute("userName", "abc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/result.jsp");
	}
}
