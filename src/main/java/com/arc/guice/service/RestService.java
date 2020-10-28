package com.arc.guice.service;

import com.google.inject.Singleton;

/**
 * Сервис обработки REST-запросов
 */
@Singleton
public class RestService extends RequestService
{
	@Override
	public void doWork(String messageBody) {
		System.out.println(getClass() + " handling request " + messageBody);
	}
}
