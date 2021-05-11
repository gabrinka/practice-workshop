package com.sap.intern.task24;

import java.util.LinkedList;
import java.util.Queue;

public class RequestProcessor {
	private Queue<String> requests;

	public RequestProcessor() {
		requests = new LinkedList<>();
	}

	public void addRequest(final String request) {
		if (request == null) {
			System.out.println("Request is invalid!");
		} else {
			requests.add(request);
		}
	}

	public void processAllRequests() {
		while (!requests.isEmpty()) {
			String request = requests.poll();

			System.out.println("Processing request: " + request);
		}
	}
}
