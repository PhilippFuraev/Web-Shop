package View;
import Model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainPageStyle.css\">");
        out.println("<html><body>");

        request.getRequestDispatcher("UnregisteredUserlink.html").include(request, response);

        if( UserBase.checkUser(name)){
            UserBase.addUser(name, password, "User");
	out.print("You registered!");
        }
        else{
            out.print("Sorry, that login already exist!");
            request.getRequestDispatcher("Register.html").include(request, response);
        }

        out.println("</html></body>");
        out.close();
    }

}

