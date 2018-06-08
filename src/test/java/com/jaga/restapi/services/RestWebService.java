package com.jaga.restapi.services;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * 
 * @author Jagatheshwaran
 * @since 30/5/2018
 *
 */
public class RestWebService {

	public static Response get(String url) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(url);
		return response;

	}

	public static Response post(String url, String requestData) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestData);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(url);
		return response;

	}

	public static Response put(String url, String requestData) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestData);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(url);
		return response;

	}

	public static Response delete(String url) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(url);
		return response;

	}

}
