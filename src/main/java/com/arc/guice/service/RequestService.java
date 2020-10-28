package com.arc.guice.service;

/**
 * Базовый сервис для работы с данными запросов
 */
public abstract class RequestService
{
	public abstract void doWork(String messageBody);
}
