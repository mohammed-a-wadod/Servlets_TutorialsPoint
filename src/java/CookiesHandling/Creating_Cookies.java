
package CookiesHandling;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Creating_Cookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //setp 1 creat cookie
        Cookie firstName =  new Cookie("first_name", request.getParameter("FName"));
        Cookie secondName =  new Cookie("second_name", request.getParameter("LName"));
        
        //step 2 set max age
        firstName.setMaxAge(60*60);
        secondName.setMaxAge(60*60);
        
        //step 3 add cookie to response 
        response.addCookie(firstName);
        response.addCookie(secondName);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("First Name : " + request.getParameter("FName") + "<br/>");
        out.println("Second Name: " + request.getParameter("LName"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
