package com.codemos.springbasicstudy.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
	private String url;
	
	public NetworkClient() {
		System.out.println("Constructor called, url = " + url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	// Call this method when service started
	public void connect() {
		System.out.println("connect: " + url);
	}
	
	public void call(String message) {
		System.out.println("call: " + url + " message = " + message);
	}
	
	// Call this method when service closed
	public void disconnect() {
		System.out.println("close: " + url);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("NetworkClient.afterPropertiesSet");
		connect();
		call("Initialization connection message");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("NetworkClient.destroy");
		disconnect();
	}
}
