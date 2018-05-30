package com.jaga.springrest.controller;

import java.util.List;
import com.jaga.springrest.bean.State;
import com.jaga.springrest.service.StateService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

	StateService stateService = new StateService();
	
	//http://localhost:8081/SpringRestFulWebService/

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/states", method = RequestMethod.GET, headers = "Accept=application/json")
	public List getStates() {
		List listOfStates = stateService.getAllStates();
		return listOfStates;
	}

	@RequestMapping(value = "/state/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public State getStateById(@PathVariable int id) {
		return stateService.getState(id);
	}

	@RequestMapping(value = "/states/details", method = RequestMethod.POST, headers = "Accept=application/json")
	public State addState(@RequestBody State state) {
		return stateService.addState(state);
	}

	@RequestMapping(value = "/states/update/details", method = RequestMethod.PUT, headers = "Accept=application/json")
	public State updateState(@RequestBody State state) {
		return stateService.updateState(state);

	}

	@RequestMapping(value = "/state/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteState(@PathVariable("id") int id) {
		stateService.deleteState(id);

	}
}
