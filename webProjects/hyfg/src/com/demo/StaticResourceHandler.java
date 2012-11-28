package com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StaticResourceHandler
 */
public class StaticResourceHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaticResourceHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.log("static controller handler");

		response.setContentType("text/css");
		
		String filename = "/resources/style.css" ; 
		
		String ctxPath = getServletContext().getRealPath(filename);
		
		PrintWriter out = response.getWriter();
		out.println("/* demo styles s*/");

		File f = new File(ctxPath);
		if (f.exists()) {
			java.io.BufferedReader fr = new BufferedReader(new FileReader(f));
			String styleLine = "";
			while ((styleLine = fr.readLine()) != null)
				out.println(styleLine);
			fr.close();
		} else
			this.log("no " + ctxPath + " found");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
