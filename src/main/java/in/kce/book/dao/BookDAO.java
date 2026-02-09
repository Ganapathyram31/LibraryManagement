package in.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.kce.book.bean.BookBean;
import in.kce.book.util.DBUtil;

public class BookDAO {
	public int createBook(BookBean bookBean) {
		 Connection connection = DBUtil.getDBConnection();
		 String query="insert into Book_tbl values(?,?,?,?,?)";
		 try {
			PreparedStatement ps= connection.prepareStatement(query);
			
			ps.setString(1,bookBean.getIsbn());
			ps.setString(2,bookBean.getBookName());
			ps.setString(3,String.valueOf(bookBean.getBookType()));
			ps.setInt(4,bookBean.getAuthorBean().getAuthorCode());
			ps.setFloat(5, bookBean.getCost());
			int rows=ps.executeUpdate();
			if(rows==1) {
				return 1;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return 0;
		 
	}
	public BookBean fetchBook(String isbn) {
		 Connection connection = DBUtil.getDBConnection();
		 String query="Select * from book_tbl where isbn = ?";
		 try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				BookBean bookBean= new BookBean();
				bookBean.setIsbn(rs.getString(1));
				bookBean.setBookName(rs.getString(2));
				bookBean.setBookType(rs.getString(3).charAt(0));
				bookBean.setAuthorBean(new AuthorDAO().getAuthor(rs.getInt(4)));
				bookBean.setCost(rs.getFloat(5));
				return bookBean;
			}
			
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null; 
			
		 
		
	}
	

}
