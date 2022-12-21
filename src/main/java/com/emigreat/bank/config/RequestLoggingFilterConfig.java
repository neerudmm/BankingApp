package com.emigreat.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {
	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeClientInfo(true);
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setIncludeHeaders(true);
		filter.setMaxPayloadLength(10000);
		filter.setAfterMessagePrefix("After request: ");
		return filter;
	}
}