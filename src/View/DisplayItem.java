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

public class DisplayItem extends HttpServlet {
String lastUri;

            public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean sessionCheck = false;
        String uri = request.getRequestURI();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
	String name = new String();
	String role = new String();
	boolean traderRules = false;
        if (session != null) {
            sessionCheck = true;
            name = (String) session.getAttribute("name");
            role = UserBase.getRole(name);
	    if(role.equals("Admin") || role.equals("Trader"))
{
		traderRules=true;
        if (uri.equals("/Web-shop/item/remove")) {
	ItemBase.removeItem(lastUri);
            response.sendRedirect("../MainPage");
        }

        }
}
        out.println("<html>\n<body>\n");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../itemProfileStyle.css\">");
        if (uri.equals("/Web-shop/item/return")) {
            response.sendRedirect("../MainPage");
        }
	if (!uri.equals("/Web-shop/item/return") && !uri.equals("/Web-shop/item/Addtocart"))
lastUri=ItemBase.lastUri(uri);
        if (uri.equals("/Web-shop/item/Addtocart")) {
            ItemBase.addItemToUser(name, lastUri);
            ItemBase.takeQuantity(lastUri);
            response.sendRedirect("../MainPage");
        }
            out.println(ItemBaseHtml.getItemProfile(lastUri, sessionCheck, traderRules));

        out.println("</html>\n</body>\n");

    }



}
