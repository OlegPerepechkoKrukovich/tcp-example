package by.javaguru.socket.http;

public class HttpSeverRunner {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(8082,100);
        httpServer.run();
    }
}
