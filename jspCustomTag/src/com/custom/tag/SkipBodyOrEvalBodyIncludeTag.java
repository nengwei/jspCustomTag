package com.custom.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 是否执行标签体内容
 * @author weineng
 *http://localhost:8081/jspCustomTag/demo1.jsp?name=weineng
 */
@SuppressWarnings("serial")
public class SkipBodyOrEvalBodyIncludeTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		String name = pageContext.getRequest().getParameter("name");
		if (name != null && name.equals("weineng")) {
			return EVAL_BODY_INCLUDE;//执行标签体
		} else {
			return SKIP_BODY;//跳出标签体
		}
 	}

}
