package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean runServer = true;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (runServer) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    if ((str = in.readLine()).equals("http://localhost:9000/?msg=Bye")) {
                        out.write("The server is down.\r\n\\".getBytes());
                        socket.close();
                        runServer = false;
                    } else {
                        while (!(str = in.readLine()).isEmpty()) {
                            System.out.println(str);
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}