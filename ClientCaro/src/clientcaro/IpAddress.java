package clientcaro;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Tran Phuc
 */
public class IpAddress {

    public static String getIpAddress(){
        InetAddress ip = null;
        
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        
        return ip.getHostAddress().toString();
    }
    
}
