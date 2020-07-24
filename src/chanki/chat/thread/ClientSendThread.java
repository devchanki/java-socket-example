package chanki.chat.thread;

import java.io.*;
import java.net.Socket;

public class ClientSendThread extends Thread {
    Socket socket;

    public ClientSendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String str;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            while (true) {
                str = br.readLine();
                if (str != null) {
                    pr.println(str);
                    pr.flush();
                }

            }
//                pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
