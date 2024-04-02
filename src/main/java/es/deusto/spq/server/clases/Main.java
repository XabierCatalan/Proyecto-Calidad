package es.deusto.spq.server.clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket sc = null;

        DataInputStream in;
        DataOutputStream out;


        final int PORT = 5000;


        try {
            server = new ServerSocket(PORT);
            System.out.println("servidor iniciado");

            while(true) {
                sc = server.accept();

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();
                System.out.println(mensaje);

                out.writeUTF("Hola Mundo desde el servidor");
                sc.close();
                System.out.println("Cliente desconectado");
            

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        
    }
    

    public static void crearJuego() {
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<String> regiones = new ArrayList<>();
        ArrayList<String> lateral = new ArrayList<>();
        ArrayList<String> arriba = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            int randomIndex = (int) (Math.random() * tipos.size());
            String tipo = tipos.get(randomIndex);
            arriba.add(tipo);
            tipos.remove(randomIndex);
        }


        
        // Rest of the code
    }
}




