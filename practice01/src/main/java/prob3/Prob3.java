package prob3;


import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		
		for (int i = 0; i < 3; i++) {
			
			System.out.print("숫자를 입력하세요: ");
			int number = scanner.nextInt();
			int Evensum = 0;
			int Oddsum = 0;

			if (number % 2 == 0) {
				for (int j = 2; j <= number; j += 2) {

					Evensum += j;

				}
				System.out.print("결과 값 : ");
				System.out.println(Evensum);
			} else {
				for (int j = 1; j <= number; j += 2) {

					Oddsum += j;

				}
				System.out.print("결과 값 : ");
				System.out.println(Oddsum);
			}
		}
		scanner.close();
	}
}