package com.jaga.restapi.test;

import java.util.ArrayList;

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

public class ReadStates {

	public static Response response;
	public static int ok = 200;
	ArrayList<String> stateName;
	ArrayList<Integer> statePopulation;

	@BeforeClass
	public void DataSetup() {
		
		stateName = new ArrayList<String>();
		stateName.add("TamilNadu");
		stateName.add("AndraPradesh");
		stateName.add("Kerala");
		stateName.add("Karnataka");

		statePopulation = new ArrayList<Integer>();
		statePopulation.add(10000);
		statePopulation.add(7000);
		statePopulation.add(8000);
		statePopulation.add(20000);

	}

	@Test
	public void getStates() {
		
		Gson gson = new GsonBuilder().create();
		GetStates[] getStates;
		
		String apiEndPointUrl = Url.resourceURL + EndPointUrl.READ_STATES.getResourcePath();
		System.out.println("apiEndPointUrl : " + apiEndPointUrl);
		response = RestWebService.get(apiEndPointUrl);
	
		if (response.getStatusCode() == ok) {
			getStates = gson.fromJson(response.getBody().asString(), GetStates[].class);

			for (int i = 1; i <= getStates.length; i++) {

				Assert.assertEquals(new Integer(i), getStates[i - 1].getId());
				Assert.assertEquals(stateName.get(i - 1), getStates[i - 1].getStateName());
				Assert.assertEquals(statePopulation.get(i - 1), getStates[i - 1].getPopulation());

			}
		}
	}

}
