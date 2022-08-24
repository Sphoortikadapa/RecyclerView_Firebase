Computer Networks Lab

Name : Sphoorti Kadapa
Class : TE-2
PRN : F18112028


Write a program to simulate Go back N and Selective Repeat Modes of 
Sliding Window Protocol in peer to peer mode and demonstrate the packets captured traces using Wireshark Packet Analyzer Tool for peer to peer mode 

import java.lang.System;
import java.net.*;
import java.io.*;

public class Client 
{
    static Socket connection;
    public static void main(String a[]) throws SocketException 
    {
        try {
            int v[] = new int[8];
            int n = 0;
            InetAddress addr = InetAddress.getByName("Localhost");
            System.out.println(addr);
            connection = new Socket(addr, 8011);

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            DataInputStream in = new DataInputStream(connection.getInputStream());

            int p = in.read();
            System.out.println("Number of frames to be sent is: " + p);
            for(int i = 0; i < p; i++) 
            {
                v[i] = in.read();
                System.out.println(v[i]);
            }
            v[5] = -1;

            for(int i = 0; i < p; i++)
            {
                System.out.println("Received frame is: " + v[i]);
            }
            
            for (int i = 0; i < p; i++)
            {
                if (v[i] == -1) 
                {
                    System.out.println("Request to retransmit from packet number " + (i+1));
                    n = i;
                    out.write(n);
                    out.flush();
                }
            }
            System.out.println();

            v[n] = in.read();
            System.out.println("Received frame is: " + v[n]);
            System.out.println("Stopping");
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*OUTPUT
Localhost/127.0.0.1
Number of frames to be sent is: 9
30
40
50
60
70
80
90
100
110
Received frame is: 30
Received frame is: 40
Received frame is: 50
Received frame is: 60
Received frame is: 70
Received frame is: -1
Received frame is: 90
Received frame is: 100
Received frame is: 110
Request to retransmit from packet number: 6

Received frame is: 80
Stopping
*/