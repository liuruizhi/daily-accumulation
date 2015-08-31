package com.jpa.utils;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtils {
	ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	private static Properties properties = null;
	static{
		properties = new Properties();
		try {
			Reader reader = new InputStreamReader(new FileInputStream("src/main/resources/database.properties"));
			properties.load(reader);
			
			Class.forName(properties.getProperty("driver_mysql"));
			
//			System.out.println(properties.getProperty("driver_mysql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		
		if(threadLocal.get() != null){
			return threadLocal.get();
		}else{
			try {
				threadLocal.set(DriverManager.getConnection(properties.getProperty("url_mysql"), properties.getProperty("username_mysql"), properties.getProperty("password_mysql")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return threadLocal.get();
		}
		
	}
	
	public boolean closeConnection(Connection connection){
		if(connection != null){
			if(threadLocal.get() != null){
				try {
					connection.close();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}else{
			return true;
		}
	}
	
	
	
}
