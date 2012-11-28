package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.CoffeeExpert;

/**
 * Servlet implementation class Loader
 */
public class CoffeFormHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeFormHandler() {
        super();
    }

    public void init () {
    	log("Custom CoffeFormHandler init method called");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String c = request.getParameter("type");

	    //DateFormat dt = new SimpleDateFormat(request.getParameter("format"), request.getLocale());
	    
	    log("olololo");
	    
	    // Now use our Coffee Model above 
	    CoffeeExpert ce = new CoffeeExpert();

	    List result = ce.getTypes(c);

	    // Use the below code to debug the program if you get problems 
	    //response.setContentType("text/html"):
	    PrintWriter out = response.getWriter();
	    out.println("Coffee Selection Advise<br>");

	    //Iterator it = result.iterator();
	    //while(it.hasNext()) {
	    //  out.print("<br>try: " + it.next());
	    //}

	    // The results will be passed back (as an attribute) to the JSP view
	    // The attribute will be a name/value pair, the value in this case will be a List object 
	    request.setAttribute("styles", result);
	    RequestDispatcher view = request.getRequestDispatcher("CoffeFormHandler.jsp");
	    view.forward(request, response);
		
	}

}
