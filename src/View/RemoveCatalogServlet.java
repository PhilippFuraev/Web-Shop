package View;
import Model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class RemoveCatalogServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        PrintWriter out = response.getWriter();
	
        out.println("<html>\n<body>\n");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainPageStyle.css\">");
	

        HttpSession session = request.getSession(false);
        if(session != null){
            String name = (String)session.getAttribute("name");
            String role = UserBase.getRole(name);
	request.getRequestDispatcher(role + "link.html").include(request, response);
if (role.equals("Admin"))
{
	 String catalog = request.getParameter("catalog");
	if (catalog !=null)
{
	out.println(catalog);
	//ItemBase.removeCatalogItems(catalog);
	ItemBase.removeCatalog(catalog);
	out.println("succesful remove");
}
	out.println(ItemBaseHtml.getCatalogsInOptions());
}
        out.println("</body>\n</html>");
        }
        else{
	out.println("woops, wrong page");
	out.println("</body>\n</html>");

    }
}



   

}
