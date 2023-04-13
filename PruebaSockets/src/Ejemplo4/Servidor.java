package Ejemplo4;

import java.io.*;
import java.net.*;

class Servidor {

    int PUERTO = 5000;

    public int mayor(String[] datos) {
        int mayor = 0;
        int a = Integer.parseInt(datos[0]);
        int b = Integer.parseInt(datos[1]);
        int c = Integer.parseInt(datos[2]);

        if ((a >= b) && (a >= c)) {
            mayor = a;
        }
        if ((b >= a) && (b >= c)) {
            mayor = b;
        }
        if ((c >= b) && (c >= a)) {
            mayor = c;
        }
        return mayor;
    }

    public Servidor() {
        ServerSocket yo = null;
        Socket cliente = null;
        BufferedReader entrada;
        DataOutputStream salida;
        String llego;

        try {
            yo = new ServerSocket(5000);
            System.out.println("Socket escuchando en puerto 5000");

            cliente = yo.accept();
            System.out.println("Ya se conecto el cliente");
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            salida = new DataOutputStream(cliente.getOutputStream());
            String rta;
            llego = entrada.readLine();
            String[] datos = llego.split("-");

            salida.writeUTF(String.valueOf(mayor(datos)));
            System.out.println("Ya termine de recibir");

            entrada.close();
            cliente.close();
            yo.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] arg) {
        new Servidor();
    }
}