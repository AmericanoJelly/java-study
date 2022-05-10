package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	
	private static final int PORT = 9999;
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		
		
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한 글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();

		//1. create socket
		Socket socket = new Socket();
		
		try {
		//2. connect server
            socket.connect( new InetSocketAddress(SERVER_IP, PORT) );
            System.out.println("채팅방에 입장하였습니다.");
         
         //3. get iostream(pipline established)
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
            
          //4. join protocol 처리
            pw.println("join: " + name);
            String data = br.readLine();
            pw.println(data);
            
    		new ChatWindow(name, socket).show();
    		
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }			
}

