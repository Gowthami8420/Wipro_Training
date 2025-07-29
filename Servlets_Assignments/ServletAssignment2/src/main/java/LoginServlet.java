import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("User".equals(name) && "gowthami".equals(password)) {
            RequestDispatcher rd = request.getRequestDispatcher("SuccessServlet");
            rd.forward(request, response);
        } else {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("form2.html");
            rd.forward(request, response);
        }
	}

}
