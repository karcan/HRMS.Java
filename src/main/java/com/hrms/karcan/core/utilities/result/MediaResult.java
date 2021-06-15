package com.hrms.karcan.core.utilities.result;

public class MediaResult {
	private String url;
	private String fileId;
	
	

	public MediaResult(String url) {
		super();
		this.url = url;
	}

	public MediaResult(String url, String fileId) {
		super();
		this.url = url;
		this.fileId = fileId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}
