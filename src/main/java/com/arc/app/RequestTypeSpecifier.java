package com.arc.app;

import com.arc.guice.handler.MQRequestHandler;
import com.arc.guice.handler.RequestHandler;
import com.arc.guice.handler.RestRequestHandler;
import com.arc.request.Request;
import com.arc.request.RequestType;

/**
 * Определитель типа запроса
 */
public class RequestTypeSpecifier
{
	private RequestHandler requestHandler;

	public RequestTypeSpecifier() {
	}

	public void delegateRequest(Request request) {
		if (request.getRequestType() == RequestType.REST) {
			requestHandler = new RestRequestHandler();
		} else {
			requestHandler = new MQRequestHandler();
		}
		requestHandler.handleRequest(request);
	}
}
