package com.atalayakilli.lol.Models;

public class ApiModel{
	private String apikey;
	private String id;

	public void setApikey(String apikey){
		this.apikey = apikey;
	}

	public String getApikey(){
		return apikey;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ApiModel{" + 
			"apikey = '" + apikey + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
