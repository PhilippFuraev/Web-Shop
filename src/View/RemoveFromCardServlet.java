package View;
import Model.*;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class RemoveFromCardServlet extends HttpServlet {
private String lastUri; 
  
    public void doGet(HttpServletRequest request,HttpServletResponse response)  
             throws IOException  
    { 
 String uri = request.getRequestURI();
    ServletOutputStream out;  
    out = response.getOutputStream();
String name = new String();
String role = new String();
 String lastUri = ItemBase.lastUri(uri);
HttpSession session = request.getSession(false);
        if (session != null) {
            name = (String) session.getAttribute("name");
            role = UserBase.getRole(name);
	UserBase.removeItemFromUser(name, lastUri);
	ItemBase.returnItem(lastUri);
	response.sendRedirect("../Card");
		
        }

}

     
}  
