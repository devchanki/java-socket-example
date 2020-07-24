package chanki.chat.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

public class SingletonClientList {
    static Vector<ClientDTO> clientLists = new Vector<ClientDTO>();
    public static ExecutorService service;

    public static void setExcutorService(ExecutorService service) {
        SingletonClientList.service = service;
    }

    public static void add(Socket socket) {
        clientLists.add(new ClientDTO(socket));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (true) {
                        String tmp = br.readLine();
                        if (tmp != null) {
                            clientLists.stream().forEach((client) -> {
                                client.send(tmp);
                            });
                        }else {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        service.submit(runnable);
    }

    public static Vector<ClientDTO> getClients() {
        return clientLists;
    }

}
