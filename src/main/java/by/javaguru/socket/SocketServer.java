package by.javaguru.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(8081);
             var socket = serverSocket.accept();
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var scanner = new Scanner(System.in)) {
            var request = inputStream.readUTF();
            while (!request.equals("exit")) {
                System.out.println("Клиент: " + request);
                outputStream.writeUTF(scanner.nextLine());
                request = inputStream.readUTF();
            }
        }
    }
}
