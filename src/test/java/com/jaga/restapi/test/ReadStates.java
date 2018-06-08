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

/**
 * 
 * @author Jagatheshwaran
 * @since 1/6/2018
 *
 */
public class ReadStates {

	public static Response response;
	public static int ok = 200;
	public static ArrayList<Integer> stateId;
	public static ArrayList<String> stateName;
	public static ArrayList<Integer> statePopulation;

	@BeforeClass
	public void DataSetup() {

		stateId = new ArrayList<Integer>();
	    stateName = new ArrayList<String>();
		statePopulation = new ArrayList<Integer>();
	
		stateName.add("TamilNadu");
		stateName.add("AndraPradesh");
		stateName.add("Kerala");
		stateName.add("Karnataka");
		stateName.add("Goa");

		statePopulation.add(15000);
		statePopulation.add(7000);
		statePopulation.add(8000);
		statePopulation.add(20000);
		statePopulation.add(2000);

		

	}

	@Test
	public static void getStates() {

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

				stateId.add(getStates[i - 1].getId());
				stateName.add(getStates[i - 1].getStateName());
				statePopulation.add(getStates[i - 1].getPopulation());

			}
		}
	}

}
