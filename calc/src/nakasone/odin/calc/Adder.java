package nakasone.odin.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add")
public class Adder extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			
			double augend = Double.parseDouble(request.getParameter("augend"));
			double addend = Double.parseDouble(request.getParameter("addend"));
			double sum = augend + addend;
			
			request.setAttribute("sum", sum);
			RequestDispatcher dispatcher = request.getRequestDispatcher("sum.jsp");
			dispatcher.forward(request, response);
		
			
		}catch(NumberFormatException nfe ) {
			response.sendError(400);
			
		}catch(NullPointerException npe) {
			response.sendError(404);
			
		}catch(Exception e) {
			response.sendError(500);
		}
		
	}
}
