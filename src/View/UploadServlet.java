package View;
import Model.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {





protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession(false);
 PrintWriter out = response.getWriter();
	String name = new String();
	String role = new String();
	String catalog = new String();
	int number = 0;
	 out.println("<html>\n<body>\n");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../itemProfileStyle.css\">");
        if (session != null) {
            name = (String) session.getAttribute("name");
            role = UserBase.getRole(name);
	catalog=request.getParameter("catalog");
	if (role.equals("Admin"))
	catalog=request.getParameter("catalog");
	if (role.equals("Trader"))
	catalog = UserBase.getCatalogFromTrader(name);
if (role.equals("Admin") ||role.equals("Trader"))
{
	number = ItemBase.addToNumberOfItems();
	ItemBase.addItemToBase(number, catalog, request.getParameter("name"), request.getParameter("quantity"), request.getParameter("price"), request.getParameter("description"));
	request.getPart("content").write("/home/filipp/apache-tomcat-8.5.9/webapps/Web-shop/Images/" + number + ".jpg");
}
	response.sendRedirect("http://localhost:8080/Web-shop/MainPage");
        }

}
}
