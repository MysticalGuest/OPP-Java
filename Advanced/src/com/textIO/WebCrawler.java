package com.textIO;

import java.util.ArrayList;

public class WebCrawler {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("Enter a URL: ");
		String url = input.nextLine();
		crawler(url); // Traverse the Web from the a starting url 从起始网址遍历Web
		
	}
	
	public static void crawler(String startingURL) {
		ArrayList<String> listOfPendingURLs = new ArrayList<>();
		ArrayList<String> listOfTraversedURLs = new ArrayList<>();
		
		listOfPendingURLs.add(startingURL);
		while (!listOfPendingURLs.isEmpty() &&
				listOfTraversedURLs.size() <= 100) {
			String urlString = listOfPendingURLs.remove(0);
			if (!listOfTraversedURLs.contains(urlString)) {
				listOfTraversedURLs.add(urlString);
				System.out.println("Crawl " + urlString);
				
				for (String s: getSubURLs(urlString)) {
					if(!listOfTraversedURLs.contains(s))
						listOfPendingURLs.add(s);
				}
			}
			
		}
	}
	
	public static ArrayList<String> getSubURLs(String urlString){
		ArrayList<String> list = new ArrayList<>();
		
		try {
			java.net.URL url = new java.net.URL(urlString);
			java.util.Scanner input = new java.util.Scanner(url.openStream());
			int current = 0;
			while (input.hasNext()) {
				String line = input.nextLine();
				current = line.indexOf("http:", current);
				while(current > 0) {
					int endIndex = line.indexOf("\"", current);
					if(endIndex > 0) {
						list.add(line.substring(current, endIndex));
						current = line.indexOf("http:", endIndex);
					}
					else
						current = -1;
				}
				
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		
		return list;
	}

}
