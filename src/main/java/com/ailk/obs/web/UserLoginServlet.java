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
	// response.getWriter().write("����ɹ�");
	// response.flushBuffer();
	// return;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// if (!loginResult) {
	// response.getWriter().write("����ʧ��");
	// response.flushBuffer();
	// }
	// }

	/**
	 * �ڲ���ת
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
	// request.setAttribute("info", "����ɹ�");
	// dispatcher.forward(request, response);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// if (!loginResult) {
	// request.setAttribute("info", "����ʧ��");
	// dispatcher.forward(request, response);
	// }
	// }

	/**
	 * �ض���
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
				request.getSession().setAttribute("info", "��ӭ" + userName);
			} else {
				request.getSession().setAttribute("info", "�û������������");
			}

			// �ض���ʽ����ת��request��response������գ����Ҫ��ֵ����session��
			// request.getSession().setAttribute("userName", "abc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/result.jsp");
	}
}
