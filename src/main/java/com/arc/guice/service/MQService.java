package com.arc.guice.service;

import com.google.inject.Singleton;

/**
 * Сервис обработки MQ-запросов
 */
public class MQService extends RequestService
{
	@Override
	public void doWork(String messageBody) {
		System.out.println(getClass() + " handling request " + messageBody);
	}
}
