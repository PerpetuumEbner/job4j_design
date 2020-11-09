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
                    do {
                        str = in.readLine();
                        if (str.contains("Exit")) {
                            socket.close();
                            runServer = false;
                        }
                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                            out.write("Hello, dear friend".getBytes());
                            System.out.println(str);
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                            out.write(str.getBytes());
                            System.out.println(str);
                        }
                    } while (!str.isEmpty());
                } catch (IOException e) {
                    System.out.println("The server is down.");
                }
            }
        }
    }
}