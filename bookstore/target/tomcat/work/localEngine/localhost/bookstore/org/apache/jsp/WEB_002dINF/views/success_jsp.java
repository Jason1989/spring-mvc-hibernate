package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel='stylesheet prefetch'\r\n");
      out.write("\thref='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>\r\n");
      out.write("<link rel=\"stylesheet\" href='");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t$().ready(function() {\r\n");
      out.write("\t\tjQuery.validator.addMethod(\"cdnPostal\", function(postal, element) {\r\n");
      out.write("\t\t    return this.optional(element) || \r\n");
      out.write("\t\t    postal.match(/[a-zA-Z][0-9][a-zA-Z](-| |)[0-9][a-zA-Z][0-9]/);\r\n");
      out.write("\t\t}, \"Please specify a valid postal code.\");\r\n");
      out.write("\t\t$(\"#zipform\").validate({\r\n");
      out.write("\r\n");
      out.write("\t\t\t// Specify the validation rules\r\n");
      out.write("\t\t\trules : {\r\n");
      out.write("\t\t\t\tzipcode : {\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\tminlength : 5,\r\n");
      out.write("\t\t\t\t\tmaxlength : 5\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessages : {\r\n");
      out.write("\t\t\t\tzipcode : {\r\n");
      out.write("\t\t\t\t\trequired : \"Please type a valid zip code.\",\r\n");
      out.write("\t\t\t\t\tminlength : \"Zip code has to be 5 digits long.\",\r\n");
      out.write("\t\t\t\t\tmaxlength : \"Zip code has to be 5 digits long.\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsubmitHandler : function(form) {\r\n");
      out.write("\t\t\t\tgetWeather();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getWeather() {\r\n");
      out.write("\r\n");
      out.write("\t\tvar zipcode = document.getElementById(\"zipcode\").value;\r\n");
      out.write("\t\tvar woeid;\r\n");
      out.write("\t\tvar country;\r\n");
      out.write("\t\tvar city;\r\n");
      out.write("\t\tvar state;\r\n");
      out.write("\t\tvar whr = new XMLHttpRequest();\r\n");
      out.write("\t\tvar url = \"https://query.yahooapis.com/v1/public/yql?q=SELECT * FROM geo.places WHERE text = \"\r\n");
      out.write("\t\t\t\t+ zipcode\r\n");
      out.write("\t\t\t\t+ \" Limit 1&format=json&env=store://datatables.org/alltableswithkeys\";\r\n");
      out.write("\t\twhr.open(\"GET\", url, true);\r\n");
      out.write("\t\twhr.send();\r\n");
      out.write("\t\twhr.onreadystatechange = function() {\r\n");
      out.write("\t\t\tif (whr.readyState == 4 && whr.status == 200) {\r\n");
      out.write("\t\t\t\tvar w = JSON.parse(whr.responseText);\r\n");
      out.write("\t\t\t\tcountry = w.query.results.place.country.code;\r\n");
      out.write("\t\t\t\tstate = w.query.results.place.admin1.content;\r\n");
      out.write("\t\t\t\tcity = w.query.results.place.locality1.content;\r\n");
      out.write("\t\t\t\twoeid = w.query.results.place.woeid;\r\n");
      out.write("\t\t\t\tvar xhr = new XMLHttpRequest();\r\n");
      out.write("\t\t\t\txhr\r\n");
      out.write("\t\t\t\t\t\t.open(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"GET\",\r\n");
      out.write("\t\t\t\t\t\t\t\t\"https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where woeid = \"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ woeid\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"&format=json&env=store://datatables.org/alltableswithkeys\",\r\n");
      out.write("\t\t\t\t\t\t\t\ttrue);\r\n");
      out.write("\t\t\t\txhr.send();\r\n");
      out.write("\t\t\t\txhr.onreadystatechange = function() {\r\n");
      out.write("\t\t\t\t\tif (xhr.readyState == 4 && xhr.status == 200) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\tvar w = JSON.parse(xhr.responseText);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"weather\").innerHTML = \"<table  class=\\\"rwd-table\\\">\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<th>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ country\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"\\t\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ state\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"\\t\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ city\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</th>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<tr><td> Current Temp is \"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ w.query.results.channel.item.condition.temp\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"  degrees\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td></tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<tr><td> Current wind chill is \"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ w.query.results.channel.wind.chill\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td></tr></table>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t;\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t;\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"login-card\">\r\n");
      out.write("\t\t<h1>Success</h1>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<form id=\"zipform\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"zipcode\" name=\"zipcode\" placeholder=\"Zipcode\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"login-help\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" class=\"login login-submit\"\r\n");
      out.write("\t\t\t\t\tvalue=\"Submit\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"weather\" align=\"center\"></div>\r\n");
      out.write("</body>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/success.jsp(5,29) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/css/style.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}
