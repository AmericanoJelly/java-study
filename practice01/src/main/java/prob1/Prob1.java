package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("수를 입력하세요: ");
		int number = scanner.nextInt();
		if (number % 3 == 0) {
			System.out.print(number);
			System.out.print("은 3의 배수입니다.");
		} else{
			scanner.close();
			System.out.print(number);
			System.out.print("은 3의 배수가 아닙니다.");
		}
	}
}