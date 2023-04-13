package Ejemplo4;

import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] comandos) {
        Socket yo = null;
        PrintWriter alServidor;
        BufferedReader delTeclado;
        DataInputStream delServidor;
        String n1, n2, n3;

        try {
            try {
                yo = new Socket("localhost", 5000);
            } catch (UnknownHostException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            System.out.println("Ya se conecto al Servidor");
            delTeclado = new BufferedReader(new InputStreamReader(System.in));
            alServidor = new PrintWriter(yo.getOutputStream(), true);
            delServidor = new DataInputStream(yo.getInputStream());

            System.out.print("Digite el primer numero a comparar: ");
            n1 = delTeclado.readLine();
            System.out.print("Digite el segundo numero a comparar: ");
            n2 = delTeclado.readLine();
            System.out.print("Digite el tercer numero a comparar: ");
            n3 = delTeclado.readLine();

            alServidor.println(n1 + "-" + n2 + "-" + n3);
            System.out.println("Rta del Servidor = " + delServidor.readUTF());
            delServidor.close();
            delTeclado.close();
            alServidor.close();
            yo.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
