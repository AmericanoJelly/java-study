package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final int PORT = 9999;
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			
			// 2. socket 생성
			socket = new Socket();
			
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			
			// 4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:"+nickname);
			String data = br.readLine();
			
			if("join:ok".equals(data)) {
				System.out.println(nickname+"님이 입장하였습니다. 즐거운 채팅 되세요");
			}
				
			
			// 6. ChatClientReceiveThread 시작
			new chatClientThread(socket).start();
			
			// 7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					pw.println("quit");
					break;
				}else {
					// 9. 메시지 처리
					pw.println("message:" + input);
				}
			}	
		} catch (IOException e) {
			
			System.out.println("[client] error: "+e);
			
			}finally {	
					// 10. 자원정리
					if(scanner != null) {
						scanner.close();
					}
					
				}
		}
}			

