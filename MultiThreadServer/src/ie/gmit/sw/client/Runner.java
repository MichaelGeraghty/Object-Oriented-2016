package ie.gmit.sw.client;

import java.io.*;
import java.net.Socket;

public class Runner{
	
	
	public static void main(String[] args) throws Throwable
	{	
		int option;
		do{
			
		option = UI.Menu();
		}while(option < 1 || option > 3);
		System.out.println(option);
	}
	
}


