package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class categoiriesAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <title>Dashboard | Klorofil - Free Bootstrap Dashboard Template</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\n");
      out.write("        <!-- VENDOR CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/linearicons/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendor/chartist/css/chartist-custom.css\">\n");
      out.write("        <!-- MAIN CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/main.css\">\n");
      out.write("        <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/demo.css\">\n");
      out.write("        <!-- GOOGLE FONTS -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\n");
      out.write("        <!-- ICONS -->\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/img/favicon.png\">\n");
      out.write("        <script src='https://kit.fontawesome.com/a076d05399.js'></script>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- LEFT SIDEBAR -->\n");
      out.write("        <div id=\"sidebar-nav\" class=\"sidebar\" th:fragment=\"categories\">\n");
      out.write("            <div class=\"sidebar-scroll\" style=\"padding-top: 20px;\">\n");
      out.write("                <nav>\n");
      out.write("                    <ul class=\"nav\">\n");
      out.write("                        <li><a th:href=\"@{/homeAdmin}\" class=\"\"><i class=\"lnr lnr-home\"></i> <span>Trang Chủ</span></a></li>\n");
      out.write("                        <li><a href=\"panels.html\" class=\"\"><i class=\"lnr lnr-cart\"></i> <span>Tạo đơn hàng</span></a></li>\n");
      out.write("                        <li><a th:href=\"@{/listProduct}\" class=\"\"><i class=\"lnr lnr-gift\"></i> <span>Sản phẩm</span></a></li>\n");
      out.write("                        <li><a th:href=\"@{/listUser}\" class=\"\"><i class=\"lnr lnr-users\"></i> <span>Người dùng</span></a></li>\n");
      out.write("                        <li><a th:href=\"@{/listOrder}\" class=\"\"><i class=\"lnr lnr lnr-dice\"></i> <span>Chi tiết đơn hàng</span></a></li>\n");
      out.write("                        <li><a href=\"elements.html\" class=\"\"><i class=\"lnr lnr-code\"></i> <span>Tổng thu nhập</span></a></li>\n");
      out.write("                        <li><a href=\"tables.html\" class=\"\"><i class=\"lnr lnr-store\"></i> <span>Vào cửa hàng</span></a></li>\n");
      out.write("                        <li><a href=\"panels.html\" class=\"\"><i class=\"lnr lnr-cog\"></i> <span>Thiết lập</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- END LEFT SIDEBAR -->\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
