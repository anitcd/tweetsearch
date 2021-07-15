package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Register</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            /*--------------------------------------------------------------\n");
      out.write("            1.0 - BASE SITE STYLES\n");
      out.write("            --------------------------------------------------------------*/\n");
      out.write("            *,*:after,*:before {\n");
      out.write("              box-sizing:border-box;\n");
      out.write("              -moz-box-sizing:border-box;\n");
      out.write("              -webkit-box-sizing:border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .cf:before,\n");
      out.write("            .cf:after {\n");
      out.write("                content:\"\";\n");
      out.write("                display:table;\n");
      out.write("            }\n");
      out.write("            .cf:after {\n");
      out.write("                clear:both;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("              background: #3aaae8;\n");
      out.write("              color: #fff;\n");
      out.write("              font:12px/18px 'HelveticaNeue', Helvetica, Arial, sans-serif;\n");
      out.write("            }\n");
      out.write("            a,a:visited {\n");
      out.write("              color:#fff\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*--------------------------------------------------------------\n");
      out.write("            2.0 - SEARCH FORM\n");
      out.write("            --------------------------------------------------------------*/\n");
      out.write("            .searchform {\n");
      out.write("              background:#f4f4f4;\n");
      out.write("              background:rgba(244,244,244,.79);\n");
      out.write("              border: 1px solid #d3d3d3;\n");
      out.write("                    left: 50%;\n");
      out.write("              padding: 2px 5px;\n");
      out.write("              position: absolute;\n");
      out.write("                    margin: -22px 0 0 -170px;\n");
      out.write("                    top: 50%;\n");
      out.write("              width:339px;\n");
      out.write("              box-shadow:0 4px 9px rgba(0,0,0,.37);\n");
      out.write("              -moz-box-shadow:0 4px 9px rgba(0,0,0,.37);\n");
      out.write("              -webkit-box-shadow:0 4px 9px rgba(0,0,0,.37);\n");
      out.write("              border-radius: 10px;\n");
      out.write("              -moz-border-radius: 10px;\n");
      out.write("              -webkit-border-radius: 10px\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .searchform input, .searchform button {\n");
      out.write("                    float: left\n");
      out.write("            }\n");
      out.write("            .searchform input {\n");
      out.write("                    background:#fefefe;\n");
      out.write("                    border: none;\n");
      out.write("                    font:12px/12px 'HelveticaNeue', Helvetica, Arial, sans-serif;\n");
      out.write("                    margin-right: 5px;\n");
      out.write("                    padding: 10px;\n");
      out.write("                    width: 216px;\n");
      out.write("                    box-shadow: 0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);\n");
      out.write("                    -moz-box-shadow: 0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);\n");
      out.write("                    -webkit-box-shadow: 0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);\n");
      out.write("              border-radius: 9px;\n");
      out.write("              -moz-border-radius: 9px;\n");
      out.write("              -webkit-border-radius: 9px\n");
      out.write("            }\n");
      out.write("                    .searchform input:focus {\n");
      out.write("                            outline: none;\n");
      out.write("                            box-shadow:0 0 4px #0d76be inset;\n");
      out.write("                            -moz-box-shadow:0 0 4px #0d76be inset;\n");
      out.write("                            -webkit-box-shadow:0 0 4px #0d76be inset;\n");
      out.write("                    }\n");
      out.write("                    .searchform input::-webkit-input-placeholder {\n");
      out.write("                    font-style: italic;\n");
      out.write("                    line-height: 15px\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    .searchform input:-moz-placeholder {\n");
      out.write("                      font-style: italic;\n");
      out.write("                    line-height: 15px\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("            .searchform button {\n");
      out.write("                    background: rgb(52,173,236);\n");
      out.write("                    background: -moz-linear-gradient(top, rgba(52,173,236,1) 0%, rgba(38,145,220,1) 100%);\n");
      out.write("                    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(52,173,236,1)), color-stop(100%,rgba(38,145,220,1)));\n");
      out.write("                    background: -webkit-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);\n");
      out.write("                    background: -o-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);\n");
      out.write("                    background: -ms-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);\n");
      out.write("                    background: linear-gradient(to bottom, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);\n");
      out.write("                    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#34adec', endColorstr='#2691dc',GradientType=0 );\n");
      out.write("                    border: none;\n");
      out.write("                    color:#fff;\n");
      out.write("                    cursor: pointer;\n");
      out.write("                    font: 13px/13px 'HelveticaNeue', Helvetica, Arial, sans-serif;\n");
      out.write("                    padding: 10px;\n");
      out.write("                    width:106px;\n");
      out.write("                    box-shadow: 0 0 2px #2692dd inset;\n");
      out.write("                    -moz-box-shadow: 0 0 2px #2692dd inset;\n");
      out.write("                    -webkit-box-shadow: 0 0 2px #2692dd inset;\n");
      out.write("              border-radius: 9px;\n");
      out.write("              -moz-border-radius: 9px;\n");
      out.write("              -webkit-border-radius: 9px;\n");
      out.write("            }\n");
      out.write("            .searchform button:hover {\n");
      out.write("                    opacity:.9;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <form class=\"searchform cf\" action=\"home.jsp\">\n");
      out.write("            ");
      out.write("\n");
      out.write("            <input type=\"number\" min=\"100\" max=\"150\" placeholder=\"Enter your user ID\" name=\"uid\" required>\n");
      out.write("            <button type=\"submit\">Submit</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("         \n");
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
