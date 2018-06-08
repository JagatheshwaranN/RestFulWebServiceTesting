package com.jaga.restapi.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jaga.restapi.services.RestWebService;
import com.jaga.restapi.utility.EndPointUrl;
import com.jaga.restapi.utility.Url;
import com.jayway.restassured.response.Response;

/**
 * 
 * @author Jagatheshwaran
 * @since 7/6/2018
 *
 */
public class DeleteState {

	public static Response response;
	public static int ok = 200;

	@Test(dataProvider = "deleteState")
	public void deleteState(Integer stateId) {

		String apiEndPointUrl = Url.resourceURL + EndPointUrl.DELETE_STATE.getResourcePath(stateId.toString());
		System.out.println("apiEndPointUrl : " + apiEndPointUrl);
		response = RestWebService.delete(apiEndPointUrl);
		System.out.println(response.getBody().asString());
		if (response.getStatusCode() == ok) {

			System.out.println("State Deleted");

		}

	}

	@DataProvider(name = "deleteState")
	public Object[][] removeState() {
		Object[][] result = new Object[1][1];

		result[0][0] = 5;
		return result;

	}

}
