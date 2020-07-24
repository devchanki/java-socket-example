package chanki.chat.main;

import chanki.chat.thread.ServerBindThread;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        ExecutorService executorService;
        ServerSocket serverSocket;

        executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        SingletonClientList.setExcutorService(executorService);
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));
            Thread serverThread = new ServerBindThread(serverSocket);
            executorService.submit(serverThread);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }



}
