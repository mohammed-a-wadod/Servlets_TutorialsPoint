/*
Creating filter on one servler, group of servlers or all of my servlets
I make filters for the following issues :
    To intercept requests from a client before they access a resource at back end.
    To manipulate responses from server before they are sent back to the client.
it's life cycle is similar to servlet life cycle, and we must add it to web.xml
 */
package Filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        String testParam = config.getInitParameter("test-param");
        System.out.println("Test param : " + testParam);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String ipAddress = request.getRemoteAddr();
        System.out.println("IP : " + ipAddress + " ,Time : " + new Date().toString());
    }

    @Override
    public void destroy() {
    }
}
