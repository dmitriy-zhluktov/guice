package com.arc.guice.handler;

import com.arc.guice.service.MQService;
import com.arc.request.Request;
import com.arc.request.RequestType;

/**
 * Обработчик MQ-запросов
 */
public class MQRequestHandler extends RequestHandler
{
	private MQService service;

	@Override
	public void handleRequest(Request request)
	{
		checkRequestType(request.getRequestType(), RequestType.MQ);
		service = new MQService();
		service.doWork(request.getRequestBody());
	}
}
