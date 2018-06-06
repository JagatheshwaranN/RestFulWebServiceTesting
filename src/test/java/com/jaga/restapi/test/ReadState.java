package com.jaga.restapi.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaga.restapi.pojo.GetStates;
import com.jaga.restapi.services.RestWebService;
import com.jaga.restapi.utility.EndPointUrl;
import com.jaga.restapi.utility.Url;
import com.jayway.restassured.response.Response;

public class ReadState extends ReadStates {

	public static Response response;
	public static int ok = 200;

	public int stateId;
	public String stateName;
	public int statePopulation;

	@BeforeClass
	public void DataSetup() {

		/*
		 * stateId = 1; stateName = "TamilNadu"; statePopulation = 10000;
		 */

	}

	@Test(dataProvider = "GetStateById")
	public void getState(Integer id, String state, Integer population) {

		Gson gson = new GsonBuilder().create();
		GetStates getStates;

		String apiEndPointUrl = Url.resourceURL + EndPointUrl.READ_STATE.getResourcePath(id.toString());
		System.out.println("apiEndPointUrl : " + apiEndPointUrl);
		response = RestWebService.get(apiEndPointUrl);
		System.out.println(response.asString());

		if (response.getStatusCode() == ok) {
			
			getStates = gson.fromJson(response.getBody().asString(), GetStates.class);
			
			/*
			 * Assert.assertEquals(new Integer(stateId), getStates.getId());
			 * Assert.assertEquals(stateName, getStates.getStateName());
			 * Assert.assertEquals(new Integer(statePopulation), getStates.getPopulation());
			 */
			Assert.assertEquals(id, getStates.getId());
			Assert.assertEquals(state, getStates.getStateName());
			Assert.assertEquals(population, getStates.getPopulation());

		}

	}

	@DataProvider(name = "GetStateById")
	public Object[][] getStateById() {
		
		Object[][] result = new Object[ReadStates.stateId.size()][3];
		for (int i = 0; i < result.length; i++) {
			result[i][0] = ReadStates.stateId.get(i);
			result[i][1] = ReadStates.stateName.get(i);
			result[i][2] = ReadStates.statePopulation.get(i);
		}
		return result;

	}
}
