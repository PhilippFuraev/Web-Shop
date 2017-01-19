package View;
import Model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"itemProfileStyle.css\">");
HttpSession session = request.getSession(false);
        if(session != null){
            String name = (String)session.getAttribute("name");
	String role = UserBase.getRole(name);
		request.getRequestDispatcher(role + "link.html").include(request, response);
	out.print(UserBaseHtml.getCard(name));
        }
        else{
	request.getRequestDispatcher("UnregisteredUserlink.html").include(request, response);
	
            out.print("Please login first");
            request.getRequestDispatcher("login.html").include(request, response);
        }




        out.println("</html></body>");
        out.close();
    }
}
