package org.apache.jsp.view.client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"../../css/authen.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src='https://kit.fontawesome.com/a076d05399.js'></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Authen form -->\n");
      out.write("        <form action=\"../../login\" method=\"post\">\n");
      out.write("            <div class=\"auth-form\">\n");
      out.write("                <div class=\"auth-form-container\">\n");
      out.write("                    <div class=\"auth-form-header\">\n");
      out.write("                        <h3 class=\"auth-form-title\">Login</h3>\n");
      out.write("                        <a href=\"register.jsp\" class=\"auth-form-subtitle\">Register</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"auth-form-form\">\n");
      out.write("                        <div class=\"auth-form-group\">\n");
      out.write("                            <input class=\"auth-form-input\" type=\"text\" name=\"username\"\n");
      out.write("                                   placeholder=\"Username\" required=\"required\" />\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"auth-form-group\">\n");
      out.write("                            <input class=\"auth-form-input\" type=\"password\" name=\"password\"\n");
      out.write("                                   placeholder=\"Password\" required=\"required\" />\n");
      out.write("                        </div>\n");
      out.write("                        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                        <div class=\"\" style=\"display: flex; justify-content: space-between; margin-top: -30px; margin-bottom: 20px;\">\n");
      out.write("                            <div><input type=\"checkbox\" name=\"remember\"/> Remember me</div>\n");
      out.write("                            <div><a href=\"#\">Forgot password</a></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"auth-form-controls\">\n");
      out.write("                        <a href=\"home.jsp\" class=\"btn\">Back</a>\n");
      out.write("                        <button type=\"submit\" class=\"btn\">Login</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"auth-form-social\">\n");
      out.write("                    <a href=\"#\" class=\"btn-social-fb\"><i class='fab' style=\"font-size: 20px;\">&#xf09a;</i> Login With Facebook </a>\n");
      out.write("                    <a href=\"#\" class=\"btn-social-gg\"><i class='fab' style='font-size:20px; color: tomato'>&#xf2b3;</i> Login With Google </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
