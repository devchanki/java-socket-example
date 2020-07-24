package chanki.chat.main;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class ClientDTO {
    Socket socket;

    public ClientDTO(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    void send(String message) {
        try{
            PrintWriter pr = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            pr.println(message);
            pr.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
