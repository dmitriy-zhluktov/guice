package com.arc.guice.module;

import com.arc.guice.handler.MQRequestHandler;
import com.arc.guice.handler.RequestHandler;
import com.arc.guice.handler.RequestHandlerFactory;
import com.arc.guice.handler.RestRequestHandler;
import com.arc.request.RequestType;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.multibindings.MapBinder;

/**
 * Конфигурация для обработчиков запросов
 */
public class RequestHandlerModule extends AbstractModule
{
	@Override
	protected void configure()
	{
		install(new FactoryModuleBuilder()
				.implement(RequestHandler.class, RestRequestHandler.class)
				.build(new TypeLiteral<RequestHandlerFactory<RestRequestHandler>>(){}));
		install(new FactoryModuleBuilder()
				.implement(RequestHandler.class, MQRequestHandler.class)
				.build(new TypeLiteral<RequestHandlerFactory<MQRequestHandler>>(){}));

		MapBinder<RequestType, RequestHandlerFactory> binder =
				MapBinder.newMapBinder(binder(), RequestType.class, RequestHandlerFactory.class);
		binder.addBinding(RequestType.REST).to(new TypeLiteral<RequestHandlerFactory<RestRequestHandler>>(){});
		binder.addBinding(RequestType.MQ).to(new TypeLiteral<RequestHandlerFactory<MQRequestHandler>>(){});
	}
}
