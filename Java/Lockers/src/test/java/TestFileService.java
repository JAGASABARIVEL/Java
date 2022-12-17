import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.lockedme.FileService;

public class TestFileService {

	static FileService fs;
	static String filename = "pom1.xml";
	
	public TestFileService() {
		// TODO Auto-generated constructor stub
	}
	
	@Before
	public void setUp() {
		fs = FileService.getService();
	}
	
	@Test
	public void test0createFile() throws IOException {
		assertEquals(true, fs.createFile(filename));
		assertEquals(true, fs.searchFile(filename));
	}
	
	@Test
	public void test1SearchFile() {
		assertEquals(true, fs.searchFile(filename));
	}
	
	@Test
	public void test2DeleteFile() {
		assertEquals(true, fs.deleteFile(filename));
		assertEquals(false, fs.searchFile(filename));
	}
}
