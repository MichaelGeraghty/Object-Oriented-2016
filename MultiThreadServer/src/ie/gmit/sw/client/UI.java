package ie.gmit.sw.client;

import ie.gmit.sw.server.Server;

import java.util.Scanner;

public class UI {
	static int option;
	
	public static int Menu(){
		
			System.out.println("1.Connect to Server");
			System.out.println("2.Print File Listing");
			System.out.println("3.Download File");
			System.out.println("4.Quit\n");
			System.out.println("Type Option [1-4]");
			Scanner console = new Scanner(System.in);
			
			option = console.nextInt();						
			
		return(option);
	}
}
