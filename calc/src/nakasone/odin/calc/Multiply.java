package nakasone.odin.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiply")
public class Multiply extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try {
			double multiplicand = Double.parseDouble(request.getParameter("multiplicand"));
			double multiplier = Double.parseDouble(request.getParameter("multiplier"));
			double product = multiplicand * multiplier ;
			
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
			dispatcher.forward(request, response);
			
		} catch(NumberFormatException nfe ) {
			response.sendError(400);
			
		}catch(NullPointerException npe) {
			response.sendError(404);
			
		}catch(Exception e) {
			response.sendError(500);
		}

	}
}

	


