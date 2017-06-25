package com.custom.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * http://localhost:8081/jspCustomTag/demo3.jsp
 * @author weineng
 *
 */
@SuppressWarnings("serial")
public class SkipPageOrEvalPageTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		// 该属性是http请求头中的属性，可以通过该属性垃圾判断是从哪个页面连接过来的，只有通过超链接或者表单链接的方式，该属性才会有效
		String referer = request.getHeader("referer");
		String url = "http://" + request.getServerName();
		// 判断是通过浏览器还是通过超链接来进行访问 url为本站链接
		if (referer != null && referer.startsWith(url)) {
			return EVAL_PAGE;
		} else {
			try {
				pageContext.getOut().print("不能访问");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SKIP_PAGE;
		}
	}

}
