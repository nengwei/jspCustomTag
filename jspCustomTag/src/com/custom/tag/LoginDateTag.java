package com.custom.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义时间标签在页面显示
 * 
 * @author weineng
 *
 */
@SuppressWarnings("serial")
public class LoginDateTag extends TagSupport {

	public int doStartTag() throws JspException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = simpleDateFormat.format(new Date());
		try {
			pageContext.getOut().print(dateStr);//
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
