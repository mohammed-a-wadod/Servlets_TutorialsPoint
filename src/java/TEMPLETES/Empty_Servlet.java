package TEMPLETES;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Empty_Servlet extends HttpServlet {
/* 
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "";
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title></title>");            
    out.println("</head>");
    out.println("<body>");
    out.println("<body>");
    out.println("<h1>" + "</h1>");
    out.println("</body>");
    out.println("</html>"); 
*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
