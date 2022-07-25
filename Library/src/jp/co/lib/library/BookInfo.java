package jp.co.lib.library;

public class BookInfo {
	
//	本
//	-　ISBN
//	- 　題名
//	-　作者
//	-　出版社
//	-　出版年
//  -　状態(new!)
//	詳細（）

	private int isbnCode; //ISBN　13桁の数字
	private String name; //題名
	private String author; //作者
	private String publisher; //出版社
	private int year; //出版年
	private boolean status; //状態

	public BookInfo(int isbnCode, String name, String author, String publisher, int year, boolean status) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.isbnCode = isbnCode;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.status = status;
	}
	
    public BookInfo(int isbnCode, String name, String author, String publisher, int year) {
        this(isbnCode,name,author,publisher,year,true); //true(貸し出し可)
    }
	
    //セッター・ゲッター
	public int getCode() {
		return isbnCode;
	}
	
	public void setCode(int code) {
		this.isbnCode = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getStatus() {
		if(status) {
			return "□ 貸出可";
		}else {
			return "■ 貸出中";
		}
	}
	
	public boolean getStatus2() {
		return status;
	}
	
	public void setStatus(boolean status) {
		if(status) {
			status = false;
		}else {
			status = true;
		}
	}
}
