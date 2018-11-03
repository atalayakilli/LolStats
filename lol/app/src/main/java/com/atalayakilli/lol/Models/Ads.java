package com.atalayakilli.lol.Models;

public class Ads{
	private String gecis;
	private String banner;
	private String id;
	private String odul;

	public void setGecis(String gecis){
		this.gecis = gecis;
	}

	public String getGecis(){
		return gecis;
	}

	public void setBanner(String banner){
		this.banner = banner;
	}

	public String getBanner(){
		return banner;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setOdul(String odul){
		this.odul = odul;
	}

	public String getOdul(){
		return odul;
	}

	@Override
 	public String toString(){
		return 
			"Ads{" + 
			"gecis = '" + gecis + '\'' + 
			",banner = '" + banner + '\'' + 
			",id = '" + id + '\'' + 
			",odul = '" + odul + '\'' + 
			"}";
		}
}
