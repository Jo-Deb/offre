package com.sfeir.labs.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestFile extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
	 IOException{
		 URL file = new URL("http://www.data.gouv.fr/var/download/OPM%20grande%20distribution%20DGCCRF%20"+
		        "-%20evolution%20offre%20-%20mars%202011.csv");
		        BufferedReader in = new BufferedReader(
		        new InputStreamReader(file.openStream()));
		
		        String inputLine;
		        while ((inputLine = in.readLine()) != null)
		            System.out.println(inputLine);
		        in.close();
		
	}


	
//	public static void main(String[] args) throws Exception {
//
//        URL file = new URL("http://www.data.gouv.fr/var/download/OPM%20grande%20distribution%20DGCCRF%20"+
//        "-%20evolution%20offre%20-%20mars%202011.csv");
//        BufferedReader in = new BufferedReader(
//        new InputStreamReader(file.openStream()));
//
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine);
//        in.close();
//    }
}
