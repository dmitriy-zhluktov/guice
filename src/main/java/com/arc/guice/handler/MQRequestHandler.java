package com.arc.guice.handler;

import com.arc.guice.service.MQService;
import com.arc.guice.service.RequestService;
import com.arc.request.Request;
import com.arc.request.RequestType;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Обработчик MQ-запросов
 */
@Singleton
public class MQRequestHandler extends RequestHandler
{
	private RequestService service;

	@Inject
	public MQRequestHandler(MQService service) {
		this.service = service;
	}


	@Override
	public void handleRequest(Request request)
	{
		checkRequestType(request.getRequestType(), RequestType.MQ);
		service.doWork(request.getRequestBody());
	}
}
