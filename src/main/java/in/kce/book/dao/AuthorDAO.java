package in.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.kce.book.bean.AuthorBean;
import in.kce.book.util.DBUtil;

public class AuthorDAO {
	public AuthorBean getAuthor(int authorCode) {
		 Connection connection = DBUtil.getDBConnection();
		 String query="Select * from author_tbl where author_code=?";
		 try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, authorCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AuthorBean authorbean = new AuthorBean();
				authorbean.setAuthorCode(rs.getInt(1));
				authorbean.setAuthorName(rs.getString(2));
				authorbean.setContactNo(rs.getLong(3));
				return authorbean;
			}
			else {
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
		 
		 
	
		
	}
	public AuthorBean getAuthor(String AuthorName) {
		 Connection connection = DBUtil.getDBConnection();
		 String query="Select * from author_tbl where author_name=?";
		 try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, AuthorName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AuthorBean authorbean = new AuthorBean();
				authorbean.setAuthorCode(rs.getInt(1));
				authorbean.setAuthorName(rs.getString(2));
				authorbean.setContactNo(rs.getLong(3));
				return authorbean;
			}
			else {
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
		 
		 
	
		
	
	
	
	

}
}
