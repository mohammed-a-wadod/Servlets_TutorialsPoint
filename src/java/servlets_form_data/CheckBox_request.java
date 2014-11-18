package servlets_form_data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckBox_request extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
         * as we do by using getParameter method in the GET_Method class we can use the same way 
         * but here we want to use other way to read all parameters coming for CHECKBOX form
         */
        PrintWriter out = resp.getWriter();
        read_CheckBox_Single_Value(req, resp); // here we are using the old Way which in the GET_method Class
        out.println("<hr/>");
        out.println("<h1> Using Enumeration"+ "</h1>");
        read_CheckBox_All_Values(req, resp); // here we are reading all the values
    }

    private void read_CheckBox_Single_Value(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Me : " + req.getParameter("Me") + "<br>");
        out.println("Here : " + req.getParameter("Here") + "<br>");
        out.println("There : " + req.getParameter("There") + "<br>");        
    }

    private void read_CheckBox_All_Values(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        //creating Enumeration which takes all paramter names from request
        Enumeration paramNames = req.getParameterNames();
        //use hasMoreELements to move arround this enum
        while (paramNames.hasMoreElements()) {
            //get the first emum element which represent the name pass through the request
            String paramName = (String) paramNames.nextElement();
            //here i don't know if this paramter carry one value or more 
            //so i will use getPrameterValues which return array of values
            String[] paramValues = req.getParameterValues(paramName);
            //check if hte paramValues has one element or not
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                //here check if this value.length==0 then we don't have value
                if (paramValue.length() == 0) {
                    out.println("No Value <br>");
                } else {
                    out.println(paramName + " : " + paramValue + "<br>");
                }
            } else {
                // here we have more than one element in the paramValues 
                //so i need to loop on in it
                for (int i = 1; i < paramValues.length; i++) {
                    out.println(paramName + " : " + paramValues[i] + "<br>");
                }
            }
        }
    }

}
