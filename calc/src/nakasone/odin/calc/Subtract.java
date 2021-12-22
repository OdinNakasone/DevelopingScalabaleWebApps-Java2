package nakasone.odin.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subtract")
public class Subtract extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			double minuend = Double.parseDouble(request.getParameter("minuend"));
			double subtrahend = Double.parseDouble(request.getParameter("subtrahend"));
			double difference = minuend - subtrahend;
			
			request.setAttribute("diff", difference);
			RequestDispatcher dispatcher = request.getRequestDispatcher("difference.jsp");
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
