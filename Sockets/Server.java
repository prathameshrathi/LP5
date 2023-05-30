package com.sockets;
import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(5555);
		System.out.println("Server started");
		Socket s = ss.accept();
		System.out.println("Client connected");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		OutputStream os = s.getOutputStream();
		PrintWriter pw = new PrintWriter(os,true);
		InputStream is = s.getInputStream();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(is));
		String client="",server="";
		while(true) {
			client = br2.readLine();
			System.out.println("Client: "+client);
			if(client.equals("bye"))
            {
                break;
            }
            
            //Server writing its message
            System.out.print("Server: ");
            server = br.readLine();

            //print writer object sending the message to the socket through outputstream
            pw.println(server);
            if(server.equals("bye"))
            {
                break;
            }
		}
		s.close();
        ss.close();
        is.close();
        os.close();

        System.out.println("Connection Terminated");
	}
}
