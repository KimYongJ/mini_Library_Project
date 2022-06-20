package service;

import java.sql.SQLException;
import java.util.ArrayList;

import library.dto.BookDTO;
import library.dto.PersonDTO;
import library.dto.RentalinfoDTO;
import library.exception.NotExistException;

public interface RentalService {
	public ArrayList<BookDTO> getAllBooks() throws SQLException;
	public ArrayList<BookDTO> borrowBooks() throws NotExistException, SQLException;
	public int getborrow(RentalinfoDTO dto) throws SQLException;
	public ArrayList<PersonDTO> getAllPerson() throws SQLException;
	public  ArrayList<BookDTO> searchBooks(String str)throws SQLException, NotExistException;
	public ArrayList<RentalinfoDTO> getrentalinfo() throws SQLException, NotExistException;
	public void returnBook(RentalinfoDTO dto) throws SQLException, NotExistException ;
	public boolean borrowUseID(int userId,int bookId) throws SQLException, NotExistException;
	public  String getStrings();
	public  int getInt();
}
