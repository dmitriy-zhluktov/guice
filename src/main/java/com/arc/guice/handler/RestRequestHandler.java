package com.arc.guice.handler;

import com.arc.guice.service.RequestService;
import com.arc.guice.service.RestService;
import com.arc.request.Request;
import com.arc.request.RequestType;
import com.google.inject.Inject;

/**
 * Обработчик REST-запросов
 */
public class RestRequestHandler extends RequestHandler
{
	private RequestService service;

	@Inject
	public RestRequestHandler(RestService service) {
		this.service = service;
	}

	@Override
	public void handleRequest(Request request)
	{
		checkRequestType(request.getRequestType(), RequestType.REST);
		service.doWork(request.getRequestBody());
	}
}
