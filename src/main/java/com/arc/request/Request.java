package com.arc.request;

import java.util.Objects;

/**
 * Свой собственный реквест
 */
public class Request
{
	private RequestType requestType;
	private String requestBody;

	public Request(RequestType requestType, String requestBody)
	{
		this.requestType = requestType;
		this.requestBody = requestBody;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Request request = (Request) o;
		return requestType == request.requestType &&
				requestBody.equals(request.requestBody);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(requestType, requestBody);
	}
}
