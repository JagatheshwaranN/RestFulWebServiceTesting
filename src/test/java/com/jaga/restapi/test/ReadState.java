package com.jaga.restapi.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaga.restapi.pojo.GetStates;
import com.jaga.restapi.services.RestWebService;
import com.jaga.restapi.utility.EndPointUrl;
import com.jaga.restapi.utility.Url;
import com.jayway.restassured.response.Response;

public class ReadState {

	public static Response response;
	public static int ok = 200;

	public int stateId;
	public String stateName;
	public int statePopulation;

	@BeforeClass
	public void DataSetup() {

		stateId = 1;
		stateName = "TamilNadu";
		statePopulation = 10000;

	}

	@Test
	public void getState() {

		Gson gson = new GsonBuilder().create();
		GetStates getStates;

		String apiEndPointUrl = Url.resourceURL + EndPointUrl.READ_STATE.getResourcePath("1");
		System.out.println("apiEndPointUrl : " + apiEndPointUrl);
		response = RestWebService.get(apiEndPointUrl);

		if (response.getStatusCode() == ok) {
			getStates = gson.fromJson(response.getBody().asString(), GetStates.class);
			Assert.assertEquals(new Integer(stateId), getStates.getId());
			Assert.assertEquals(stateName, getStates.getStateName());
			Assert.assertEquals(new Integer(statePopulation), getStates.getPopulation());
		}

	}
}
