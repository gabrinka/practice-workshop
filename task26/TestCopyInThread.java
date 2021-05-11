package com.sap.intern.task26;

public class TestCopyInThread extends Thread {
	public static void main(String[] args) {
		String fileSourceFirst = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task26\\src1.txt";
		String fileDestinationFirst = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task26\\dst1.txt";
		CopyFileInThread threadFirst = new CopyFileInThread(1,fileSourceFirst,fileDestinationFirst);

		System.out.println("Thread Number: 1 is executing copy operation on files..");
		threadFirst.start();

		String fileSourceSecond = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task26\\src2.txt";
		String fileDestinationSecond = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task26\\dst2.txt";
		CopyFileInThread threadSecond = new CopyFileInThread(2,fileSourceSecond,fileDestinationSecond);

		System.out.println("Thread Number: 2 is executing copy operation on files..");
		threadSecond.start();
		
		String fileSourceThird = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task26\\src3.txt";
		String fileDestinationThird = "C:\\Users\\I539966\\eclipse-workspace\\Tasks\\src\\com\\sap\\intern\\task26\\dst3.txt";
		CopyFileInThread threadThird = new CopyFileInThread(3,fileSourceThird,fileDestinationThird);

		System.out.println("Thread Number: 3 is executing copy operation on files..");
		threadThird.start();

	}
}