package helloworld.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


public class Utils {

    public static boolean isHostConnectable(int port){

        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket socket = new Socket(address, port);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
