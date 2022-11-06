/**
 * 
 */
package com.lockedme;

import java.io.IOException;
import java.util.List;

/**
 * @author kjagasabarivel@gmail.com
 *
 */
public interface IFileService {
	
	// API to create a file.
	public boolean createFile(String filename) throws IOException;
	
	// API for displaying all the files in the directory.
    public List<FileOrganizer> displayFiles();
    
    // API for searching a file in the directory.
    public boolean searchFile(String filename);
    
    //API for deleting a file.
    public boolean deleteFile(String filename);
}
