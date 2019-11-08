package clientcaro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.time.LocalDateTime;

public class ClientCaro {

	// Time for logging
	private static LocalDateTime clock = LocalDateTime.now();

	public static void main(String[] args) throws IOException {
		try {
			Socket ClientSocket = new Socket("localhost", 8888);
			System.out.println("Connected to server!");
			System.out.println(ClientSocket.getInetAddress());
			System.out.println(ClientSocket.getLocalSocketAddress());
			System.out.println(ClientSocket.getLocalPort());
			System.out.println(ClientSocket.getLocalAddress());

			// Tạo luồng nhận dữ liệu từ người chơi
			DataInputStream inFromUser = new DataInputStream(System.in);
			// Tạo luồng nhận dữ liệu từ Server
			DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream());
			// Tạo luồng gửi dữ liệu lên Server
			DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream());

			// Login on server
			LoginCaro logincaro = new LoginCaro(inFromServer, outToServer);
		} catch (IllegalStateException e) {
			System.out.println("[WARNING]: Có gì đấy không đúng trong Graphics - "+clock);
		} catch (ConnectException e) {
			System.err.printf("\n*\t*\t*\n[ERROR]: Không tìm thấy Server!!! - "+clock+"\n[INFO]: Đã bật Server chưa thế thằng ngu này?\n*\t*\t*\n");
		}
	}
}
