package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FileService implements IFileService{
	
	private List<FileOrganizer> fileserver = new ArrayList<FileOrganizer>();
	private File fileobject = new File(System.getProperty("user.dir"));
	private static String[] filecache;
	private static int index;

	public FileService() {
		filecache =  fileobject.list();
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
	
	public boolean createFile(String filename) throws IOException{
		index++;
		File file = new File(fileobject.getAbsolutePath() + "\\" + filename);
		if(file.createNewFile()) {
			fileserver.add(new FileOrganizer(index, filename));
			return true;
		}
		return false;
	}

	public List<FileOrganizer> displayFiles() {
		return fileserver;
	}

	public boolean searchFile(String filename) {
		boolean filefounderr = true;
		filefounderr = quickSearch(filename, filefounderr);
		if(filefounderr)
			return false;
		else
			return true;
	}

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

}
