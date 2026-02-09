package in.kce.book.service;

import java.sql.Connection;

import in.kce.book.bean.BookBean;
import in.kce.book.dao.BookDAO;
import in.kce.book.util.DBUtil;

public class Administrator {
	  
	  BookDAO bookdao = new BookDAO();
	public String addBook(BookBean bookBean) {
		
		if(bookBean==null || 
				bookBean.getBookName().isEmpty() ||
				bookBean.getIsbn().isEmpty() || bookBean.getBookType()==' ' || 
				bookBean.getAuthorBean().getAuthorName().isEmpty() || 
				bookBean.getCost() == 0 ) {
			return "INVALID";
		}
		int result = bookdao.createBook(bookBean);
		if(result==1) {
		return "SUCCESS";
		}
		else {
			return "FAILURE";
		}
	}
	public BookBean viewBook(String isbn) {
		
		return bookdao.fetchBook(isbn);
			
		
	}
		
		
		
		
		


}
