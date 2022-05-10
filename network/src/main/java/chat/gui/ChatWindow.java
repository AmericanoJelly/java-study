package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;


public class ChatWindow {

	private String name;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;
	

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		
		this.socket = socket;
		new chatClientThread().start();
	}

	public void show() {
		/**
		 * 1. UI 초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
	               finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
	}
	
	private void sendMessage() {
				
		String message = textField.getText();
		System.out.println("message: " + message);
		textField.setText("");
		textField.requestFocus();
	
		//chat client thread에서 서버로 부터 받은 메세지가 있다고 치고~~(가짜데이터)
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(name + ":" + message);
		textArea.append("\n");
	}

	private void finish() {
		
			System.out.println("소켓 닫기 or 빙나가기(QUIT) 프로토콜 구현");
			System.exit(0);
	}

	
	private class chatClientThread extends Thread{

		@Override
		public void run() {
			while(true) {
				 try {
					 	BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		                while(true) {
		                    String data = br.readLine();
		                    updateTextArea(data);   
		                }
		            }
		            catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		
			}
		}
	}

