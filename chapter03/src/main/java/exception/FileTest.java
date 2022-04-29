package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
	static FileInputStream fis = null;
	
	public static void main(String[] args) {
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println((char) data);
		} catch (FileNotFoundException e) {
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
