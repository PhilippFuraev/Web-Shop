package View;
import Model.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterTraderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainPageStyle.css\">");
        request.getRequestDispatcher("Adminlink.html").include(request, response);

        if( UserBase.checkUser(name)){
            UserBase.addTrader(name, password, "Trader", request.getParameter("catalog"));
		out.print("succesfull registration");
        }
        else{
            out.print("Sorry, that login already exist!");
            request.getRequestDispatcher("RegisterTrader.html").include(request, response);
        }

        out.println("</html></body>");
        out.close();
    }

}

