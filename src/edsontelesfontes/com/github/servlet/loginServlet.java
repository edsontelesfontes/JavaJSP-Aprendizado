package edsontelesfontes.com.github.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edsontelesfontes.com.github.dao.UserDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO UserDAO = new UserDAO();
		
		String User = request.getParameter("login");
		String Password = request.getParameter("senha");
		
		try {
			if(UserDAO.validLogin(User, Password)) {
				RequestDispatcher Dispatcher = request.getRequestDispatcher("acessoLiberado.jsp");
				Dispatcher.forward(request, response);
			}else {
				RequestDispatcher Dispatcher = request.getRequestDispatcher("acessoRestrito.jsp");
				Dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
