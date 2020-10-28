package com.arc.app;

import com.arc.guice.handler.MQRequestHandler;
import com.arc.guice.handler.RequestHandler;
import com.arc.guice.handler.RestRequestHandler;
import com.arc.request.Request;
import com.arc.request.RequestType;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Определитель типа запроса
 */
public class RequestTypeSpecifier
{
	private RequestHandler requestHandler;
	private Provider<RestRequestHandler> restRequestHandlerProvider;
	private Provider<MQRequestHandler> mqRequestHandlerProvider;

	@Inject
	public RequestTypeSpecifier(Provider<RestRequestHandler> restRequestHandlerProvider, Provider<MQRequestHandler> mqRequestHandlerProvider) {
		this.restRequestHandlerProvider = restRequestHandlerProvider;
		this.mqRequestHandlerProvider = mqRequestHandlerProvider;
	}

	public void delegateRequest(Request request) {
		if (request.getRequestType() == RequestType.REST) {
			requestHandler = restRequestHandlerProvider.get();
		} else {
			requestHandler = mqRequestHandlerProvider.get();
		}
		requestHandler.handleRequest(request);
	}
}
