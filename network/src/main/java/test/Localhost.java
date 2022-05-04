package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {

	//소켓프로그래밍
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName); //컴퓨터이름
			System.out.println(hostAddress); //첫번째 네트워크주소
		
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				//System.out.print((int)address);
				System.out.print(address & 0x000000ff);
				System.out.print(".");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
