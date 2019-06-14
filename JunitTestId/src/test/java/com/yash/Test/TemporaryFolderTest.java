package com.yash.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderTest {

	@Rule
	   public TemporaryFolder tempFolder = new TemporaryFolder();
	   
	   @Test
	   public void testWrite() throws IOException {
		   File file = tempFolder.newFile("test.txt");
	     assertTrue(file.exists());
	   
	      
	   }

}
