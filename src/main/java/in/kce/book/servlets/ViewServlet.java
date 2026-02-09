package in.kce.book.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import in.kce.book.bean.BookBean;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		BookBean bookbean =(BookBean)session.getAttribute("book");
		out.print("<html><body>");
		out.print("Book title" +bookbean.getBookName());
		out.print("Author Name:"+bookbean.getAuthorBean().getAuthorName());
		out.print("Author Contact:" +bookbean.getAuthorBean().getContactNo());
		out.print("book cost" +bookbean.getCost());
		out.print("Book Isbn" +bookbean.getIsbn());
		out.print("</body></html>");
	}

}
