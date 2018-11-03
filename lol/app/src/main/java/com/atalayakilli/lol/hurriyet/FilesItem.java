package com.atalayakilli.lol.hurriyet;

public class FilesItem{
	private String fileUrl;
	private Metadata metadata;

	public void setFileUrl(String fileUrl){
		this.fileUrl = fileUrl;
	}

	public String getFileUrl(){
		return fileUrl;
	}

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	@Override
 	public String toString(){
		return 
			"FilesItem{" + 
			"fileUrl = '" + fileUrl + '\'' + 
			",metadata = '" + metadata + '\'' + 
			"}";
		}
}
