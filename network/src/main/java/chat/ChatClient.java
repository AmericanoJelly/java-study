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

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
		
			while(true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					break;
				}else {
					//메시지처리
				}
				
		} catch (IOException e) {
			System.out.println("[client] error: "+e);
		}finally {
			//자원정리
		}
				public static void log(String log) {
					System.out.println("[Echo Client]" + log);
				}
}
