package tending.minsockcontrol;

import java.lang.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.mod.*;
import java.net.*;
import java.io.*;

import tending.minsockcontrol.*;


public class Main implements Runnable{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static int port = 6666;
    public void run() {
        Log.info("[MinSockControl]: Listening on localhost:"+port);
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                clientSocket = serverSocket.accept();
                Log.info("[MinSockControl]: New client connected, " + clientSocket);
                Log.info("[MinSockControl]: Starting thread...");
                Client client = new Client();
                client.sock = clientSocket;
                client.out = new PrintWriter(clientSocket.getOutputStream(), true);
                client.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                Thread thread = new Thread(client);
                thread.start();
            }
        } catch (Exception e) {
            Log.err("[MinSockControl]: Exception: " + e);
        }
    }
}