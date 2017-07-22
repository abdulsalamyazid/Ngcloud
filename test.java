package tru;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;



public class test {
	
	// POST the XML string as text/xml  via HTTPS
	public static String postRequest(String strRequest, String strURL) throws Exception {
	    String responseXML = null;

	    try {
	        URL url = new URL(strURL);
	        URLConnection connection = url.openConnection();
	        HttpURLConnection httpConn = (HttpURLConnection) connection;

	        byte[] requestXML = strRequest.getBytes();

	        // Set the appropriate HTTP parameters.
	        httpConn.setRequestProperty("Content-Length", String.valueOf(requestXML.length));
	        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
	        httpConn.setRequestMethod("POST");
	        httpConn.setDoOutput(true);
	        httpConn.setDoInput(true);

	        // Send the String that was read into postByte.
	        OutputStream out =  httpConn.getOutputStream();
	        out.write(requestXML);
	        out.close();

	        // Read the response and write it to standard out.
	        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
	        BufferedReader br = new BufferedReader(isr);
	        String temp;
	        String tempResponse = "";

	        //Create a string using response from web services
	        while ((temp = br.readLine()) != null)
	            tempResponse = tempResponse + temp;
	        responseXML = tempResponse;
	        br.close();
	        isr.close();
	    } catch (java.net.MalformedURLException e) {
	        System.out.println("Error in postRequest() : Secure Service Required");
	    } catch (Exception e) {
	        System.out.println("Error in postRequest(): " + e.getMessage());
	    }
	    System.out.println(responseXML);
	    return responseXML;
	}
	
	public static void main(String[] args) throws Exception {        
		// POST the XML string as text/xml  via HTTPS
		postRequest("<Request><Action>GetGlobalList</Action><APIKey>a47eabdaa741242b987c738529bb2bc6</APIKey> </Request>","http://ngcloudtest/api/cloud");
		
		
	
    }
}