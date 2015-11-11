package com.ailk.obs.service.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ailk.obs.model.User;
import com.ailk.obs.service.UserService;
import com.ailk.obs.service.imp.UserServiceImpl;

public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1367941784575108588L;
	
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User(userName, passWord);
		boolean result = userService.isRegister(user);
		
		if (result == true) {
			// ...
			request.setAttribute("info", "×¢²á³É¹¦£¡");
		} else {
			// ...
			request.setAttribute("info", "×¢²áÊ§°Ü£¡");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	}

}
