/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import Model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShopServlet extends HttpServlet {

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
	out.println(ItemBaseHtml.getShopPage());
        out.println("</body>\n</html>");
        }
        else{
	request.getRequestDispatcher("UnregisteredUserlink.html").include(request, response);
	out.println(ItemBaseHtml.getShopPage());
        out.println("</body>\n</html>");

    }
}



   

}
