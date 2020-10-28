package com.arc.app;

import com.arc.request.Request;
import com.arc.request.RequestType;

public class GuiceApp
{
	public static void main(String[] args) {
		RequestTypeSpecifier requestTypeSpecifier = new RequestTypeSpecifier();

		Request request = new Request(RequestType.REST, "some rest text");
		requestTypeSpecifier.delegateRequest(request);

		request = new Request(RequestType.MQ, "some mq text");
		requestTypeSpecifier.delegateRequest(request);
	}
}
