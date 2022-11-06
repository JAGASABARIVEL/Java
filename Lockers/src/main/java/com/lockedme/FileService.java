package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

public class FileService implements IFileService{
	
	// User can configure the directory that he wants to perform the action from configuration.properties
	private final ResourceBundle rb = ResourceBundle.getBundle("configuration");
	private final File fileobject = new File(System.getProperty(rb.getString("directory")));
	
	// Temporary string array to store the list of files on the directory for us to process.
	private static String[] filecache;
	
	// For user to know the sequence of the file creation since we sort the list based on the filename.
	private static int index;
	
	// Organize the filename retrieved.
	private List<FileOrganizer> fileserver = new ArrayList<FileOrganizer>();
	
	private static FileService fs;
	

	private FileService() {
		filecache =  fileobject.list();
		Arrays.sort(filecache);
		this.loadDataset();
	}
	
	private void loadDataset() {
		for(String filename : filecache) {
			index++;
			this.fileserver.add(new FileOrganizer(index, filename));
		}
	}
	
	private boolean quickSearch(String filename, boolean filefounderr) {
		for(FileOrganizer organiser : fileserver) {			
			if(organiser.getFilename().equals(filename)) {
				filefounderr = false;
				break;
			}
		}
		return filefounderr;
	}
	
	/*
	 * API to create a file
	 * @filename : filename to be created.
	 * */
	public boolean createFile(String filename) throws IOException{
		index++;
		File file = new File(fileobject.getAbsolutePath() + "\\" + filename);
		if(file.createNewFile()) {
			fileserver.add(new FileOrganizer(index, filename));
			return true;
		}
		return false;
	}

	/*
	 * API to display all the files in a directory.
	 * */
	public List<FileOrganizer> displayFiles() {
		Collections.sort(fileserver);
		return fileserver;
	}

	/*
	 *  API to search a file in a directory
	 * @filename : Filename to be searched. 
	 * */
	public boolean searchFile(String filename) {
		boolean filefounderr = true;
		filefounderr = quickSearch(filename, filefounderr);
		if(filefounderr)
			return false;
		else
			return true;
	}

	/*
	 * API to delete a file
	 * @filename : Filename to be deleted.
	 * */
	public boolean deleteFile(String filename) {
		FileOrganizer objecttobedeleted=null;
		for (FileOrganizer organizer : fileserver) {
			if(organizer.getFilename().equals(filename)) {
				objecttobedeleted = organizer;
			    break;
			}
		}
		if(objecttobedeleted == null)
			return false;
		else {
			File file = new File(fileobject.getAbsoluteFile() + "\\" + objecttobedeleted.getFilename());
			fileserver.remove(objecttobedeleted);
			file.delete();
			return true;
		}
	}
	
	public static FileService getService() {
		if (fs==null) {
			fs = new FileService();
		}
		return fs;
	}

}
