package com.meep.Prueba.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestService {
	
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpComponentsClientHttpRequestFactory clientHttpRequestFactory;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostConstruct
	public void init() {
		
		HttpMessageConverter<Object> jackson = new MappingJackson2HttpMessageConverter();
		HttpMessageConverter<Resource> resource = new ResourceHttpMessageConverter();
		
		FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
		formHttpMessageConverter.addPartConverter(jackson);
		formHttpMessageConverter.addPartConverter(resource);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add( formHttpMessageConverter );
		restTemplate.setRequestFactory( this.clientHttpRequestFactory );
		
		this.restTemplate = restTemplate;
	}
	
	
	public <T> T get( String url, Map<String, ?> params, Class<T> clazz ) {
		
		try {
			
			if( params == null ) {
				params = new HashMap<>();
			}
				
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString( url );
			
			for( String key : params.keySet() ) {
				builder = builder.queryParam( key, params.get( key ) );
			}
			
			URI uri = builder.build().encode().toUri();
			
			logger.info( "GET: Se va a llamar a la url: {} ", uri );
			
			return this.restTemplate.getForObject( uri, clazz );
			
		} catch( Exception ex ){
			ex.printStackTrace();
			throw new IllegalArgumentException("No se ha podido completar la peticion solicitada");
		}
	}
	
	public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
			ParameterizedTypeReference<T> responseType, Map<String, ?> params) {
		
		try {
			
			if( params == null ) {
				params = new HashMap<>();
			}
			
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString( url );
			
			for( String key : params.keySet() ) {
				builder = builder.queryParam( key, params.get( key ) );
			}
			
			URI uri = builder.build().encode().toUri();
			
			logger.info( "exchange: Se va a llamar a la url: {} via {} " , uri, method );
			
			return this.restTemplate.exchange(uri.toURL().toString(), method, null, responseType);
			
		} catch( Exception ex ){
			ex.printStackTrace();
			throw new IllegalArgumentException("No se ha podido completar la peticion solicitada");
		}
	}
	
}