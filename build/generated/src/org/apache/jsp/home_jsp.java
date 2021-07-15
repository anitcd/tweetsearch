package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.FileWriter;
import java.io.File;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Search Tweets</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            footer {\n");
      out.write("                position:fixed;\n");
      out.write("                //height:50px;\n");
      out.write("                background-color: #c0deed; /* #c0deed #c0deed */\n");
      out.write("                bottom: 10px;\n");
      out.write("                left:0px;\n");
      out.write("                right:0px;\n");
      out.write("                margin-bottom:4px;\n");
      out.write("                text-align: right;\n");
      out.write("                padding-top: 2px;\n");
      out.write("                padding-bottom: 2px;\n");
      out.write("                padding-right: 20px;\n");
      out.write("            }\n");
      out.write("            footer1 {\n");
      out.write("                position:fixed;\n");
      out.write("                //height:50px;\n");
      out.write("                background: #001428 url('images/blue6.png') top left repeat-x;\n");
      out.write("                background-size: contain;\n");
      out.write("                color: white;\n");
      out.write("                bottom:0px;\n");
      out.write("                left:0px;\n");
      out.write("                right:0px;\n");
      out.write("                margin-bottom:0px;\n");
      out.write("                text-align: center;\n");
      out.write("                padding-top: 4px;\n");
      out.write("                padding-bottom: 4px;\n");
      out.write("                padding-right: 5%;\n");
      out.write("                font-size: 60%;\n");
      out.write("            }            \n");
      out.write("            container {\n");
      out.write("                width: 75%;\n");
      out.write("            }\n");
      out.write("            searchBar {\n");
      out.write("                position: fixed;\n");
      out.write("                //left:0px;\n");
      out.write("                //right:0px;\n");
      out.write("                background-color: transparent;\n");
      out.write("                color: white;\n");
      out.write("                //padding: 10px;\n");
      out.write("                //width: 80%;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String uid = request.getParameter("uid");
            
            // writing the uID into the file uid.txt
            try {
                if(Integer.parseInt(uid) >= 100 && Integer.parseInt(uid) <= 150) {
                    //File file = new File("/store/Data/TweetData/TwarcDump/log/uid.txt");       // from Local
                    File file = new File("/home/achakrab/TweetUserStudy/uid.txt");       // from achakrab@vma57.scss.tcd.ie
                    file.createNewFile();
                    FileWriter writer = new FileWriter(file);

                    writer.write(uid + "\n");
                    writer.close();
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        
      out.write("\n");
      out.write("\n");
      out.write("<!--        <footer>footer</footer>-->\n");
      out.write("        <form action=\"search.jsp\">\n");
      out.write("\n");
      out.write("            <div style=\"position: absolute; top:0px; left:0px;\"><img src=\"./images/TCD_logo.jpg\" width=\"30%\" height=\"30%\" align=\"left\">\n");
      out.write("            <!-- <footer><div style=\"position: fixed; bottom: 0px; right: 0px; padding: 0px;\"><img src=\"./images/ADAPT.png\" width=\"10%\" height=\"60%\" align=\"rigt\"></footer> -->\n");
      out.write("            <footer><img src=\"./images/ADAPT.png\" width=\"8%\"></footer>\n");
      out.write("            <footer1>Developed by Anirban</footer1>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <!-- PP <h1 style=\"color: #00aced; position: relative; alignment-adjust: central; top: 230px\">Search for Tweets...</h1> -->\n");
      out.write("            \n");
      out.write("<!--                left: 530px; top: 230px;-->\n");
      out.write("            <!-- PP <div style=\"position: absolute; top:300px; left:350px;\"><input type=\"text\" name=\"query\" id=\"query\" style=\" width:600px; height:35px; font-size: 26px; border: 1px solid; background-color: AliceBlue;\" required></div> -->\n");
      out.write("            <searchBar><input type=\"text\" name=\"query\" placeholder=\"Search for Tweets...\" style=\" width:500px; height:35px; font-size: 26px; border: 1px solid grey; background-color: AliceBlue; margin-top: 58%; border-radius: 8px 8px 8px 8px;\" required> <input type=\"image\" src=\"./images/Twitter_bird_logo.png\" alt=\"Search\" height=\"35px\" style=\"margin-top: 58%; float: right;\"></searchBar>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <!-- PP <div style=\"position: absolute; top:300px; left:970px;\"><input type=\"image\" src=\"./images/Twitter_bird_logo.png\" alt=\"Search\" height=35px> -->\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        \n");
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
