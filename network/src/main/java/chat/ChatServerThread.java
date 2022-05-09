package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer>listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetSocketAddress.getPort();
		
		ChatServer.log("connected by client [ "+ remoteHostAddress + ": "+remoteHostPort +" ]");
		
		try {
		//스트림얻기
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
		
		//요청처리
		while(true) {
			String request = bufferedReader.readLine();
			
			if(request == null) {
				ChatServer.log("클라이언트로 부터 연결 끊김");
				doQuit(printWriter);
				break;
			}
			
			String[] tokens = request.split(":");
			if("join".equals(tokens[0])) {
				doJoin(tokens[1],printWriter);
				
			} else if("message".equals(tokens[0])) {
				doMessage(tokens[1]);
				
			} else if("quit".equals(tokens[0])) {
				doQuit(printWriter);
				
			} else {
				ChatServer.log("error: 알수 없는 요청(" + tokens[0] + ")");
			}
		}
		
		}catch(SocketException ex) {
				System.out.println("[server] suddenly closed by client");
		}catch(IOException ex) {
				System.out.println("[server] error: " + ex);
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
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
		printWriter.flush();
	}
		
	//서버에 연결된 모든 클라이언트에 메시지 보내는 메소드
	private void broadcast( String data ) { 
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void doMessage(String data) {
	      broadcast(nickname + ":"+ data);
	   }

	private void doQuit(Writer writer) {
		removeWriter( writer );
		
		String data = nickname + "님이 퇴장 하였습니다.";
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
