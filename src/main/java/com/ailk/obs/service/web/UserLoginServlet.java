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

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1367941784575108588L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User(userName, passWord);
		// �Ƿ�ע��
		boolean isRegisterResult = userService.isRegister(user);
		// ע��
		if (isRegisterResult == true) {
			boolean loginResult = userService.login(user);
			if (loginResult == true) {
				request.setAttribute("info", "����ɹ�");
			} else {
				request.setAttribute("info", "����ʧ��");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginReult.jsp");
			dispatcher.forward(request, response);
		} else {
			// δע��,��ʾע����Ϣ
			
		}

	}
}
