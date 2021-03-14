package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/headerAdmin.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_end_begin.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\" style=\"max-width: 1200px; margin: auto;\">\n");
      out.write("            ");
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
      out.write("        <div style=\"max-width: 1200px;\">\n");
      out.write("            <!-- NAVBAR -->\n");
      out.write("            <nav class=\"navbar navbar-default navbar-fixed-top\" style=\"max-width: 1150px; margin: auto;\">\n");
      out.write("                <div class=\"brand\">\n");
      out.write("                    <img src=\"images/home/logo-shop.jpg\" alt=\"\" \n");
      out.write("                         style=\"width: 30%; margin-top: -20px; margin-bottom: -18px;\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div id=\"navbar-menu\">\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"homeAdmin.jsp\">\n");
      out.write("                                    <i class=\"fa fa-home\" style=\"font-size: 18px;\"></i><span> Home</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <img src=\"assets/img/user.png\" class=\"img-circle\" alt=\"Avatar\">\n");
      out.write("                                    <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"logout\">\n");
      out.write("                                    <i class=\"material-icons\" style=\"color: red;\">&#xe8ac;</i><span>Logout</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <!-- END NAVBAR -->\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            <!-- MAIN -->\n");
      out.write("            <!-- MAIN CONTENT -->\n");
      out.write("            <div class=\"main-content\" style=\"margin-top: 80px;\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <!-- OVERVIEW -->\n");
      out.write("                    <div class=\"panel panel-headline\">\n");
      out.write("                        <div class=\"panel-body\" style=\"padding-top: 20px;\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <div class=\"panel\">\n");
      out.write("                                        <div class=\"panel-heading\">\n");
      out.write("                                            <h3 class=\"panel-title\">List Users</h3>\n");
      out.write("                                            <div class=\"right\">\n");
      out.write("                                                <a href=\"\"><span class=\"label label-danger\" style=\"font-size: 15px; margin-right: 15px;\">Delete</span></a>\n");
      out.write("                                                <a href=\"\"><span class=\"label label-success\" style=\"font-size: 15px;\">Create new account</span></a>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"panel-body no-padding\">\n");
      out.write("                                            <table class=\"table table-striped\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <th><input type=\"checkbox\"/></th>\n");
      out.write("                                                        <th>User ID</th>\n");
      out.write("                                                        <th>Username</th>\n");
      out.write("                                                        <th>Password</th>\n");
      out.write("                                                        <th>FullName</th>\n");
      out.write("                                                        <th>Phone</th>\n");
      out.write("                                                        <th>Address</th>\n");
      out.write("                                                        <th>Gender</th>\n");
      out.write("                                                        <th>Role</th>\n");
      out.write("                                                        <th>Edit</th>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <nav aria-label=\"Page navigation example\" style=\"margin-top: -20px;\">\n");
      out.write("                                        <ul class=\"pagination\">\n");
      out.write("                                            <li class=\"page-item\">\n");
      out.write("                                                <a class=\"page-link\" href=\"#\" aria-label=\"Previous\">\n");
      out.write("                                                    <span aria-hidden=\"true\">&laquo;</span>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">1</a></li>\n");
      out.write("                                            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">2</a></li>\n");
      out.write("                                            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">3</a></li>\n");
      out.write("                                            <li class=\"page-item\">\n");
      out.write("                                                <a class=\"page-link\" href=\"#\" aria-label=\"Next\">\n");
      out.write("                                                    <span aria-hidden=\"true\">&raquo;</span>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </nav>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <footer>\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <p class=\"copyright\">&copy; 2017 <a href=\"https://www.themeineed.com\" target=\"_blank\">Theme I Need</a>. All Rights Reserved.</p>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setBegin(1);
    _jspx_th_c_forEach_0.setEnd(10);
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                        <tr>\n");
          out.write("                                                            <td><input type=\"checkbox\"/></td>\n");
          out.write("                                                            <td><a href=\"#\">763652</a></td>\n");
          out.write("                                                            <td>Smith</td>\n");
          out.write("                                                            <td>362</td>\n");
          out.write("                                                            <td>Mr.A Name</td>\n");
          out.write("                                                            <td>0948463845</td>\n");
          out.write("                                                            <td>FPT University - Thach Hoa - Thach That</td>\n");
          out.write("                                                            <td>Female</td>\n");
          out.write("                                                            <td>ROLE_user</td>\n");
          out.write("                                                            <td><a href=\"\"><span class=\"label label-warning\" style=\"font-size: 13px;\">Update</span></a></td>\n");
          out.write("                                                        </tr>\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
