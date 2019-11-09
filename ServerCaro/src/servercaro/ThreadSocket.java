package servercaro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ThreadSocket extends Thread {

	private Socket socket;
	private int port;
	private database db;
	private address add;

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
			// Tạo luồng nhận dữ liệu từ Server
			DataInputStream inFromServer = new DataInputStream(System.in);
			// Tạo luồng nhận dữ liệu từ Client
			DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
			// Tạo luồng gửi dữ liệu tới Client
			DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

			while (true) {
				String string = inFromClient.readLine();
				System.out.println(string);
				String[] ss = string.split("-");
				
				// Kiểm tra đăng nhập
				if (ss[0].equals("1")) {

					System.out.println("Username,Pwd:" + ss[1] + "," + ss[2]);
					if (db.checkLogin(ss[1], ss[2])) {
						outToClient.writeBytes("1\n");

					} else {
						outToClient.writeBytes("0\n");
					}
				}

				// Đăng ký thành viên
				if (ss[0].equals("2")) {
					String account = "INSERT INTO `caro`.`user` (`username`, `password`) VALUES (?,?)";
					String infor = "INSERT INTO `caro`.`user_infomation` (`hoten`, `ngaysinh`, `email`) VALUES (?,?,?)";
					// insert account
					db.pst = db.con.prepareStatement(account);
					db.pst.setString(1, ss[1]);
					db.pst.setString(2, ss[2]);
					db.pst.executeUpdate();

					// insert information
					db.pst = db.con.prepareStatement(infor);
					db.pst.setString(1, ss[3]);
					db.pst.setString(2, ss[4]);
					db.pst.setString(3, ss[5]);
					db.pst.executeUpdate();
					db.pst.close();
					outToClient.writeBytes("1\n");
				}
				
				// Tạo phòng chơi (Server)
				if (ss[0].equals("3")) {
					System.out.println("co nhay ao 3");
					int port1 = port + 1;
					add.port1.add(port);
					add.port2.add(port1);
					add.ip.add("127.0.0.1");
					add.name.add(ss[1]);
					String _string = "127.0.0.1-" + port + "-" + port1;
					// gui address ve client
					outToClient.writeBytes(_string + "\n");
				}
				
				// Tìm phòng chơi (Client)
				if (ss[0].equals("4")) {
					String _strPort1 = ""; // add.port1.get(0).toString();
					// System.out.println(_strPort1);
					String _strPort2 = ""; // add.port2.get(0).toString();
					String _strIp = ""; // add.ip.get(0);
					String _strName = ""; // add.name.get(0);
					for (int i = 0; i < add.port1.size(); i++) {
						_strPort1 = _strPort1 + add.port1.get(i) + "-";
						_strPort2 = _strPort2 + add.port2.get(i) + "-";
						_strIp = _strIp + add.ip.get(i) + "-";
						_strName = _strName + add.name.get(i) + "-";
					}

					// System.out.println( _strPort1 + _strPort2 + _strIp);
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
						if (ss[1].equals(add.name.get(j)))
							break;
					}
					add.port1.remove(j);
					add.port2.remove(j);
					add.ip.remove(j);
					add.name.remove(j);
				}
			}
		} catch (SocketException e) {
			System.out.printf("\n[WARNING]: Client kết nối ở cổng số "+port+" đã ngắt - "+ServerCaro.clock+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return address;
	}
}
