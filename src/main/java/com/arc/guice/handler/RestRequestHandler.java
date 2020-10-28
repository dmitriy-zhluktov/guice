package com.arc.guice.handler;

import com.arc.guice.service.RestService;
import com.arc.request.Request;
import com.arc.request.RequestType;

/**
 * Обработчик REST-запросов
 */
public class RestRequestHandler extends RequestHandler
{
	private RestService service;

	@Override
	public void handleRequest(Request request)
	{
		checkRequestType(request.getRequestType(), RequestType.REST);
		service = new RestService();
		service.doWork(request.getRequestBody());
	}
}
