package io.sim.Prova;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private OutputStream writer;    
    private InputStream reader;



    Client(String ip, int port) {
        try {
            socket =  new Socket(ip, port);
            writer = socket.getOutputStream();            
            reader = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SendMessage(String message) {
        try { 
            writer.write(message.getBytes());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Listen() {
        String message = "";
        try {
            if (reader.available() <= 0) {
                byte[] buffer = new byte[1024];
                int read = reader.read(buffer);
                if (read > 0) {
                    message = new String(buffer, 0, read);
                    return message;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public void Close() throws IOException {
        socket.close();
    }
}