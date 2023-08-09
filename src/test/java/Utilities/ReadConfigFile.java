package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigFile {
	Properties properties;
	String path="config.properties";
	
	public ReadConfigFile(Properties properties, String path) throws Exception {
		properties=new Properties();
		
		FileInputStream fis=new FileInputStream(path);
		
		properties.load(fis);
	}
	public ReadConfigFile() {
		// TODO Auto-generated constructor stub
	}
	public String getBroswer()
	{
		String value=properties.getProperty("Broswer");
		return value;
	
	}
	

}
