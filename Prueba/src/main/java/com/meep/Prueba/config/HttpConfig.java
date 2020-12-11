package com.meep.Prueba.config;

import java.util.concurrent.TimeUnit;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@Configuration
public class HttpConfig {
	
	private final static long TIME_TO_LIVE = 30000;
	
	@Bean
	public HttpComponentsClientHttpRequestFactory getHttpClientFactory() {
		HttpClient httpClient =  this.getHttpClient();
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return httpComponentsClientHttpRequestFactory;
	}
	
	private HttpClient getHttpClient() {
		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = this.getConnectionManager();
		CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().setConnectionManager(poolingHttpClientConnectionManager).build();
		return closeableHttpClient;
	}
	
	private PoolingHttpClientConnectionManager getConnectionManager() {
		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager( HttpConfig.TIME_TO_LIVE, TimeUnit.MILLISECONDS );
		return poolingHttpClientConnectionManager;
	}
}