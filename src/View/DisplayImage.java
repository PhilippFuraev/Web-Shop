
package View;
import Model.*;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class DisplayImage extends HttpServlet {  
  
    public void doGet(HttpServletRequest request,HttpServletResponse response)  
             throws IOException  
    { 
 String uri = request.getRequestURI();
    response.setContentType("image/jpeg");  
    ServletOutputStream out;  
    out = response.getOutputStream();
 String lastUri = ItemBase.lastUri(uri);
makeImage(lastUri, out);

}
public static void makeImage(String imageNumber, ServletOutputStream out) throws IOException
{
FileInputStream fin = new FileInputStream("../webapps/Web-shop/Images/" + imageNumber + ".jpg");
BufferedInputStream bin = new BufferedInputStream(fin);
    BufferedOutputStream bout = new BufferedOutputStream(out);  
    int ch =0; ;  
    while((ch=bin.read())!=-1)  
    {  
    bout.write(ch);  
    }

      
    bin.close();  
    fin.close();  
    bout.close();  
    out.close();  
}
     
}  
