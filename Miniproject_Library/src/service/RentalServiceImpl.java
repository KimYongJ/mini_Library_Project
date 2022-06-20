package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.AllDAO;
import library.dto.BookDTO;
import library.dto.PersonDTO;
import library.dto.RentalinfoDTO;
import library.exception.NotExistException;


public class RentalServiceImpl implements RentalService {
	public static RentalServiceImpl instance=new RentalServiceImpl();
	private RentalServiceImpl() {}
	public static RentalServiceImpl getInstance() {
		return instance;
	}
	
	
	public ArrayList<BookDTO> getAllBooks() throws SQLException  {
		return AllDAO.getAllBooks();
	}
	

	public ArrayList<BookDTO> borrowBooks() throws NotExistException, SQLException {
		ArrayList<BookDTO> bookDTO = AllDAO.borrowBooks();
		if(bookDTO.size() != 0) {
			return bookDTO;			
		}else {
			throw new NotExistException("빌릴 수 있는 책이 없습니다.");
		}
	}

	public int getborrow(RentalinfoDTO dto) throws SQLException {
		return AllDAO.getborrow(dto);
	}
	public ArrayList<PersonDTO> getAllPerson() throws SQLException{
		return AllDAO.getAllPerson();
	}
	

	public  ArrayList<BookDTO> searchBooks(String str)throws SQLException, NotExistException {
		ArrayList<BookDTO> bookDTO = AllDAO.searchBooks(str);
		if(bookDTO.size() != 0) {
			return bookDTO;			
		}else {
			throw new NotExistException("검색하신 책이 없습니다.");
		}		
	}
	public ArrayList<RentalinfoDTO> getrentalinfo() throws SQLException, NotExistException{
		ArrayList<RentalinfoDTO> bookDTO = AllDAO.getrentalinfo();
		if(bookDTO.size() != 0) {
			return bookDTO;			
		}else {
			throw new NotExistException("대여 현황이 없습니다.");
		}
		
	}
	
	public void returnBook(RentalinfoDTO dto) throws SQLException, NotExistException {
		int result = (AllDAO.getborrow(dto));
	
			if(AllDAO.returnBook(dto)) {
				AllDAO.updateBook(result);
				System.out.println("반납이 완료되었습니다.");
			}else {
				throw new NotExistException("입력하신 코드가 맞지 않습니다.");
			}
	}
	
	public boolean borrowUseID(int userId,int bookId) throws SQLException, NotExistException{
		if(AllDAO.flagReturn(bookId)) {
			AllDAO.borrowBooks(userId,bookId);
			AllDAO.changeFlag(bookId);
			return true;
		}else {
			throw new NotExistException("정보가 맞지 않거나 도서 수량이 없습니다.");
		}
	}

	public  String getStrings() {
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		return str;
	}

	public  int getInt() {
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		return num;		
	}
}
