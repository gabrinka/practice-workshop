package com.sap.intern.task24;

public class TestRequestProcessor {

	public static void main(String[] args) {
		RequestProcessor requests = new RequestProcessor();
		requests.addRequest("Request 1");
		requests.addRequest("Request 2");
		requests.addRequest("Request 3");
		requests.addRequest("Request 4");
		requests.addRequest("Request 5");
		
		requests.processAllRequests();

	}

}
