package com.jaga.restapi.utility;

public enum EndPointUrl {

	CREATE_STATE("/states/details"), 
	READ_STATE("/state/"), 
	READ_STATES("/states"), 
	UPDATE_STATE("/states/update/details"), 
	DELETE_STATE("/state/");

	String resourceUrlPath;

	EndPointUrl(String resourceUrlPath) {
		this.resourceUrlPath = resourceUrlPath;
	}

	public String getResourcePath() {
		return this.resourceUrlPath;
	}

	public String getResourcePath(String data) {
		return this.resourceUrlPath + data;

	}
}
