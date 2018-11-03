package com.atalayakilli.lol.hurriyet;

import java.util.List;

public class Response{
	private String path;
	private String startDate;
	private String description;
	private String contentType;
	private String createdDate;
	private String title;
	private String id;
	private List<FilesItem> files;
	private String modifiedDate;
	private List<String> tags;
	private String url;

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setContentType(String contentType){
		this.contentType = contentType;
	}

	public String getContentType(){
		return contentType;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFiles(List<FilesItem> files){
		this.files = files;
	}

	public List<FilesItem> getFiles(){
		return files;
	}

	public void setModifiedDate(String modifiedDate){
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedDate(){
		return modifiedDate;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"path = '" + path + '\'' + 
			",startDate = '" + startDate + '\'' + 
			",description = '" + description + '\'' + 
			",contentType = '" + contentType + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",title = '" + title + '\'' + 
			",id = '" + id + '\'' + 
			",files = '" + files + '\'' + 
			",modifiedDate = '" + modifiedDate + '\'' + 
			",tags = '" + tags + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}