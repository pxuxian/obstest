package com.ailk.obs.service.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1367941784575108588L;

	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("userName");
	}

}
