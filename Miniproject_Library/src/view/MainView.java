package view;

import control.Controller;
import java.util.Scanner;


public class MainView {
// rental_info의 id_number , book_number 외래키다
	public static void main(String[] args) {
		Controller controller = Controller.getInstance();

		Scanner scan = new Scanner(System.in);
		int num=0;
		while(true) {
			controller.showMenue();
			System.out.print("정수를 입력 하시오 : ");
			num=scan.nextInt();
			switch(num) {
			case 1: 
//				모든 책 검색
				controller.showAllBook();
				break;
			case 2: 
//				// 모든 사람 검색
				
				controller.allPerson();
				break;
			case 3: 
//				// 빌려 갈 수 있는 책 검색		
				controller.borrowBooks();
				break;
			case 4:
				// 책이름으로 책검색
				controller.searchBooks();
				break;
			case 5: 
				// 대여 현황 전체 출력
				controller.borrowPerson();
				break;
			case 6: 
				//책 id와 유저 id로 책 빌리기 
				controller.borrowUseID();
				break;
			case 7: 
				// 대여 현황 코드로 책 반납
				controller.returnBook();
				break;
			case 8:
				System.out.println("프로그램 종료");
				return;
			default : break;
			}
		}
	}
}