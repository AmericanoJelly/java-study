package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class ChatServer {
	private static final int PORT = 9990;
	private static final String SERVER_IP = "127.0.0.1";
	static List<Writer>listWriters = new ArrayList<Writer>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//서버 소켓 생성
			serverSocket = new ServerSocket();
			
			//바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT )); 
			log("연결기다림 " + hostAddress + ": " + PORT );
			
			//요청대기
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}
			
			}catch (IOException e) {
				System.out.println("[server] error: " + e);
			}finally {
				//자원정리
				try {
					if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[ChatServer]"+log);
	}
}

