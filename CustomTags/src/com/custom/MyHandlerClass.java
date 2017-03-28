package com.custom;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyHandlerClass extends TagSupport{
	private int number;
	private static final long serialVersionUID = 1L;
	public void setNumber(int number){
		this.number=number;
	}

	public int doStartTag(){
		JspWriter out=pageContext.getOut();
		try {
			out.print("Welcome to custom tags"+"<br/>");
			out.print(number*number*number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
		
	}

}
