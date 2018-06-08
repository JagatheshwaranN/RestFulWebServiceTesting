package com.jaga.restapi.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaga.restapi.pojo.AddState;
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
public class CreateState {

	public static Response response;
	public static int ok = 200;

	@Test(dataProvider = "addState")
	public void createState(String requestData, Integer stateId, String stateName, Integer population) {

		Gson gson = new GsonBuilder().create();
		AddState addState;
		String apiEndPointUrl = Url.resourceURL + EndPointUrl.CREATE_STATE.getResourcePath();
		System.out.println("apiEndPointUrl : " + apiEndPointUrl);
		response = RestWebService.post(apiEndPointUrl, requestData);
		System.out.println(response.getBody().asString());
		if (response.getStatusCode() == ok) {
			addState = gson.fromJson(response.getBody().asString(), AddState.class);
			Assert.assertEquals(stateId, addState.getId());
			Assert.assertEquals(stateName, addState.getStateName());
			Assert.assertEquals(new Integer(population), addState.getPopulation());
		}

	}

	@DataProvider(name = "addState")
	public Object[][] addState() {
		Object[][] result = new Object[1][4];

		result[0][0] = "{\"id\":5,\"stateName\":\"Goa\",\"population\":2000}";
		result[0][1] = 5;
		result[0][2] = "Goa";
		result[0][3] = 2000;

		return result;

	}
}
