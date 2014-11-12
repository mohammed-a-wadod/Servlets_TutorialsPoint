/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionTracker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Create a session object if it is not already created
        HttpSession session = req.getSession(true);
        //get session creation time
        Date createTime = new Date(session.getCreationTime());
        //get last access time of this web page 
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String title = "Welcome back to my website";
        Integer visitCount = new Integer(0);
        String VistCountKey = new String("visitCount");
        String userIDKey = new String("userID");
        String userID = new String("ABCD");
        //check if this is new comer on your web page 
        if (session.isNew()) {
            title = "welcoem to my website";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer) session.getAttribute(VistCountKey);
            visitCount = visitCount + 1;
            userID = (String) session.getAttribute(userIDKey);
        }
        session.setAttribute(VistCountKey, visitCount);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>"
                + "<link href=\"resource/css/bootstrap.css\" rel=\"stylesheet\">");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align = \"center\" >" + title + "</h1>\n");
        out.println("<h2 align = \"center\" > Session Information </h2>\n");
        out.println("<table align =\"center\" class=\"table table-bordered table-hover\">\n"
                + "<tr>"
                + "<th>Session Info</th><th>value</th></tr>\n"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>id</td>"
                + "<td>" + session.getId() + "</td>"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>Creation time</td>"
                + "<td>" + session.getCreationTime() + "</td>"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>Time of last access</td>"
                + "<td>" + session.getLastAccessedTime() + "</td>"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>ID</td>"
                + "<td>" + userID + "</td>"
                + "</tr>\n"
                + "<tr>\n"
                + "<td>Number of visits</td>"
                + "<td>" + visitCount + "</td>"
                + "</tr>\n"
                + "</tbale>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");
    }

}
