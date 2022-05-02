package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		//날짜를 다루는 클래스
		Date now = new Date(); //실행되었을때의 시간이 들어간다
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);
	}
	
	private static void printDate02(Date d) {
		// 년도(+1900)
		int year = d.getYear(); //deprecated 폐지된
		
		// 월(0~11, +1)
		int month = d.getMonth();
		
		// 일
		int date = d.getDate();
		
		// 시
		int hours = d.getHours();
		// 분
		int minutes = d.getMinutes();
		// 초
		int seconds = d.getSeconds();
		
		System.out.println(
				(year+1900) +"-"+
				(month+1) +"-"+
				((date < 10)?"0": "")+date+"-"+
				hours +":"+
				minutes +":"+
				seconds
		);
		
	}
	
	private static void printDate01(Date d) {
		//2022-05-02 10:55:07
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(d);
		
		System.out.println(date);
		
	}

}
