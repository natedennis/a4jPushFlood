package org.monarchnc.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.DispatcherType;

@WebFilter(urlPatterns = "/global/*", description = "Monarch Push Filter", asyncSupported = true, dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD })
public class MonarchPushFilter implements Filter {
   private FilterConfig config = null;

   public void init(FilterConfig config) throws ServletException {
       this.config = config;
       config.getServletContext().log("Monarch Push Filter");
   }

   public void doFilter(ServletRequest req, ServletResponse res,
                        FilterChain chain)
           throws ServletException, IOException {

       HttpServletRequest request = (HttpServletRequest) req;
       HttpServletResponse response = (HttpServletResponse) res;

       //
       // Check to see if user's session attribute contains an attribute
       // named AUTHENTICATED. If the attribute is not exists redirect
       // user to the login page.
       //
       /*if (!request.getRequestURI().endsWith("login.xhtml") &&
               request.getSession().getAttribute("AUTHENTICATED") == null) {
           response.sendRedirect(request.getContextPath() + "/login.xhtml");
       }*/
       chain.doFilter(req, res);
   }

   public void destroy() {
       config.getServletContext().log("Destroying Monarch Push Filter");
   }
}