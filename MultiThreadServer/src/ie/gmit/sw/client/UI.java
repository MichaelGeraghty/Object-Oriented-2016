package ie.gmit.sw.client;

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
			if (option == 1){
				
			}
			else if (option == 2)
			{
								
			}
			else if (option == 3)
			{
								
			}
			else if (option == 4)
			{
				System.exit(0);
			}
		
		return(option);
	}
}
