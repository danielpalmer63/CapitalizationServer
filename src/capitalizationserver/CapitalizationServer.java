package capitalizationserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CapitalizationServer 
{
    public static void main(String[] args) 
    {
        System.out.println("Server: Starting...");        
        try
        {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server: Waiting for connection...");
            Socket clientSocket = server.accept();
            System.out.println("Connected to client");
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String inputLine;
            while ((inputLine = br.readLine()) != null) 
            {
                String capInput = inputLine.toUpperCase();
                System.out.println("Server: " + capInput);
                out.println(capInput);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    } 
}
