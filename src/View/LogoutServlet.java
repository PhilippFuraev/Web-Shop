package View;
import Model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {
            response.setContentType("text/html");

            HttpSession session = request.getSession();
            session.invalidate();
            PrintWriter out=response.getWriter();
            out.println("<html><body>");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainPageStyle.css\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainPageStyle.css\">");

            request.getRequestDispatcher("UnregisteredUserlink.html").include(request, response);
            out.println("You are successfully logged out!");

            out.println("</html></body>");

            out.close();
    }
}
