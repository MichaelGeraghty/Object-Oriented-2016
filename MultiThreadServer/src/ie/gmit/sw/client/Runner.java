package ie.gmit.sw.client;

import ie.gmit.sw.server.Server;

public class Runner extends Thread{
	boolean running;
	public void run()
	  {
	   running=true;        
	   while(running)              // stop when running is false
	    {
		   Server.main(null);
	      try
	      {
	         Thread.sleep(1000);    // sleep for a time periold
	      }
	      catch (InterruptedException e)
	      {}
	   }
	  }
	
	public static void main(String[] args) throws Throwable
	{	
		int option;
		do{
			option = UI.Menu();
			
			if (option == 1){
				Runner thread1 = new Runner();
				
				thread1.start();
				sleep(1000);

				thread1.running=false;
				Connection.main(null);
			}
			else if (option == 2)
			{
				System.out.println("No files available yet");
			}
			else if (option == 3)
			{
				System.out.println("Choose file to be downloaded");				
			}
			else if (option == 4)
			{
				System.exit(0);
			}
			
		
		}while(option !=4);
		
		
	}
	
}


