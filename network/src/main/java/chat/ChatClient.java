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
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
		
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					break;
				}else {
					pw.println(input);
					String data = br.readLine();
				}
				System.out.println("<< " + input);
			}	
		} catch (IOException e) {
			System.out.println("[client] error: "+e);
			}finally {	
				try {
					if(scanner != null) {
						scanner.close();
					}
					if(socket != null && !socket.isClosed()) {
					socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}			
}
