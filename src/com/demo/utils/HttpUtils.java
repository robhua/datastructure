package com.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class HttpUtils {
	private HttpUtils () {
		
	}
	
	private static final String LOCATION_URL = "/questions/27599847/convert-comma-separated-string-to-list-without-intermediate-container";
	private static final String CHARSET = "UTF-8";
	
	/**
	 * Get Http response from.
	 * @param httpConnection
	 * @return
	 * @throws IOException
	 */
	public static String getHttpResponse(HttpURLConnection httpConnection) throws IOException {
        InputStream is = null;
        if (httpConnection.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            is = httpConnection.getErrorStream();
        } else {
            is = httpConnection.getInputStream();
        }

        InputStreamReader isr = new InputStreamReader(is, CHARSET);
        char[] buf = new char[10000];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int len = isr.read(buf);
            if (len < 0) {
                break;
            }
            sb.append(buf, 0, len);
        }
        isr.close();
        return sb.toString();
	}
	
	public static void main(String[] args) {
		String host = "104.16.37.249";
		String port = "8080";
		int readTimeOut = 300000;
		System.out.println(callUDS(host, port , LOCATION_URL, readTimeOut));
	}
	
	public static String callUDS(String host, String port, String locationUrl, int timeOut) {
		String response = "";

        long startTime = System.currentTimeMillis();
        String url = "http://" + host + ":" + port+ locationUrl;
        url = "http://programmers.stackexchange.com/questions/221997/quickest-way-to-split-a-delimited-string-in-java";
        HttpURLConnection httpConnection = null;
        try {
            httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.setConnectTimeout(timeOut);

            httpConnection.setReadTimeout(timeOut);
            httpConnection.setRequestMethod("GET");
            response = getHttpResponse(httpConnection);
            int status = httpConnection.getResponseCode();

            if (status != 200) {
                response = "";
            }
        } catch (IOException ex) {
        	System.out.println(ex);
        } finally {
            httpConnection.disconnect();
        }
        return response;
    }
	
	   public static void search() {

		try {
			Properties props = new Properties();
			props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
			props.put("java.naming.provider.url", "//TODO");
			// props.put("java.naming.provider.url",
			// Config.getInstance().edmSearchJndiUrl);

			InitialContext context = new InitialContext(props);
			Object lookup = (Object)context.lookup("edmcs/SearchEjb/remote");

			// searchResponse = csi.search(searchRequest);

			// if (searchResponse == null) {
			// Just in case
			// logger.error("No response received");
			// searchResponse = new SearchResponse();
			// searchResponse.setStatusCode(SearchResponse.STATUS_SYSTEM_ERROR);
			// searchResponse.setStatusMessage("System error");
			// }
		} catch (NamingException ex) {
			System.out.println(ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	   }
}
