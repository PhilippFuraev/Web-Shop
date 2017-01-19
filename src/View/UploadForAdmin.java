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
public class UploadForAdmin extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 PrintWriter out = response.getWriter();
out.println("<!DOCTYPE html>");
out.println("<html lang=\"en\">");
out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"itemProfileStyle.css\">");
 out.println("<head>");
out.println("<title>File Upload</title>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
out.println("</head><body>");
out.println("<FORM action=\"upload\" enctype=\"multipart/form-data\" method=\"POST\">");
out.println("name: <INPUT type=\"text\" name=\"name\" required>"); 
out.println("<br> <br>");
out.println("quantity: <INPUT type=\"text\" name=\"quantity\" required>"); 
out.println("<br> <br>");
out.println("price: <INPUT type=\"text\" name=\"price\" required>");
out.println("<br> <br>");
out.println("description: <INPUT type=\"text\" name=\"description\" required>");
out.println("<br> <br>");
out.println("photo: <INPUT type=\"file\" name=\"content\">");
out.println("<br> <br>");
out.println(ItemBaseHtml.getCatalogsForAdmin());
out.println("<INPUT type=\"submit\" value=\"Submit\">");
out.println("</FORM> </body> </html>");

}
}
