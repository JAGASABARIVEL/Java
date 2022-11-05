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
	public boolean createFile(String filename) throws IOException;
    public List<FileOrganizer> displayFiles();
    public boolean searchFile(String filename);
    public boolean deleteFile(String filename);
}
