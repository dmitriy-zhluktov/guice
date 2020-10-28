package com.arc.app;

import com.arc.guice.handler.RequestHandler;
import com.arc.guice.handler.RequestHandlerFactory;
import com.arc.request.Request;
import com.arc.request.RequestType;
import com.google.inject.Inject;

import java.util.Map;

/**
 * Определитель типа запроса
 */
public class RequestTypeSpecifier
{
	private final Map<RequestType, RequestHandlerFactory> requestHandlerFactory;

	@Inject
	public RequestTypeSpecifier(Map<RequestType, RequestHandlerFactory> requestHandlerFactory) {
		this.requestHandlerFactory = requestHandlerFactory;
	}

	public void delegateRequest(Request request) {
		RequestHandler requestHandler = requestHandlerFactory.get(request.getRequestType()).createHandler();
		requestHandler.handleRequest(request);
	}
}
