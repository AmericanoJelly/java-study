package prob02;

public class Book{
	
	private	int bookNo;
	private String title;
	private String author;
	private int stateCode = 1; //0: 대여중, 1: 재고 있음
	

	public Book(int bookNo,String title,String author) {
		this(bookNo, title, author, 1);
	}
	
	public Book(int bookNo,String title,String author,int stateCode) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = stateCode;
	}
	
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	public void print() {
		
		System.out.print(
				"책 제목: " + title + "," +
				"작가: " + author + "," + 
				"대여 유뮤: ");
		
		if(stateCode == 1) {
			System.out.println("재고있음");
		}else {
			System.out.println("대여중");
		}
	}
	
	public void rent() {
		System.out.println( title + "(가) 대여 됐습니다.");
	
	}


}
