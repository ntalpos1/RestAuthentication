package com.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.junit.Test;

public class HttpUrlConnectionTest {
	
	public static final String SERVER_URI_ABC_POST ="http://localhost:10101/abc/rest/testservice/def";
	
    @Test
    public void testHttpConnectionAuthentication()
    {
    	try {
    		java.net.URL url = new java.net.URL (SERVER_URI_ABC_POST);
            String encoding = java.util.Base64.getUrlEncoder().encodeToString("idAbc:Password-Test".getBytes(Charset.forName("UTF-8")));

            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   = 
                new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
