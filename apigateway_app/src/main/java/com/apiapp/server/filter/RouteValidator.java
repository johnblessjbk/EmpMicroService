package com.apiapp.server.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

	public static final List<String> openApiEndPOints=List.of(
			       "/auth/authenticate/userregister",
			       "/auth/authenticate/login",
			       "/auth/authenticate/getToken",
			       "/eureka");
	
	 public Predicate<ServerHttpRequest> isSecured =
	            request -> openApiEndPOints
	                    .stream()
	                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
