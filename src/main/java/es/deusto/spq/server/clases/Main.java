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
            int randomLista = (int) (Math.random() * 2);
            String tipo = tipos.get(randomIndex);
            arriba.add(tipo);
            tipos.remove(randomIndex);
            if (randomLista == 0) {
                int randomTipo = (int) (Math.random() * tipos.size());
                String tipo1 = tipos.get(randomTipo);
                lateral.add(tipo1);
                tipos.remove(randomTipo);
            } else {
                int randomRegion = (int) (Math.random() * regiones.size());
                String region = regiones.get(randomRegion);
                lateral.add(region);
                regiones.remove(randomRegion);
            }
        }

        System.err.println("Arriba: " + arriba);
        System.err.println("Lateral: " + lateral);

        


        
        // Rest of the code hd
    }
}





