package bubble_common;

import java.util.Scanner;

import bubble_service.BubbleService;
import bubble_service.BubbleServiceImpl2;

public class MainClass {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num;
		BubbleService service = new BubbleServiceImpl2();

		while (true) {
			System.out.println("1. 포장");
			System.out.println("2. 매장");
			System.out.println("3. 종료");
			num = input.nextInt();

			switch (num) {
			case 1:
				service.display();
				break;
			case 2:
				service.display();
				break;
			case 3:
				return;
			}
		}
	}
}