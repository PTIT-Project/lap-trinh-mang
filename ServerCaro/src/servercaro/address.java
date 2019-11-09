/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

import java.util.Vector;

/**
 *
 * @author ltphong
 */
public class address {

    public static Vector<Integer> port1 = new Vector<Integer>();
    public static Vector<Integer> port2 = new Vector<Integer>();
    public static Vector<String> ip = new Vector<String>();
    public static Vector<String> name = new Vector<String>();
    public address(Integer port1, Integer port2, String ip)
    {
      this.port1.add(port1);
      this.port2.add(port2);
      this.ip.add(ip);
    }

    address() {
    }
}
