package control;

import java.sql.SQLException;
import library.dto.BookDTO;
import library.dto.PersonDTO;
import library.dto.RentalinfoDTO;
import library.exception.NotExistException;
import service.RentalServiceImpl;

public class Controller {

private static Controller instance = new Controller();
private Controller() {};
public static Controller getInstance() {
	return instance;
}

	RentalServiceImpl service = RentalServiceImpl.getInstance();

	public void showAllBook() {
		System.out.println("========모든 책 검색==========");
		try {
			for(BookDTO book:service.getAllBooks()) {
				System.out.println(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void allPerson() {
		System.out.println("========모든 사람 검색==========");

		try {
			for(PersonDTO person:service.getAllPerson()) {
				System.out.println(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void borrowBooks() {
		System.out.println("========빌려 갈 수 있는 책 검색==========");
			try {
					for(BookDTO book : service.borrowBooks()) {
						System.out.println(book);
					}
			} catch ( NotExistException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void searchBooks() {
	System.out.println("========책 이름으로 책 검색==========");
	System.out.println("책이름 입력 : ");
	String str=service.getStrings();
		try {
			for(BookDTO book:service.searchBooks(str)) {
				System.out.println(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}catch (NotExistException e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void borrowPerson() {
	System.out.println("========대여 현황 전체 출력==========");
	try {
		for(RentalinfoDTO rentalinfo : service.getrentalinfo())
			
			System.out.println(rentalinfo);
			
	}catch (SQLException e) {
		e.printStackTrace();
	}catch (NotExistException e) {
		System.out.println(e.getMessage());
	}
	
	}
	

	public void borrowUseID() { 
		int bookId;
		int userId;
	System.out.println("========책 id와 유저 id로 책 빌리기 ==========");
	System.out.println("유저 ID 입력 : ");
	bookId = service.getInt();
	System.out.println("책 ID 입력 : ");
	userId = service.getInt();
		try {
			service.borrowUseID(bookId,userId);
			System.out.println("도서 대여가 완료되었습니다.");
			}
		 	catch (SQLException e) {e.printStackTrace();}
		catch (NotExistException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void returnBook() {
		System.out.println("rental_info_id 입력 : ");
		int rentalcode=service.getInt();
		try {
			service.returnBook(new RentalinfoDTO(rentalcode));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			System.out.println(e.getMessage());
		}
	System.out.println("========대여 현황 코드로 책 반납==========");
	}
	
	public void showMenue() {
		System.out.println("[ 메뉴 ]");
		System.out.println("1. 모든 책 검색");
		System.out.println("2. 모든 사람 검색");
		System.out.println("3. 빌려 갈 수 있는 책 검색	");	
		System.out.println("4. 책이름으로 책검색");
		System.out.println("5. 대여 현황 전체 출력");
		System.out.println("6. 책 id와 유저 id로 책 빌리기 ");
		System.out.println("7. 대여 현황 코드로 책 반납");
		System.out.println("8. 종료하기");
	}
	
	
}
