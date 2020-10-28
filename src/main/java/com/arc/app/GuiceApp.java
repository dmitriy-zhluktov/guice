package com.arc.app;

import com.arc.request.Request;
import com.arc.request.RequestType;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceApp
{
	public static void main(String[] args) {
		Injector injector = Guice.createInjector();
		RequestTypeSpecifier requestTypeSpecifier = injector.getInstance(RequestTypeSpecifier.class);

		Request request = new Request(RequestType.REST, "some rest text");
		requestTypeSpecifier.delegateRequest(request);

		request = new Request(RequestType.MQ, "some mq text");
		requestTypeSpecifier.delegateRequest(request);
	}
}
