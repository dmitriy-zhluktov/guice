package com.arc.guice.handler;

import com.arc.request.Request;
import com.arc.request.RequestType;

/**
 * Базовый обработчик запросов
 */
public abstract class RequestHandler
{
	private static final String ILLEGAL_ARGUMENT_MESSAGE = "Неверный типа запроса %s, ожидаемый тип запроса %s";
	public abstract void handleRequest(Request request);

	void checkRequestType(RequestType actualRqType, RequestType expectedRqType) {
		if (actualRqType != expectedRqType)
		{
			throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_MESSAGE, actualRqType, expectedRqType));
		}
	}
}
