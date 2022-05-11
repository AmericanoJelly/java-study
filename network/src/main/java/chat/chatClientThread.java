package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;


public class chatClientThread extends Thread {
	private Socket socket;
	
	public chatClientThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			while(true) {
				System.out.println(br.readLine());
			}
		} catch(SocketException ex) {
			System.out.println("종료");
		} catch(IOException e) {
			System.out.println("error: " + e);
		} 		
	}
}
