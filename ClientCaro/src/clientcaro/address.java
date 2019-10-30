package clientcaro;

import java.util.Vector;

public class address {

    public static Vector<Integer> port1 = new Vector<Integer>();
    public static Vector<Integer> port2 = new Vector<Integer>();
    public static Vector<String> ip = new Vector<String>();
    public static Vector<String> name = new Vector<String>();
    public address(Integer port1, Integer port2, String ip)
    {
      address.port1.add(port1);
      address.port2.add(port2);
      address.ip.add(ip);
    }

    address() {
    }
}
