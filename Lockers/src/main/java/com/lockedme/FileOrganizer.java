package com.lockedme;

public class FileOrganizer {

	private int fileid;
	private String filename;
	
	public FileOrganizer() {
	}
	
	public FileOrganizer(int fileid, String filename) {
		super();
		this.fileid = fileid;
		this.filename = filename;
	}

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.filename == ((FileOrganizer)obj).filename;
	}

}
