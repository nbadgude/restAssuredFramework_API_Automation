package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileandEnv {
	
	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreset = new Properties();
	
	public static Map<String, String> envAndFile() {
		String envirnoment = System.getProperty("env");
		
				try {
					if(envirnoment.equalsIgnoreCase("dev")) {
						FileInputStream fisdev = new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties");
						try {
							propMain.load(fisdev);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						fileandenv.put("serverUrl", propMain.getProperty("serverUrl"));
						fileandenv.put("excelpath", propMain.getProperty("excelpath"));
					}
					else if(envirnoment.equalsIgnoreCase("qa")) {
						FileInputStream fisqa = new FileInputStream(System.getProperty("user.dir")+"/inputs/qa.properties");
						try {
							propMain.load(fisqa);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						fileandenv.put("serverUrl", propMain.getProperty("serverUrl"));
						fileandenv.put("excelpath", propMain.getProperty("excelpath"));	
					}
				} 
				
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return fileandenv;
		}
	
	}
	


