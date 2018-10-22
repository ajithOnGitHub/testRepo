package Test.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Readproperty {
	
	public static Properties prop;

	public Readproperty (){
		try{
		File file = new File("configuration.properties");
		FileInputStream input = new FileInputStream(file);
		prop = new Properties();
		prop.load(input);
		input.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getProp(String property) {
		String temp = null;
		try {
		temp = prop.getProperty("URL");
		}catch(Exception e) {
			System.out.println("Exception");
			System.out.println(e.getMessage());
			temp = "http://www.google.com";
		}
		return temp;
	}
}
