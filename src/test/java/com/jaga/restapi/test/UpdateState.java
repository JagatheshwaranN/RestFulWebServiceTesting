package com.jaga.restapi.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaga.restapi.pojo.UpdateStateDetail;
import com.jaga.restapi.services.RestWebService;
import com.jaga.restapi.utility.EndPointUrl;
import com.jaga.restapi.utility.Url;
import com.jayway.restassured.response.Response;

public class UpdateState {

	public static Response response;
	public static int ok = 200;

	public int stateId;
	public String stateName;
	public int statePopulation;

	@BeforeClass
	public void dataSetup() {

		stateId = 1;
		statePopulation = 15000;

	}

	@Test(dataProvider = "modifyState")
	public void updateStateDetail(String request, String stateName, Integer population) {

		Gson gson = new GsonBuilder().create();
		UpdateStateDetail updateState;

		String apiEndPointUrl = Url.resourceURL + EndPointUrl.UPDATE_STATE.getResourcePath();
		System.out.println("apiEndPointUrl : " + apiEndPointUrl);
		response = RestWebService.put(apiEndPointUrl, request);
		System.out.println(response.asString());
		if (response.getStatusCode() == ok) {
			updateState = gson.fromJson(response.getBody().asString(), UpdateStateDetail.class);
			Assert.assertEquals(stateName, updateState.getStateName());
			Assert.assertEquals(new Integer(population), updateState.getPopulation());
		}

	}

	@DataProvider(name = "modifyState")
	public Object[][] modifyState() {
		Object[][] result = new Object[1][3];

		result[0][0] = "{\"id\":1,\"stateName\":\"TamilNadu\",\"population\":15000}";
		result[0][1] = "TamilNadu";
		result[0][2] = 15000;

		return result;
	}
}
