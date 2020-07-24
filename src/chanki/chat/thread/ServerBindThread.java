package chanki.chat.thread;

import chanki.chat.main.SingletonClientList;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerBindThread extends Thread {
    ServerSocket socket;

    public ServerBindThread(ServerSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket acceptedSocket = socket.accept();
                System.out.println("연결되었습니다 [ " + acceptedSocket.getRemoteSocketAddress() + " ]");
                SingletonClientList.add(acceptedSocket);
                System.out.println(SingletonClientList.getClients().size() + "명 연결중");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
