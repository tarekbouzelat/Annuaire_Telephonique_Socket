package Reseau;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SocketServeur extends Thread{
	private Socket client; 
	public SocketServeur(Socket client)	{ 
		this.client = client;
	} 
	
	public void run() { 
		try {
			BufferedReader buffer = new BufferedReader( new InputStreamReader(client.getInputStream()));
			PrintWriter writer = new PrintWriter( client.getOutputStream(),true);
			String nom = buffer.readLine();
			writer.println(RechercheNum(nom)); 					
			client.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
        private String RechercheNum(String nom) {		
    	Connection conn;
    	try {    		
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/telephone", "root", "");
    		java.sql.Statement statement = conn.createStatement();
    	    ResultSet res = statement.executeQuery("SELECT NumTel From annuaire where nom='"+nom+"'");
    		while( res.next()) {
    			return res.getString("NumTel");    			
    			}
    	}catch(SQLException e){    		
    		System.out.println(e.getMessage());
    	}
		return "Nom non trouvé";
	}
	
}

