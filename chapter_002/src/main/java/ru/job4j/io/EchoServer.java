package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

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
                            str = "Hello, dear friend.";
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(str.getBytes());
                        }
                        if (str.contains("HTTP") && !(str.contains("Hello") || str.contains("Exit"))) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(str.substring(10, str.indexOf("HTTP")).getBytes());
                        }
                    } while (!str.isEmpty());
                } catch (IOException e) {
                    LOG.error("The server is down.", e);
                }
            }
        }
    }
}