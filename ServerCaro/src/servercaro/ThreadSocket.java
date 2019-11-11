package servercaro;

import java.io.*;
import java.net.*;

public class ThreadSocket extends Thread {

    Socket socket;
    int port;
    database db;
    address add;

    ThreadSocket(Socket pSocket, int i) {
        this.socket = pSocket;
        port = i;
        db = new database();
        // add = new address();
    }

    @Override
    public void run() {
        try {
            System.out.println("------------" + port);
            //Tạo luồng nhận dữ liệu từ bàn phím
            DataInputStream inFromServer = new DataInputStream(System.in);
            //Tạo luồng nhận dữ liệu từ Client
            DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
            //Tạo luồng gửi dữ liệu về Client
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String string = inFromClient.readLine();
                System.out.println(string);
                String[] ss = string.split("-");

                //KIỂM TRA ĐĂNG NHẬP
                if (ss[0].equals("1")) {

                    System.out.println("Username,Pwd:" + ss[1] + "," + ss[2]);
                    if (db.checkLogin(ss[1], ss[2])) {
                        outToClient.writeBytes("1\n");

                    } else {
                        outToClient.writeBytes("0\n");
                    }
                }

                /**
                 * ĐĂNG KÝ TÀI KHOẢN
                 */
                if (ss[0].equals("2")) {
                    String infor;
                    String account;
                    account = "INSERT INTO `mydb`.`user` (`username`, `password`) VALUES (?,?)";
                    infor = "INSERT INTO `mydb`.`user_infomation` (`hoten`, `ngaysinh`, `email`) VALUES (?,? ,?)";
                    //insert account
                    db.pst = db.con.prepareStatement(account);
                    db.pst.setString(1, ss[1]);
                    db.pst.setString(2, ss[2]);
                    db.pst.executeUpdate();
                    //insert informationf
                    db.pst = db.con.prepareStatement(infor);
                    db.pst.setString(1, ss[3]);
                    db.pst.setString(2, ss[4]);
                    db.pst.setString(3, ss[5]);
                    db.pst.executeUpdate();
                    db.pst.close();
                    outToClient.writeBytes("1\n");
                }

                /**
                 * TẠO PHÒNG
                 */
                if (ss[0].equals("3")) {
                    System.out.println("Một người chơi ở IP: '"+ss[2]+"' vừa tạo phòng.");
                    int port1 = port + 2;
                    add.port1.add(port);
                    add.port2.add(port1);
                    add.ip.add(ss[2]);
                    add.name.add(ss[1]);
                    String _string = ss[2]+"-" + port + "-" + port1;
                    System.out.println("IP tao Server gui ve Client: " + _string);
                    //gui address ve client
                    outToClient.writeBytes(_string + "\n");
                }

                /**
                 * THAM GIA PHÒNG
                 */
                if (ss[0].equals("4")) {

                    String _strPort1 = ""; //add.port1.get(0).toString();
                    //System.out.println(_strPort1);
                    String _strPort2 = ""; //add.port2.get(0).toString();
                    String _strIp = ""; // add.ip.get(0);
                    String _strName = ""; // add.name.get(0);
                    for (int i = 0; i < add.port1.size(); i++) {
                        _strPort1 = _strPort1 + add.port1.get(i) + "-";
                        _strPort2 = _strPort2 + add.port2.get(i) + "-";
                        _strIp = _strIp + add.ip.get(i) + "-";
                        _strName = _strName + add.name.get(i) + "-";
                    }

                    //System.out.println( _strPort1 + _strPort2 + _strIp);
                    outToClient.writeBytes(_strPort1 + "\n");
                    outToClient.writeBytes(_strPort2 + "\n");
                    outToClient.writeBytes(_strIp + "\n");
                    outToClient.writeBytes(_strName + "\n");
                    System.out.println(_strPort1);
                    System.out.println(_strPort2);
                    System.out.println(_strIp);
                    System.out.println(_strName);
                    String[] sss = _strName.split("-");
                    System.out.println(sss.length);
                    for (int i = 0; i < sss.length; i++) {
                        System.out.println(sss[i]);
                    }
                }
                if (ss[0].equals("5")) {
                    int j = 0;
                    for (j = 0; j < add.name.size(); j++) {
                        if (ss[1].equals(add.name.get(j))) {
                            break;
                        }
                    }
                    add.port1.remove(j);
                    add.port2.remove(j);
                    add.ip.remove(j);
                    add.name.remove(j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return address;
    }
}
