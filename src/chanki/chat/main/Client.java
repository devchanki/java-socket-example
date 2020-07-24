package chanki.chat.main;

import chanki.chat.thread.ClientRecieveThread;
import chanki.chat.thread.ClientSendThread;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = new Socket();
        System.out.println("**** 클라이언트가 시작되었습니다. ****");
        try {
            socket.connect(new InetSocketAddress("localhost", 5001));
            System.out.println("연결이 성공적으로 완료되었습니다." + socket.getRemoteSocketAddress());
            Thread send = new ClientSendThread(socket);
            Thread recieve = new ClientRecieveThread(socket);
            send.start();
            recieve.start();

        }catch (Exception e) {
            System.out.println("에러가 발생했습니다.");
            System.out.println(e.getLocalizedMessage());
            return;
        }

    }
}
