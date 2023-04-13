package Ejemplo1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PruebaSockets {

    public static void main(String[] args) {
        try {
            System.out.println("URL & Direccion IP: ");
            InetAddress direccion = InetAddress.getByName("www.udistrital.edu.co");
            System.out.println(direccion);
            System.out.println("Direccion IP: ");
            int temp = direccion.toString().indexOf('/');
            direccion = InetAddress.getByName(direccion.toString().substring(temp + 1));
            System.out.println(direccion);
            System.out.println("Nombre & Direccion IP actual de LocalHost");
            direccion = InetAddress.getLocalHost();
            System.out.println(direccion);
            System.out.println("Direccion IP del LocalHost: ");
            temp = direccion.toString().indexOf('/');
            direccion = InetAddress.getByName(direccion.toString().substring(temp + 1));
            System.out.println(direccion);
            System.out.println("Nombre actual de LocalHost");
            System.out.println(direccion.getHostName());
            System.out.println("Direccion IP actual de LocalHost");
            byte[] bytes = direccion.getAddress();
            for (int cnt = 0; cnt < bytes.length; cnt++) {
                int uByte = bytes[cnt] < 0 ? bytes[cnt] + 256 : bytes[cnt];
                System.out.print(uByte + " ");
            }

            System.out.println();
        } catch (UnknownHostException e) {
            System.out.println(e);
            System.out.println("Debes estar conectado para que esto funcione bien.");
        }
    }
}
