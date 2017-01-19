package View;
import Model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AddCatalogServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");

        PrintWriter out = response.getWriter();
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../mainPageStyle.css\">");
        out.println("<html><body>");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainPageStyle.css\">");

        request.getRequestDispatcher("Adminlink.html").include(request, response);

        if( ItemBase.checkCatalog(name)){
            ItemBase.addCatalog(name);
		out.print("succesfull");
        }
        else{
            out.print("Sorry, that catalog already exist!");
            request.getRequestDispatcher("registerCatalog.html").include(request, response);
        }

        out.println("</html></body>");
        out.close();
    }

}
