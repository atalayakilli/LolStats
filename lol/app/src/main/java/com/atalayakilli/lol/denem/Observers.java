package com.atalayakilli.lol.denem;

public class Observers{
	private String encryptionKey;

	public void setEncryptionKey(String encryptionKey){
		this.encryptionKey = encryptionKey;
	}

	public String getEncryptionKey(){
		return encryptionKey;
	}

	@Override
 	public String toString(){
		return 
			"Observers{" + 
			"encryptionKey = '" + encryptionKey + '\'' + 
			"}";
		}
}
