package com.fleet.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception is:"+e.getMessage());
		}
		
		}
	public String getApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getchromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getiepath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	}
