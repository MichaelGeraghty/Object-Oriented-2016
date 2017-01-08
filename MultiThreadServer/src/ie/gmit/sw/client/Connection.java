package ie.gmit.sw.client;

import java.io.*;
import java.net.*;
 
public class Connection{
 
  String serverurl = "127.0.0.1";
  int serverport = 7777;
 
  /**  Instantiates an instance of the Connection class and initilaizes it.
  */
  public static void main(String[] args){
    Connection Connection = new Connection();
    Connection.init();
  }
 
  /**  Connects to the SimpleServer on port 8189 and sends a few demo lines
  *  to the server, and reads, displays the server reply,
  *  then issues a Bye command signaling the server to quit.
  */
  public void init(){
    Socket socket = null;    
    try{
      System.out.println("Connecting to " + serverurl + " on port " + serverport);
      socket = new Socket(serverurl,serverport);
      //Set socket timeout for 10000 milliseconds or 10 seconds just 
      //in case the host can't be reached
      socket.setSoTimeout(10000);
      System.out.println("Connected.");
      
      InputStreamReader inputstreamreader = new InputStreamReader(socket.getInputStream());
      BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
      //establish an printwriter using the output streamof the socket object
      //and set auto flush on    
      PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);
      printwriter.println("Testing connection!");
      printwriter.println("EndTest");
      String lineread = "";
      while ((lineread = bufferedreader.readLine()) != null){
        System.out.println("Received from Server: " + lineread);
      }
      System.out.println("Closing connection.");
      bufferedreader.close();
      inputstreamreader.close();
      printwriter.close();
      socket.close();
      System.exit(0);
 
    }catch(UnknownHostException unhe){
      System.out.println("UnknownHostException: " + unhe.getMessage());
    }catch(InterruptedIOException intioe){
      System.out.println();
    }catch(IOException ioe){
      System.out.println("IOException: " + ioe.getMessage());
    }finally{
      try{
        socket.close();
      }catch(IOException ioe){
        System.out.println("IOException: " + ioe.getMessage());
      }
    }
  }
}
