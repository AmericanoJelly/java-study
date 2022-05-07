package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				InetAddress[] address = InetAddress.getAllByName(line);
				
				for(int i=0; i<address.length; i++) {
					
				System.out.println(line+": "+address[i].getHostAddress());
				
				}
				
			} catch(UnknownHostException ex) {
				ex.printStackTrace();
			}	
		}
		scanner.close();
	}

}