package CookiesHandling;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookies extends HttpServlet {

    /*
     to delete cookie you need to know which one you want  to delete, then we set its max age to zero
     and as we did before in reading  cookie we do the same in deleting but we will add 2 steps 
     1- set max age to zero 
     2- add this editing cookie to the HTTPServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        //get an arrayy of the cookies associated with this domain
        cookies = req.getCookies();

        // set response content type 
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Delete Cookies Example";
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
        if (cookies != null) {
            out.println("<h1> Found Cookies </h1>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().compareTo("first_name") == 0) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    out.println("Deleted Cookies : " + cookie.getName()
                            + "<br/>");
                }
                out.println("Name : " + cookie.getName() + ", ");
                out.println("Value : " + cookie.getValue() + "<br/> ");
            }
        } else {
            out.println(
                    "<h2>No cookies founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }

    @Override
    public void destroy() {
    }
}
