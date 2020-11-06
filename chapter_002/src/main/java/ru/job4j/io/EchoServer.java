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
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            socket.close();
                            runServer = false;
                        }
                        if (str.contains("Hello")) {
                            out.write("Hello, dear friend".getBytes());
                        } else {
                            out.write(str.getBytes());
                        }
                    } while (!str.isEmpty());
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                } catch (IOException e) {
                    System.out.println("The server is down.");
                }
            }
        }
    }
}