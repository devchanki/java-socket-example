package chanki.chat.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRecieveThread extends Thread{
    Socket socket;

    public ClientRecieveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String tmpString;
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(br.readLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
