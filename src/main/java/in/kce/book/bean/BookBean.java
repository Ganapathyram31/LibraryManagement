package in.kce.book.bean;

public class BookBean {
	private String isbn;
	private String bookName;
	private AuthorBean AuthorBean;
	private char bookType;
	private float cost;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public AuthorBean getAuthorBean() {
		return AuthorBean;
	}
	public void setAuthorBean(AuthorBean authorBean) {
		AuthorBean = authorBean;
	}
	public char getBookType() {
		return bookType;
	}
	public void setBookType(char bookType) {
		this.bookType = bookType;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;	}
	
	
}