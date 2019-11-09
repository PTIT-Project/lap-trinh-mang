/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ltphong
 */

public class ServerCaro {

    /**
     * @param args the command line arguments
     */          static int port = 1000;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
                   
                 try{
	            ServerSocket serverSocket = new ServerSocket(8888); //Cai nay la tap port cho may chu Sever caro ne.
	            System.out.println("Khởi chạy máy chủ thành công");
	            while(true){ // true co nghia la no luon chay va cho ket noi
	                //Tạo Thread mới khi có 1 Client kết nối thành công
	                new ThreadSocket(serverSocket.accept(), port).start(); // co ket noi no se tao Thread va start. 
	                System.out.println("Có 1 kết nối đến");
                        port = port + 2;
	            }
	        }
	        catch(IOException e){
	            System.out.println("Exception: " +e.getMessage());
		}
	}
}
