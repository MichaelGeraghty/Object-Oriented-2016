package ie.gmit.sw.server;

import java.io.*;
import java.net.*;
import java.util.*;
 
/**  When started allows one client to connect. It listens on port 8189.
*  It returns whatever a connected client sends.
*  It shuts down when the client sends a Bye line.
*
*/
public class Server{
 
  /**  Instantiates an instance of the SimpleServer class and initilaizes it.
  */
  public static void main(String[] args){
    Server simpleserver = new Server();
    simpleserver.init();
  }
 
  /**  Sets up a ServerSocket and listens on port 8189.
  */
  public void init(){
    ServerSocket serversocket = null;
    Socket socket = null;
    try{
      //establish a server socket monitoring port 8189 
      //port 8189 is not used by any services
      serversocket = new ServerSocket(7777);
      System.out.println("Listening at 127.0.0.1 on port 7777");
 
      //wait indefinitely until a client connects to the socket
      socket = serversocket.accept();
 
      //set up communications for sending and receiving lines of text data
      //establish a bufferedreaderr from the input stream provided by the socket object
      InputStreamReader inputstreamreader = new InputStreamReader(socket.getInputStream());
      BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
 
      //establish an printwriter using the output streamof the socket object
      //and set auto flush on    
      PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);
 
      //for binary data use
      // DataInputStream and DataOutputStream
 
      //for serialized objects use
      // ObjectInputStream and ObjectOutputStream
 
      String datetimestring = (Calendar.getInstance()).getTime().toString();
      printwriter.println("You are connected to the Server at " + datetimestring);
 
      String lineread = "";
      boolean done = false;
      while (((lineread = bufferedreader.readLine()) != null) && (!done)){
        System.out.println("Received from Client: " + lineread);
        printwriter.println("You sent: " + lineread);
        if (lineread.compareToIgnoreCase("EndTest") == 0) done = true;
      }
      System.out.println("You are connected.");
      bufferedreader.close();
      inputstreamreader.close();
      printwriter.close();
      //socket.close();
    }catch(UnknownHostException unhe){
      System.out.println("UnknownHostException: " + unhe.getMessage());
    }catch(InterruptedIOException intioe){
      System.out.println("Timeout while attempting to establish socket connection.");
    }catch(IOException ioe){
      System.out.println("IOException: " + ioe.getMessage());
    }finally{
      try{
        socket.close();
        serversocket.close();
      }catch(IOException ioe){
        System.out.println("IOException: " + ioe.getMessage());
      }
    }
  }
} 