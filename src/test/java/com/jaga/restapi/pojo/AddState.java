package com.jaga.restapi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddState {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("stateName")
@Expose
private String stateName;
@SerializedName("population")
@Expose
private Integer population;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getStateName() {
return stateName;
}

public void setStateName(String stateName) {
this.stateName = stateName;
}

public Integer getPopulation() {
return population;
}

public void setPopulation(Integer population) {
this.population = population;
}

}