package impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class workersMatchJobs {

	public static void main(String [] args) throws IOException {
		getWorkers();
		getJobs();
	}

	public static void getWorkers() throws IOException {
		URL urlForGetRequest = new URL("http://test.swipejobs.com/api/workers");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		conection.connect();
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine);
			} 
			in .close();	     
			// print result
			System.out.println("JSON String Result " + response.toString());
		} else {
			System.out.println("GET NOT WORKED");
			throw new RuntimeException("HttpResponseCode: " +responseCode);
		}
	}

	public static void getJobs() throws IOException {
		URL urlForGetRequest = new URL("http://test.swipejobs.com/api/jobs");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		conection.connect();
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine);
			} 
			in .close();	     
			// print result
			System.out.println("JSON String Result " + response.toString());
		} else {
			System.out.println("GET NOT WORKED");
			throw new RuntimeException("HttpResponseCode: " +responseCode);
		}
	}

}
