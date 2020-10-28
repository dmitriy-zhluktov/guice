package com.arc.guice.service;

/**
 * Сервис обработки MQ-запросов
 */
public class MQService
{
	public void doWork(String messageBody) {
		System.out.println(getClass() + " handling request " + messageBody);
	}
}
