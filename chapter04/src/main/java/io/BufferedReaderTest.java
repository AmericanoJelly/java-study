package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		
		//기반스트림
		try {
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			
		//보조스트림
			br = new BufferedReader(fr);
			
			int index = 0;
			String line = null;
			while((line = br.readLine()) != null){
				index++;
				System.out.println(index);
				System.out.println(":");
				System.out.println(line);
				System.out.println("");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't Open: "+ e);
		} catch (IOException e) {
			System.out.println("Can't Open: "+ e);
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
