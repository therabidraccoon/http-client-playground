package it.trr.httppg;

import it.trr.httppg.http.RandomHttpCall;

public class HttpClientMainApp {
	
	public static void main(String[] args) {
		RandomHttpCall httpCall = new RandomHttpCall();
		httpCall.makeHttpCall("PUT");
		httpCall.makeHttpCall("GET");
		httpCall.makeHttpCall("DELETE");
	}

}
