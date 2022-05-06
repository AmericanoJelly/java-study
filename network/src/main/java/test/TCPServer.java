package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			// 	  Socket에 inetSocketAddress(IP Address + Port)를 바인딩한다.
			//    IPAddress(0.0.0.0) : 특정 호스트 IP를 바인딩 하지 않는다. wildcard
			// 	  backlog: 요청 queue(10)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5555 ), 10); 
			
			// 3. accept
			// 	  클라이언트로 부터 요청을 기다린다.
			Socket socket = serverSocket.accept(); //blocking
			
			//반대편 소켓
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetSocketAddress.getPort();
			
			System.out.println("[server] connected by client [ "+ remoteHostAddress + ": "+remoteHostPort +" ]");
			
			try {
			// 4. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			byte[] buffer = new byte[256];
			// 5. 데이터 읽기
			while(true) {
				is.read(buffer); //blocking
			}
			
			}catch(IOException ex) {
				System.out.println("[server] error: " + ex);
			}finally {
				socket.close();
			}
			
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
