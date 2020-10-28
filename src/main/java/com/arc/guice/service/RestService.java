package com.arc.guice.service;

/**
 * Сервис обработки REST-запросов
 */
public class RestService
{
	public void doWork(String messageBody) {
		System.out.println(getClass() + " handling request " + messageBody);
	}
}
