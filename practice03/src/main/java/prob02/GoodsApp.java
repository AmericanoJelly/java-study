package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] datas = line.split(" ");
			
			String name = datas[0];
			int price = Integer.parseInt(datas[1]);
			int count = Integer.parseInt(datas[2]);
			
			System.out.println(name + ":" + price + ":" + count);
		}

		// 상품 출력
		
		// 자원정리
		scanner.close();
	}
}
