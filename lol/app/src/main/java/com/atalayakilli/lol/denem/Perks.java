package com.atalayakilli.lol.denem;

import java.util.List;

public class Perks{
	private int perkSubStyle;
	private List<Integer> perkIds;
	private int perkStyle;

	public void setPerkSubStyle(int perkSubStyle){
		this.perkSubStyle = perkSubStyle;
	}

	public int getPerkSubStyle(){
		return perkSubStyle;
	}

	public void setPerkIds(List<Integer> perkIds){
		this.perkIds = perkIds;
	}

	public List<Integer> getPerkIds(){
		return perkIds;
	}

	public void setPerkStyle(int perkStyle){
		this.perkStyle = perkStyle;
	}

	public int getPerkStyle(){
		return perkStyle;
	}

	@Override
 	public String toString(){
		return 
			"Perks{" + 
			"perkSubStyle = '" + perkSubStyle + '\'' + 
			",perkIds = '" + perkIds + '\'' + 
			",perkStyle = '" + perkStyle + '\'' + 
			"}";
		}
}