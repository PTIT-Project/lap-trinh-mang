package servercaro;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.time.LocalDateTime;

public class ServerCaro {

	private static int port = 1000;
	// Time for logging
	public static LocalDateTime clock = LocalDateTime.now();

	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("[INFO] - Server has started successful - " + clock);
			while (true) { // Server always runs.
				/**
				 * Multi-thread to create multi-socket for multiple Clients connect at the same
				 * time.
				 */
				// if connect successful then start new thread.
				new ThreadSocket(serverSocket.accept(), port).start();

				System.out.println("[INFO] - A client has connected - " + clock);
				// Changing port
				port = port + 2;
			}
		} catch (BindException e) {
			System.err.println("[ERROR]: Hiện đã có một Server đang chạy trên cổng này rồi, thằng ngu! - " + clock);
		} catch (IOException e) {
			System.err.println("[ERROR]: " + e.getMessage() + " - " + clock);
		}
	}
}
