package com.arc.guice.handler;

/**
 * Фабрика обработчиков запросов
 */
public interface RequestHandlerFactory<T extends RequestHandler> {
	T createHandler();
}
