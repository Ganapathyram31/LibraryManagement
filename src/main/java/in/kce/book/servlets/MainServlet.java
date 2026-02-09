package in.kce.book.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import in.kce.book.bean.BookBean;
import in.kce.book.dao.AuthorDAO;
import in.kce.book.service.Administrator;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		
		if("AddBook".equals(operation))
		{
			String result=addBook(request);
			if(result.equals("SUCCESS"))
			{
				response.sendRedirect(request.getContextPath() +"/Book.html");
			}
			else if(result.equals("INVALID"))
			{
				response.sendRedirect(request.getContextPath() +"/Invalid.html");
			}
			else
			{
				response.sendRedirect(request.getContextPath() +"/Failure.html");
			}
		}
		else if("Search".equals(operation))
		{
			String isbn=request.getParameter("isbn");
			BookBean bookBean=viewBook(isbn);
			if(bookBean == null)
			{
				response.sendRedirect(request.getContextPath() +"/Invalid.html");
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("book", bookBean);
				RequestDispatcher rd=request.getRequestDispatcher("ViewServlet");
				rd.forward(request, response);
			}
			 
		}
	}
		
		
	
	public String addBook(HttpServletRequest request) {
		Administrator administrator = new Administrator();
		String authorName = request.getParameter("authorName");
		String isbn = request.getParameter("isbn");
		String bookName = request.getParameter("bookName");
		char BookType = request.getParameter("bookType").charAt(0);
		String bookCost = request.getParameter("bookCost");
		
		BookBean bookbean = new BookBean();
		bookbean.setIsbn(isbn);
		bookbean.setBookName(bookName);
		bookbean.setBookType(BookType);
		bookbean.setAuthorBean(new AuthorDAO().getAuthor(authorName));
		bookbean.setCost(Float.parseFloat(bookCost));
		String result = administrator.addBook(bookbean);
		return result;
		
		
		
		
		
	}
	public BookBean viewBook(String isbn) {
		Administrator administrator = new Administrator();
		return administrator.viewBook(isbn);
	}

}
