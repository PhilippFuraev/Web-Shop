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
public class RegisterTraderMenu extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 PrintWriter out = response.getWriter();
out.println("<!DOCTYPE html>");
out.println("<html lang=\"en\">");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainPageStyle.css\">");
 out.println("<head>");
out.println("<form action=\"RegisterTraderServlet\" method=\"post\">");
    out.println("Name:<input type=\"text\" name=\"name\" required><br>");
   out.println(" Password:<input type=\"password\" name=\"password\" required><br>");
out.println(ItemBaseHtml.getCatalogsForAdmin());
    out.println("<input type=\"submit\" value=\"Register\">");
out.println("</form>");
out.println("</head>");

}
}
