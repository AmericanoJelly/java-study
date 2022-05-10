package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer>listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		//1. Remote Host Information
		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetSocketAddress.getPort();
		
		ChatServer.log("connected by client [ "+ remoteHostAddress + ": "+remoteHostPort +" ]");
		
		try {
		//2. 스트림 얻기
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
		
			//3. 요청 처리 
			while(true) {
				String request = br.readLine();
				
				if(request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				
				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1],pw);
					
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
					
				} else if("quit".equals(tokens[0])) {
					doQuit(pw);

				} 
			}
			}catch(IOException ex) {
					System.out.println(this.nickname + "님이 채팅방을 나갔습니다.");
			}
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname=nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		addWriter(writer);
		//ack
		PrintWriter printWriter = (PrintWriter)writer;
		printWriter.println("join:ok");
	}
		
	//서버에 연결된 모든 클라이언트에 메시지 보내는 메소드
	private void broadcast( String data ) { 
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				//printWriter.flush();
			}
		}
	}

	private void doMessage(String data) {
	      broadcast(this.nickname + ":"+ data);
	   }

	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = this.nickname + "님이 퇴장 하였습니다.";
		broadcast(data);	
	}
	

	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}

}
