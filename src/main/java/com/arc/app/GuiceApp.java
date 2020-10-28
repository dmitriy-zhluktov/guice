package com.arc.app;

import com.arc.request.Request;
import com.arc.request.RequestType;

public class GuiceApp
{
	public static void main(String[] args) {
		Request request = new Request(RequestType.REST, "some text");
	}
}
