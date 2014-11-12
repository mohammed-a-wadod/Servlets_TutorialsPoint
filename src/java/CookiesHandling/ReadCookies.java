package CookiesHandling;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        //get an arrayy of the cookies associated with this domain
        cookies = request.getCookies();

        // set response content type 
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Reading Cookies Example";
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
        if (cookies != null) {
            out.println("<h2> Found Cookies Names and values " + "</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.println("Name : " + cookie.getName() + ", ");
                out.println("Value : " + cookie.getValue() + "<br/> ");
            }
        } else {
            out.println("<h2> No cookies found </h2>");
        }
        out.println("</body>");
        out.println("</html>");
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
