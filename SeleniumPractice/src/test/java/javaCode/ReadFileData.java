package javaCode;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class ReadFileData {

	public static void main(String ard[]) throws IOException {

		String content = FileUtils.readFileToString(new File("C:\\test.txt"),
				StandardCharsets.UTF_8);
		
		System.out.println("content of file ----  "+content );
	}
	
}
